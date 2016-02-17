package org.usfirst.frc.team79.robot.commands.teleop.manipulatorstate;

import org.usfirst.frc.team79.robot.subsystems.FiringMechanism;
import org.usfirst.frc.team79.robot.subsystems.IntakeMechanism;

import edu.wpi.first.wpilibj.Timer;

public class Firing implements State {
	
	FiringMechanism firingSystem;
	IntakeMechanism intakeSystem;
	
	boolean hasFired = false;
	
	public Firing(FiringMechanism firingSystem, IntakeMechanism intakeSystem) {
		this.firingSystem = firingSystem;
		this.intakeSystem = intakeSystem;
	}

	@Override
	public void execute() {
		
    	if(intakeSystem.getDistance() < 0f ){
    		intakeSystem.rotate(-0.75f);;
    	} else if(intakeSystem.getDistance() > 0.2) {
    		intakeSystem.rotate(0.75f);
    	} else if(intakeSystem.getDistance() > 0f || intakeSystem.getDistance() < 0.2f) {
    		intakeSystem.rotate(0);
    	}
		
		if(!firingSystem.isIntakeEmpty() && (intakeSystem.getDistance() > 0f || intakeSystem.getDistance() < 0.2f)) {
			firingSystem.setFireIntake(1.0);
		}
		
		if(firingSystem.isIntakeEmpty() && !firingSystem.isFired()) {
			firingSystem.setFired(true);
			Timer.delay(2.0);
			firingSystem.setFireIntake(0);
		}
		
	}

}
