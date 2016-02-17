package org.usfirst.frc.team79.robot.commands.teleop.drivingstate;

import org.usfirst.frc.team79.robot.OI;
import org.usfirst.frc.team79.robot.commands.teleop.Drive;
import org.usfirst.frc.team79.robot.utilities.State;

import edu.wpi.first.wpilibj.Timer;

public class ArcadeState implements State {
	
	Drive driveMechanism;
	double accelMoveX;
	double accelMoveY;
	double joyX;
	double joyY;
	
	public ArcadeState(Drive driveMechanism) {
		this.driveMechanism = driveMechanism;
	}

	@Override
	public void execute() {	
		
		// Fibonacci acceleration curve
		// when the drivers floor the throttle
		// its impossible to blow the main fuse
		// also I don't know how to spell Fibonacci
		// a google query has confirmed that I have indeed, spelled it correctly
		// huh, cool
		
		joyX = OI.getX();
		joyY = OI.getY();
		
		accelMoveX = (((joyX - accelMoveX) / 2) + accelMoveX);
		accelMoveY = (((joyY - accelMoveY) / 2) + accelMoveY);
		driveMechanism.arcadeDrive(accelMoveX, accelMoveY);
		
		Timer.delay(0.1);
		
	}

}
