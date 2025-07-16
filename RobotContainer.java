//Robot.java
package frc.robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.commands.RunMotors;

import frc.robot.subsystems.Inlet;
import frc.robot.subsystems.CoralHand; 

public class RobotContainer {

    // Subsystems
    private final Inlet m_inlet = new Inlet();
    private final CoralHand m_coralHand = new CoralHand(); 

    // Controllers
    private final XboxController m_driverController = new XboxController(0);

    // DIO Sensor
    private final DigitalInput m_stopSensor = new DigitalInput(0);

    // Commands
    private final RunMotors m_runMotors = new RunMotors(m_inlet, m_coralHand,500.0); 
   

    public RobotContainer() {
        configureButtonBindings();
    }

    private void configureButtonBindings() {
        // Toggle the Inlet motor on/off with Xbox Button A
        new Trigger(m_driverController::getAButton)
        .toggleOnTrue(m_runMotors);
        // Toggle the  motors on/off with Xbox Button A
       
    
        // Stop the motors if the DIO sensor is triggered
        new Trigger(m_stopSensor::get)
        .onFalse(new InstantCommand(() -> {
            m_inlet.stop();
            m_coralHand.stop();
              

    }));

    }
    public void teleopPeriodic() {
        // This method will be called once per scheduler run during teleop
        CommandScheduler.getInstance().run();
    }

    public Command getAutonomousCommand() {
        // No autonomous commands for this example
        return null; 
    }
}
