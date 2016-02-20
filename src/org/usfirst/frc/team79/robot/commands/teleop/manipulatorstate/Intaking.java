package org.usfirst.frc.team79.robot.commands.teleop.manipulatorstate;

import org.usfirst.frc.team79.robot.subsystems.FiringMechanism;
import org.usfirst.frc.team79.robot.subsystems.IntakeMechanism;
import org.usfirst.frc.team79.robot.utilities.State;

public class Intaking implements State {
	
	FiringMechanism firingSystem;
	IntakeMechanism intakeSystem;
	
	public Intaking(FiringMechanism firingMechanism, IntakeMechanism intakeSystem) {
		this.firingSystem = firingMechanism;
		this.intakeSystem = intakeSystem;
	}
 
	@Override
	public void execute() {
		
		// execute is the handshake between the state interface and this class
		// it lets every other object know it can call execute on a State
		// and it will be guaranteed to contain an execute method
		
		// now that we're intaking again, we say that a ball hasn't been fired
		// so we can than call our fire state and have it check the finished firing loop
		firingSystem.setFired(false);
		
//		 setting the distance rotated as a human readable value
		
		double armRotation = intakeSystem.getDistance();
		
		// if the rotation is less than 0.45, we rotate forward
		if(intakeSystem.getLimit()) {
			intakeSystem.rotate(0);
			intakeSystem.reset();
		} else {
		   	if(armRotation < 0.1 ){
				firingSystem.setFireIntake(0);
				intakeSystem.rotate(-1.0f);

			// if the rotation is less than 0.4, than we slow down some
			// to eliminate unwanted oscillation
	    		if(armRotation < 0.15) {
	    			intakeSystem.rotate(-0.9f);
	    		}

			// if the rotation is greater than 0.6, we rotate backwards
	    	}
		   	
		   	if(armRotation > -0.1) {

				intakeSystem.rotate(1.0f);

			// we do the same fidelity trick here too
	    		if(armRotation > -0.05) {
	    			intakeSystem.rotate(0.9f);
	    		}

			// lastly, we check if its in between these two conditions
			// and if it is, we stop
	    	} 
		   	
		   	if(armRotation > -0.1 && armRotation < 0.1) {
		    		intakeSystem.rotate(0f);
	    	}
		}
		
	   	// if the feed is empty, start intaking
		if(firingSystem.isIntakeEmpty()) {
			firingSystem.setFireIntake(-1.0);
		}
		
		// if we've got a ball, stop intaking
		if(firingSystem.isBallHeld()) {
			firingSystem.setFireIntake(0);	
		}
		
		
	}

}
