package org.usfirst.frc.team79.robot.commands.teleop.commands;

import org.usfirst.frc.team79.robot.subsystems.FiringMechanism;
import org.usfirst.frc.team79.robot.subsystems.PlowMechanism;
import org.usfirst.frc.team79.robot.utilities.State;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class Intaking implements State {
	
	FiringMechanism firingSystem;
	PlowMechanism intakeSystem;
	
	public Intaking(FiringMechanism firingMechanism, PlowMechanism intakeSystem) {
		this.firingSystem = firingMechanism;
		this.intakeSystem = intakeSystem;
	}
 
	@Override
	public void execute() {
		
		// execute is the handshake between the state interface and this class
		// it lets every other object know it can call execute on a State
		// and it will be guaranteed to contain an execute method
		
		// now that we're intaking again, we say that a ball hasn't been fired
		// so we can than call our fire state and have it check the finished firing loop
		
		intakeSystem.set(Value.kReverse);
		
	   	// if the feed is empty, start intaking
		if(firingSystem.isIntakeEmpty()) {
			firingSystem.setFireIntake(-1.0);
		}
		
		// if we've got a ball, stop intaking
		if(firingSystem.isBallHeld()) {
			firingSystem.setFireIntake(0);	
		}
		
		
	}

}
