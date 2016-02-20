package org.usfirst.frc.team79.robot.commands.teleop.manipulatorstate;

import org.usfirst.frc.team79.robot.subsystems.FiringMechanism;
import org.usfirst.frc.team79.robot.subsystems.IntakeMechanism;
import org.usfirst.frc.team79.robot.utilities.State;

public class PlowDown implements State {
	
	int speed;
	
	FiringMechanism firingSystem;
	IntakeMechanism intakeSystem;
	
	public PlowDown(FiringMechanism firingSystem, IntakeMechanism intakeSystem) {
		this.firingSystem = firingSystem;
		this.intakeSystem = intakeSystem;
	}
	
	// execute is the handshake between the state interface and this class
	// it lets every other object know it can call execute on a State
	// and it will be guaranteed to contain an execute method
	@Override
	public void execute() {

		// here we set a variable to be the current arm rotation's position
		double armRotation = intakeSystem.getDistance();
		
		// we set the firing motor to zero
		// because we're moving the plow over the shooter opening
		firingSystem.setFireIntake(0);
		
		// this bit should be straightforward to you now too
		// as to what it does
		// if you've read the firing class's comments
		// hopefully
    	if(armRotation < 0.8){
    		intakeSystem.rotate(-1.0f);
    	} else if(armRotation > 1.0) {
    		intakeSystem.rotate(1.0f);
    	} else if(armRotation > 0.8 && armRotation < 1.0) {
    		intakeSystem.rotate(0f); 
    	}
    	
	}

}
