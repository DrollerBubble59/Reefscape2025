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
    public void toLog(LogTable table) {}

    @Override
    public void fromLog(LogTable table) {}
  }

  default void updateInputs(ElevatorIOInputs inputs) {}

  default void runOpenLoop(double output) {}

  default void runPosition(double positionRads, double feedforwardVolts) {}

  default void stop() {}

  default void resetOrigin() {}

  default void setPID(double kP, double kI, double kD) {}

  default void setBrakeMode(boolean enabled) {}
}
