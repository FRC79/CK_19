package org.usfirst.frc.team79.robot.commands.teleop.manipulatorstate;

import org.usfirst.frc.team79.robot.subsystems.FiringMechanism;
import org.usfirst.frc.team79.robot.subsystems.IntakeMechanism;
import org.usfirst.frc.team79.robot.utilities.State;

// definitely check out the firing classes code
// that was written when I first started commenting all of this code
// and is guaranteed to be the most in depth of the state model

public class Calibrate implements State {
	
	FiringMechanism firingSystem;
	IntakeMechanism intakeSystem;
	
	// the constructor for this object creates a reference to the subsystem
	// that can be used from within the state, to do state related stuffs
	public Calibrate(FiringMechanism firingSystem, IntakeMechanism intakeSystem) {
		this.firingSystem = firingSystem;
		this.intakeSystem = intakeSystem;
	}

	// the execute method
	@Override
	public void execute() {
		
		// we're calibrating, no need to move the firing motor
		firingSystem.setFireIntake(0);
		
		// if the limitswitch near the top of the intake isn't broken
		// than rotate backwards at half the full speed of the motor
		if(!intakeSystem.getLimit()) {
			intakeSystem.rotate(0.5);
		// if the limit is broken, than we stop moving the arm
		// because it would just be beating up the frame at that point
		// and than we call this position the encoders new zero
		} else if(intakeSystem.getLimit()) {
			intakeSystem.rotate(0);
			intakeSystem.reset();
		}
		
	}

}
