package org.usfirst.frc.team79.robot.commands.teleop.manipulatorstate;

import org.usfirst.frc.team79.robot.subsystems.FiringMechanism;
import org.usfirst.frc.team79.robot.subsystems.IntakeMechanism;
import org.usfirst.frc.team79.robot.utilities.State;

public class PlowUp implements State {
	
	FiringMechanism firingSystem;
	IntakeMechanism intakeSystem;
	
	public PlowUp(FiringMechanism firingSystem, IntakeMechanism intakeSystem) {
		this.firingSystem = firingSystem;
		this.intakeSystem = intakeSystem;
	}

	@Override
	public void execute() {
		
		// I'm getting tired of typing
		// hopefully you just went through the manipulator state package alphabetically
		// and already got everything you needed out of it
		
		double armRotation = intakeSystem.getDistance();
		
		firingSystem.setFireIntake(0);
		
		if(intakeSystem.getLimit()) {
			intakeSystem.rotate(0);
			intakeSystem.reset();
		} else {
	    	if(armRotation < -0.1){
	    		intakeSystem.rotate(-1.0f);
	    	} else if(armRotation > 0.1) {
	    		intakeSystem.rotate(1.0f);
	    	} else if(armRotation < -0.1 && armRotation > 0.1) {
	    		intakeSystem.rotate(0f);
	    	}
		}
		

		
	}

}
