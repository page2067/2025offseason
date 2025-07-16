// subsystems/Inlet.java
package frc.robot.subsystems;

import com.ctre.phoenix6.configs.Slot0Configs;
// import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.VelocityVoltage;
import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Inlet extends SubsystemBase {
    private final TalonFX m_motor = new TalonFX(14); // CAN ID=14
    private final VelocityVoltage m_velocityControl = new VelocityVoltage(0);

    public Inlet() {
       

        // Configure PID constants
        Slot0Configs slot0Configs = new Slot0Configs();
        slot0Configs.kP = 0.1; // Placeholder: Tune this value
        slot0Configs.kI = 0.0; // Placeholder: Tune this value
        slot0Configs.kD = 0.0; // Placeholder: Tune this value
        slot0Configs.kV = 0.12; // Placeholder: Velocity Feedforward, assuming 12V max voltage and 100 RPS max velocity 
        m_motor.getConfigurator().apply(slot0Configs); 
    }

    public void run(double velocityRPM) {
        // Convert RPM to rotations per second (RPS) for Phoenix 6 
        double velocityRPS = velocityRPM / 60.0; 
        m_motor.setControl(m_velocityControl.withVelocity(velocityRPS)); // Set the target velocity 
    }

    public void stop() {
        m_motor.stopMotor(); // Stops the motor
    }
/*
    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }
*/
}
