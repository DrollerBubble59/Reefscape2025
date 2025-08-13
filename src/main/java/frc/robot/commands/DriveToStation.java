package frc.robot.commands;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Transform2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.util.Units;
import frc.robot.FieldConstants;
import frc.robot.RobotState;
import frc.robot.subsystems.drive.DriveBase;
import frc.robot.subsystems.drive.DriveConstants;
import frc.robot.util.AllianceFlipUtil;
import frc.robot.util.LoggedTunableNumber;
import java.util.ArrayList;
import java.util.List;
import java.util.function.DoubleSupplier;
import java.util.function.Supplier;
import org.littletonrobotics.junction.Logger;

public class DriveToStation extends DriveToPose {
  private static final LoggedTunableNumber stationAlignDistance =
      new LoggedTunableNumber(
          "DriveToStation/StationAlignDistance",
          DriveConstants.robotWidth / 2.0 + Units.inchesToMeters(6.5));

  public DriveToStation(DriveBase driveBase, boolean isAuto) {
    this(driveBase, () -> 0, () -> 0, () -> 0, isAuto);
  }

  public DriveToStation(
      DriveBase driveBase,
      DoubleSupplier driverX,
      DoubleSupplier driverY,
      DoubleSupplier driverOmega,
      boolean isAuto) {
    this(
        driveBase,
        () ->
            DriveCommands.getLinearVelocityFromJoysticks(
                    driverX.getAsDouble(), driverY.getAsDouble())
                .times(AllianceFlipUtil.shouldFlip() ? -1.0 : 1.0),
        () ->
            Math.copySign(
                Math.pow(
                    MathUtil.applyDeadband(driverOmega.getAsDouble(), DriveCommands.DEADBAND), 2.0),
                driverOmega.getAsDouble()),
        isAuto);
  }

  public DriveToStation(
      DriveBase driveBase, Supplier<Translation2d> linearFF, DoubleSupplier theta, boolean isAuto) {
    super(
        driveBase,
        () -> {
          Pose2d curPose = AllianceFlipUtil.apply(RobotState.getInstance().getEstimatedPose());

          List<Pose2d> finalPoses = new ArrayList<>();
          for (Pose2d stationCenter :
              new Pose2d[] {
                FieldConstants.CoralStation.leftCenterFace,
                FieldConstants.CoralStation.rightCenterFace
              }) {
            Transform2d offset = new Transform2d(stationAlignDistance.get(), 0.0, Rotation2d.kZero);
            finalPoses.add(stationCenter.transformBy(offset));
          }
          Logger.recordOutput(
              "DriveToStation/LeftClosestPose", AllianceFlipUtil.apply(finalPoses.get(0)));
          Logger.recordOutput(
              "DriveToStation/RightClosestPose", AllianceFlipUtil.apply(finalPoses.get(1)));
          return AllianceFlipUtil.apply(curPose.nearest(finalPoses));
        },
        RobotState.getInstance()::getEstimatedPose,
        linearFF,
        theta);
  }
}
