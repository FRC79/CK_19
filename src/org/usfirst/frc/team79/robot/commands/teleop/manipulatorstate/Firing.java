package org.usfirst.frc.team79.robot.commands.teleop.manipulatorstate;

import org.usfirst.frc.team79.robot.commands.teleop.Manipulate;

import edu.wpi.first.wpilibj.Timer;

public class Firing implements State {
	
	Manipulate manipulator;
	
	boolean hasFired = false;
	
	public Firing(Manipulate manipulator) {
		this.manipulator = manipulator;
	}

	@Override
	public void execute() {
		
    	if(manipulator.getIntakeRotation() < 0f ){
    		manipulator.rotateIntake(-0.75f);;
    	} else if(manipulator.getIntakeRotation() > 0.2) {
    		manipulator.rotateIntake(0.75f);
    	} else if(manipulator.getIntakeRotation() > 0f || manipulator.getIntakeRotation() < 0.2f) {
    		manipulator.rotateIntake(0);
    	}
		
		if(!manipulator.isIntakeEmpty() && (manipulator.getIntakeRotation() > 0f || manipulator.getIntakeRotation() < 0.2f)) {
			manipulator.setFireIntake(1.0);
		}
		
		if(manipulator.isIntakeEmpty() && !manipulator.hasFired()) {
			manipulator.setFired(true);
			Timer.delay(2.0);
			manipulator.setFireIntake(0);
		}
		
	}

}
