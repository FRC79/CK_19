package org.usfirst.frc.team79.robot.commands.teleop.manipulatorstate;

import org.usfirst.frc.team79.robot.subsystems.FiringMechanism;
import org.usfirst.frc.team79.robot.subsystems.PlowMechanism;
import org.usfirst.frc.team79.robot.utilities.State;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Timer;

public class Firing implements State {
	
	FiringMechanism firingSystem;
	PlowMechanism intakeSystem;
	
	double currentTime;
	
	boolean hasFired = false;
	
	// this constructor allows the subsystem objects to be referenced from inside this class
	public Firing(FiringMechanism firingSystem, PlowMechanism intakeSystem) {
		this.firingSystem = firingSystem;
		this.intakeSystem = intakeSystem;
	}

	@Override
	public void execute() {
		
		// execute is the handshake between the state interface and this class
		// it lets every other object know it can call execute on a State
		// and it will be guaranteed to contain an execute method
		
		intakeSystem.set(Value.kForward);

		if(!firingSystem.isIntakeEmpty()) {
			firingSystem.setFireIntake(1.0);
			currentTime = Timer.getFPGATimestamp();
		}
		
		// if the intake is empty, and the robot has not already fired a ball
		// we say that we've fired a ball
		// delay for 2 seconds to let everything clear the intake opening
		// than set the intake to zero
		// this boolean makes it so that the this loop doesn't keep getting called
		// because than there would be an unnecessary 2 second delay on every call to this commands execute 
		if(firingSystem.isIntakeEmpty()) {
			if(Timer.getFPGATimestamp() >= currentTime+2.0) {
				firingSystem.setFireIntake(0);
			}
		}
		
	}

}
