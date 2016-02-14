package org.usfirst.frc.team79.robot.commands.teleop.manipulatorstate;

import org.usfirst.frc.team79.robot.commands.teleop.Manipulate;

public class PlowUp implements State {
	
	Manipulate manipulator;
	
	public PlowUp(Manipulate manipulator) {
		this.manipulator = manipulator;
	}

	@Override
	public void execute() {
		
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
