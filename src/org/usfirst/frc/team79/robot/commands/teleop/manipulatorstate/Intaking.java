package org.usfirst.frc.team79.robot.commands.teleop.manipulatorstate;

import org.usfirst.frc.team79.robot.subsystems.FiringMechanism;
import org.usfirst.frc.team79.robot.subsystems.IntakeMechanism;

public class Intaking implements State {
	
	FiringMechanism firingSystem;
	IntakeMechanism intakeSystem;
	
	public Intaking(FiringMechanism firingMechanism, IntakeMechanism intakeSystem) {
		this.firingSystem = firingMechanism;
		this.intakeSystem = intakeSystem;
	}
 
	@Override
	public void execute() {
		
		firingSystem.setFired(false);
		
    	if(intakeSystem.getDistance() < 0.4 ){
    		if(intakeSystem.getDistance() < 0.45) {
    			intakeSystem.rotate(-0.2);
    		} else {
        		intakeSystem.rotate(-0.5f);
    		}
    	} else if(intakeSystem.getDistance() > 0.6) {
    		if(intakeSystem.getDistance() > 0.55) {
    			firingSystem.setFireIntake(0.2);
    		} else {
        		firingSystem.setFireIntake(0.5);
    		}
    	} else if(intakeSystem.getDistance() > 0.4 || intakeSystem.getDistance() < 0.6) {
    		intakeSystem.rotate(0);
    	}
		
		if(firingSystem.isIntakeEmpty()) {
			firingSystem.setFireIntake(-0.5);
		}
		
		if(firingSystem.isBallHeld()) {
			
			firingSystem.setFireIntake(0);
			
	    	if(intakeSystem.getDistance() < 0f){
	    		intakeSystem.rotate(-0.75f);
	    	} else if(intakeSystem.getDistance() > 0.2f) {
	    		intakeSystem.rotate(0.75f);
	    	} else if(intakeSystem.getDistance() > 0f || intakeSystem.getDistance() < 0.2f) {
	    		intakeSystem.rotate(0f);
	    	}
	    	
		}
		
		
	}

}
