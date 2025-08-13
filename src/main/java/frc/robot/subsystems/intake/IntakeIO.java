package frc.robot.subsystems.intake;

import org.littletonrobotics.junction.AutoLog;
import org.littletonrobotics.junction.LogTable;
import org.littletonrobotics.junction.inputs.LoggableInputs;

public interface IntakeIO {
  @AutoLog
  class IntakeIOInputs implements LoggableInputs {
    public boolean connected = false;

    public double positionRads;
    public double velocityRadsPerSec = 0.0;
    public double appliedVoltage = 0.0;
    public double currentAmps = 0.0;
    public double tempCelsius = 0.0;

    @Override
    public void toLog(LogTable table) {
      table.put("connected", connected);
      table.put("positionRads", positionRads);
      table.put("velocityRadsPerSec", velocityRadsPerSec);
      table.put("appliedVoltage", appliedVoltage);
      table.put("currentAmps", currentAmps);
      table.put("tempCelsius", tempCelsius);
    }

    @Override
    public void fromLog(LogTable table) {
      connected = table.get("connected", connected);
      positionRads = table.get("positionRads", positionRads);
      velocityRadsPerSec = table.get("velocityRadsPerSec", velocityRadsPerSec);
      appliedVoltage = table.get("appliedVoltage", appliedVoltage);
      currentAmps = table.get("currentAmps", currentAmps);
      tempCelsius = table.get("tempCelsius", tempCelsius);
    }
  }

  default void updateInputs(IntakeIOInputs inputs) {}

  default void runVolts(double output) {}

  default void stop() {}

  default void setBrakeMode(boolean enabled) {}
}
