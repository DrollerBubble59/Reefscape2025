package frc.robot.subsystems.drive;

import edu.wpi.first.math.geometry.Rotation2d;
import org.littletonrobotics.junction.AutoLog;
import org.littletonrobotics.junction.LogTable;
import org.littletonrobotics.junction.inputs.LoggableInputs;

public interface ModuleIO {

  @AutoLog

  public static class ModuleIOInputs implements LoggableInputs {
    public boolean driveConnected = false;
    public double drivePositionRad = 0.0;
    public double driveVelocityRadPerSec = 0.0;
    public double driveAppliedVolts = 0.0;
    public double driveCurrentAmps = 0.0;
    public double driveTempCelsius = 0.0;

    public boolean turnConnected = false;
    public Rotation2d turnAbsolutePosition = new Rotation2d();
    public Rotation2d turnPosition = new Rotation2d();
    public double turnVelocityRadPerSec = 0.0;
    public double turnAppliedVolts = 0.0;
    public double turnCurrentAmps = 0.0;
    public double turnTempCelsius = 0.0;

    public double[] odometryDrivePositionsRad = new double[] {};
    public Rotation2d[] odometryTurnPositions = new Rotation2d[] {};

    @Override
    public void toLog(LogTable table) {
      table.put("driveConnected", driveConnected);
      table.put("drivePositionRad", drivePositionRad);
      table.put("driveVelocityRadPerSec", driveVelocityRadPerSec);
      table.put("driveAppliedVolts", driveAppliedVolts);
      table.put("driveCurrentAmps", driveCurrentAmps);
      table.put("driveTempCelsius", driveTempCelsius);

      table.put("turnConnected", turnConnected);
      table.put("turnAbsolutePosition", turnAbsolutePosition);
      table.put("turnPosition", turnPosition);
      table.put("turnVelocityRadPerSec", turnVelocityRadPerSec);
      table.put("turnAppliedVolts", turnAppliedVolts);
      table.put("turnCurrentAmps", turnCurrentAmps);
      table.put("turnTempCelsius", turnTempCelsius);

      table.put("odometryDrivePositionsRad", odometryDrivePositionsRad);
      table.put("odometryTurnPositions", odometryTurnPositions);
    }

    @Override
    public void fromLog(LogTable table) {
      driveConnected = table.get("driveConnected", driveConnected);
      drivePositionRad = table.get("drivePositionRad", drivePositionRad);
      driveVelocityRadPerSec = table.get("driveVelocityRadPerSec", driveVelocityRadPerSec);
      driveAppliedVolts = table.get("driveAppliedVolts", driveAppliedVolts);
      driveCurrentAmps = table.get("driveCurrentAmps", driveCurrentAmps);
      driveTempCelsius = table.get("driveTempCelsius", driveTempCelsius);

      turnConnected = table.get("turnConnected", turnConnected);
      turnAbsolutePosition = table.get("turnAbsolutePosition", turnAbsolutePosition);
      turnPosition = table.get("turnPosition", turnPosition);
      turnVelocityRadPerSec = table.get("turnVelocityRadPerSec", turnVelocityRadPerSec);
      turnAppliedVolts = table.get("turnAppliedVolts", turnAppliedVolts);
      turnCurrentAmps = table.get("turnCurrentAmps", turnCurrentAmps);
      turnTempCelsius = table.get("turnTempCelsius", turnTempCelsius);

      odometryDrivePositionsRad = table.get("odometryDrivePositionsRad", odometryDrivePositionsRad);
      odometryTurnPositions = table.get("odometryTurnPositions", odometryTurnPositions);
    }


    public void toLog(LogTable table) {}

    @Override
    public void fromLog(LogTable table) {}

  }

  /** Updates the set of loggable inputs. */
  public default void updateInputs(ModuleIOInputs inputs) {}

  /** Run the drive motor at the specified open loop value. */
  public default void runDriveOpenLoop(double output) {}

  /** Run the turn motor at the specified open loop value. */
  public default void runTurnOpenLoop(double output) {}

  /** Run the drive motor at the specified velocity. */
  public default void runDriveVelocity(double velocityRadPerSec) {}

  /** Run the turn motor to the specified rotation. */
  public default void runTurnPosition(Rotation2d rotation) {}

  /** Set P, I, and D gains for closed loop control on drive motor. */
  public default void setDrivePID(double kP, double kI, double kD, double IZone) {}

  /** Set kS, kV gains for closed loop control on drive motor. */
  public default void setDriveFF(double kS, double kV) {}

  /** Set P, I, and D gains for closed loop control on turn motor. */
  public default void setTurnPID(double kP, double kI, double kD) {}

  /** Set brake mode on drive motor */
  public default void setDriveBrakeMode(boolean enabled) {}
}
