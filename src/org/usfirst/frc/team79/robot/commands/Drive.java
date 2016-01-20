package org.usfirst.frc.team79.robot.commands;

import org.usfirst.frc.team79.robot.OI;

public class TankDrive extends CommandBase {
	
	boolean toggle;
	
	@Override
	protected void initialize() {
		requires(driveTrain);
	}

	@Override
	protected void execute() {
		
		if(OI.toggle.get()) {
			toggle = !toggle; // flippity floppity
			Timer.delay(1.0); // waits for the driver to release the button
		}
		
		if(toggle) {
			driveTrain.moveTank(OI.getLeft(), OI.getRight());
		} else if(!toggle) {
			driveTrain.moveArcade(OI.getY(), OI.getX());
		}
		
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		
	}

	@Override
	protected void interrupted() {
		
	}

}
