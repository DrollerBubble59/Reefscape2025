package frc.robot.subsystems.elevator;

import org.littletonrobotics.junction.AutoLog;
import org.littletonrobotics.junction.LogTable;
import org.littletonrobotics.junction.inputs.LoggableInputs;

public interface ElevatorIO {
  @AutoLog
  public class ElevatorIOInputs implements LoggableInputs {
    public boolean leaderConnected = false;
    public boolean followerConnected = false;

    public double positionRads = 0.0;
    public double velocityRadPerSec = 0.0;
    public double[] appliedVolts = new double[] {};
    public double[] currentAmps = new double[] {};
    public double[] tempCelsius = new double[] {};

    @Override
    public void toLog(LogTable table) {
      table.put("leaderConnected", leaderConnected);
      table.put("followerConnected", followerConnected);
      table.put("positionRads", positionRads);
      table.put("velocityRadPerSec", velocityRadPerSec);
      table.put("appliedVolts", appliedVolts);
      table.put("currentAmps", currentAmps);
      table.put("tempCelsius", tempCelsius);
    }

    @Override
    public void fromLog(LogTable table) {
      leaderConnected = table.get("leaderConnected", leaderConnected);
      followerConnected = table.get("followerConnected", followerConnected);
      positionRads = table.get("positionRads", positionRads);
      velocityRadPerSec = table.get("velocityRadPerSec", velocityRadPerSec);
      appliedVolts = table.get("appliedVolts", appliedVolts);
      currentAmps = table.get("currentAmps", currentAmps);
      tempCelsius = table.get("tempCelsius", tempCelsius);
    }
  }

  default void updateInputs(ElevatorIOInputs inputs) {}

  default void runOpenLoop(double output) {}

  default void runPosition(double positionRads, double feedforwardVolts) {}

  default void stop() {}

  default void resetOrigin() {}

  default void setPID(double kP, double kI, double kD) {}

  default void setBrakeMode(boolean enabled) {}
}
