package org.usfirst.frc.team79.robot.commands.teleop.manipulatorstate;

import org.usfirst.frc.team79.robot.subsystems.FiringMechanism;
import org.usfirst.frc.team79.robot.subsystems.PlowMechanism;
import org.usfirst.frc.team79.robot.utilities.State;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class PlowDown implements State {
	
	int speed;
	
	FiringMechanism firingSystem;
	PlowMechanism intakeSystem;
	
	public PlowDown(FiringMechanism firingSystem, PlowMechanism intakeSystem) {
		this.firingSystem = firingSystem;
		this.intakeSystem = intakeSystem;
	}
	
	// execute is the handshake between the state interface and this class
	// it lets every other object know it can call execute on a State
	// and it will be guaranteed to contain an execute method
	@Override
	public void execute() {
		
		firingSystem.setFireIntake(0);
		
		intakeSystem.set(Value.kReverse);
		
	}

}
