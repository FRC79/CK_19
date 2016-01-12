package org.usfirst.frc.team79.robot.commands;

import org.usfirst.frc.team79.robot.OI;

public class TankDrive extends CommandBase {

	@Override
	protected void initialize() {
		requires(driveTrain);
	}

	@Override
	protected void execute() {
		driveTrain.move(OI.getLeft(), OI.getRight());
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
