// commands/RunMotors.java
package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Inlet;
import frc.robot.subsystems.CoralHand;

public class RunMotors extends Command {

    private final Inlet m_inlet;
    private final CoralHand m_coralHand;
    private final double m_targetRPM;

    public RunMotors(Inlet inlet, CoralHand coralHand, double targetRPM) {
        m_inlet = inlet;
        m_coralHand = coralHand;
        m_targetRPM = targetRPM;
        addRequirements(inlet, coralHand); // Declare the subsystems required
    }
    

    @Override
    public void initialize() {
        m_inlet.run(m_targetRPM); // Start the inlet motor at the target RPM
        m_coralHand.run(m_targetRPM); // Start the coral hand motor at the target RPM
    }

    @Override
    public void execute() {
        // No continuous actions needed in this example, as velocity control is handled by the motor controller
    }

    @Override
    public void end(boolean interrupted) {
        m_inlet.stop(); // Stop the motor when the command ends 
        m_coralHand.stop(); // Stop the coral hand motor when the command ends
    }

    @Override
    public boolean isFinished() {
        return false; // The command runs indefinitely until interrupted or toggled off 
    }
}
