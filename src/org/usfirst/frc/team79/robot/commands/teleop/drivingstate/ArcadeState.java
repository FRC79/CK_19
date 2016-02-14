package org.usfirst.frc.team79.robot.commands.teleop.drivingstate;

import org.usfirst.frc.team79.robot.OI;
import org.usfirst.frc.team79.robot.commands.teleop.Drive;

import edu.wpi.first.wpilibj.Timer;

public class ArcadeState implements State {
	
	boolean buttonToggle = false;
	
	double currentSpeedY;
	double currentSpeedX;
	double joyX;
	double joyY;
	
	Drive driveMechanism;
	
	public ArcadeState(Drive driveMechanism) {
		this.driveMechanism = driveMechanism;
	}

	@Override
	public void execute() {	
		
		joyX = OI.getX();
		joyY = OI.getY();
		
		currentSpeedX = (((joyX - currentSpeedX) / 2) + currentSpeedX);
		currentSpeedY = (((joyY - currentSpeedY) / 2) + currentSpeedY);
		
		driveMechanism.arcadeDrive(currentSpeedY, currentSpeedX);
		
		Timer.delay(0.1f);
		
	}

}
