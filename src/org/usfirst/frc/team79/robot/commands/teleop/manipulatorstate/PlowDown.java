package org.usfirst.frc.team79.robot.commands.teleop.manipulatorstate;

import org.usfirst.frc.team79.robot.subsystems.FiringMechanism;
import org.usfirst.frc.team79.robot.subsystems.IntakeMechanism;

public class PlowDown implements State {
	
	FiringMechanism firingSystem;
	IntakeMechanism intakeSystem;
	
	public PlowDown(FiringMechanism firingSystem, IntakeMechanism intakeSystem) {
		this.firingSystem = firingSystem;
		this.intakeSystem = intakeSystem;
	}

	@Override
	public void execute() {
		
		firingSystem.setFireIntake(0);
		
    	if(intakeSystem.getDistance() < 0.7){
    		intakeSystem.rotate(-0.75f);
    	} else if(intakeSystem.getDistance() > 0.9f) {
    		intakeSystem.rotate(0.75f);
    	} else if(intakeSystem.getDistance() > 0.7f || intakeSystem.getDistance() < 0.9f) {
    		intakeSystem.rotate(0f);
    	}
	}

}
