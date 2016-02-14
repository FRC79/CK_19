package org.usfirst.frc.team79.robot.commands.teleop.manipulatorstate;

import org.usfirst.frc.team79.robot.commands.teleop.Manipulate;

public class PlowDown implements State {
	
	Manipulate manipulator;
	
	public PlowDown(Manipulate manipulator) {
		this.manipulator = manipulator;
	}

	@Override
	public void execute() {
		
		manipulator.setFireIntake(0);
		
    	if(manipulator.getIntakeRotation() < 0.7){
    		manipulator.rotateIntake(-0.75f);
    	} else if(manipulator.getIntakeRotation() > 0.9f) {
    		manipulator.rotateIntake(0.75f);
    	} else if(manipulator.getIntakeRotation() > 0.7f || manipulator.getIntakeRotation() < 0.9f) {
    		manipulator.rotateIntake(0f);
    	}
	}

}
