package org.usfirst.frc.team79.robot.commands.teleop.manipulatorstate;

import org.usfirst.frc.team79.robot.commands.teleop.Manipulate;

public class Intaking implements State {
	
	Manipulate manipulator;
	
	public Intaking(Manipulate manipulator) {
		this.manipulator = manipulator;
	}
 
	@Override
	public void execute() {
		
		manipulator.setFired(false);
		
    	if(manipulator.getIntakeRotation() < 0.4 ){
    		if(manipulator.getIntakeRotation() < 0.45) {
    			manipulator.rotateIntake(-0.2);
    		} else {
        		manipulator.rotateIntake(-0.5f);
    		}
    	} else if(manipulator.getIntakeRotation() > 0.6) {
    		if(manipulator.getIntakeRotation() > 0.55) {
    			manipulator.setFireIntake(0.2);
    		} else {
        		manipulator.rotateIntake(0.5);
    		}
    	} else if(manipulator.getIntakeRotation() > 0.4 || manipulator.getIntakeRotation() < 0.6) {
    		manipulator.rotateIntake(0f);
    	}
		
		if(manipulator.isIntakeEmpty()) {
			manipulator.setFireIntake(-0.5);
		}
		
		if(manipulator.isBallHeld()) {
			
			manipulator.setFireIntake(0);
			
	    	if(manipulator.getIntakeRotation() < 0f){
	    		manipulator.rotateIntake(-0.75f);
	    	} else if(manipulator.getIntakeRotation() > 0.2f) {
	    		manipulator.rotateIntake(0.75f);
	    	} else if(manipulator.getIntakeRotation() > 0f || manipulator.getIntakeRotation() < 0.2f) {
	    		manipulator.rotateIntake(0f);
	    	}
	    	
		}
		
		
	}

}
