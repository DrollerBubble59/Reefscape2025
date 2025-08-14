package frc.robot.subsystems.drive;

import edu.wpi.first.math.geometry.Rotation2d;
import org.littletonrobotics.junction.LogTable;
import org.littletonrobotics.junction.inputs.LoggableInputs;

public interface GyroIO {
  public static class GyroIOInputs implements LoggableInputs {
    public boolean connected = false;

    public Rotation2d yawPosition = Rotation2d.kZero;
    public double yawVelocityRadPerSec = 0.0;
    public Rotation2d pitchPosition = Rotation2d.kZero;
    public double pitchVelocityRadPerSec = 0.0;
    public Rotation2d rollPosition = Rotation2d.kZero;
    public double rollVelocityRadPerSec = 0.0;

    public Rotation2d[] odometryYawPositions = new Rotation2d[] {};

    @Override
    public void toLog(LogTable table) {
      table.put("connected", connected);
      table.put("yawPosition", yawPosition);
      table.put("yawVelocityRadPerSec", yawVelocityRadPerSec);
      table.put("pitchPosition", pitchPosition);
      table.put("pitchVelocityRadPerSec", pitchVelocityRadPerSec);
      table.put("rollPosition", rollPosition);
      table.put("rollVelocityRadPerSec", rollVelocityRadPerSec);
      table.put("odometryYawPositions", odometryYawPositions);
    }

    @Override
    public void fromLog(LogTable table) {
      connected = table.get("connected", connected);
      yawPosition = table.get("yawPosition", yawPosition);
      yawVelocityRadPerSec = table.get("yawVelocityRadPerSec", yawVelocityRadPerSec);
      pitchPosition = table.get("pitchPosition", pitchPosition);
      pitchVelocityRadPerSec = table.get("pitchVelocityRadPerSec", pitchVelocityRadPerSec);
      rollPosition = table.get("rollPosition", rollPosition);
      rollVelocityRadPerSec = table.get("rollVelocityRadPerSec", rollVelocityRadPerSec);
      odometryYawPositions = table.get("odometryYawPositions", odometryYawPositions);
    }
  }

  public default void updateInputs(GyroIOInputs inputs) {}
}
