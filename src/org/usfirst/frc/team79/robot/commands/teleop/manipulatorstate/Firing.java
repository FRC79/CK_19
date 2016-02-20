package org.usfirst.frc.team79.robot.commands.teleop.manipulatorstate;

import org.usfirst.frc.team79.robot.subsystems.FiringMechanism;
import org.usfirst.frc.team79.robot.subsystems.IntakeMechanism;
import org.usfirst.frc.team79.robot.utilities.State;

import edu.wpi.first.wpilibj.Timer;

public class Firing implements State {
	
	FiringMechanism firingSystem;
	IntakeMechanism intakeSystem;
	
	double currentTime;
	
	boolean hasFired = false;
	
	// this constructor allows the subsystem objects to be referenced from inside this class
	public Firing(FiringMechanism firingSystem, IntakeMechanism intakeSystem) {
		this.firingSystem = firingSystem;
		this.intakeSystem = intakeSystem;
	}

	@Override
	public void execute() {
		
		// execute is the handshake between the state interface and this class
		// it lets every other object know it can call execute on a State
		// and it will be guaranteed to contain an execute method
		
		// the rotational value of the arm currently.
		// value is currently arbitrary, as the arm goes through a gear change
		// 1.0 means that the motor driving the arm has made one full rotation
		
		
//		double armRotation = intakeSystem.getDistance();
		
		
		// if at any iteration, the limit switch is pressed, than we reset the encoder
//		if(intakeSystem.getLimit()) {
//			intakeSystem.reset();
//		}
//		
//		// if the rotation is less than negative 0.1, than we rotate the system forward
//    	if(armRotation < -0.1){
//    		intakeSystem.rotate(-0.75f);;
//		// if the rotation is greater than 0.1, than we rotate the arm backward
//    	} else if(armRotation > 0.1) {
//    		intakeSystem.rotate(0.75f);
//		// if the value is in between these two, than we stop the rotator
//    	} else if(armRotation > -0.1 && armRotation < 0.1) {
//    		intakeSystem.rotate(0);
//    	}
		
    	// if the intake is not empty, and the arm is in position, than we fire
		if(!firingSystem.isIntakeEmpty()) {
			firingSystem.setFireIntake(1.0);
			currentTime = Timer.getFPGATimestamp();
		}
		
		// if the intake is empty, and the robot has not already fired a ball
		// we say that we've fired a ball
		// delay for 2 seconds to let everything clear the intake opening
		// than set the intake to zero
		// this boolean makes it so that the this loop doesn't keep getting called
		// because than there would be an unnecessary 2 second delay on every call to this commands execute 
		if(firingSystem.isIntakeEmpty() && !firingSystem.isFired()) {
			firingSystem.setFired(true);
			if(Timer.getFPGATimestamp() >= currentTime+2.0) {
				firingSystem.setFireIntake(0);
			}
		}
		
	}

}
