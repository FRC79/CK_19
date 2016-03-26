package org.usfirst.frc.team79.robot.commands.auton.commands;

import org.usfirst.frc.team79.robot.commands.CommandBase;

public class ResetGyro extends CommandBase {
	
	private boolean isFinished = false;

	public ResetGyro() {
		requires(gyro);
	}
	
	@Override
	protected void initialize() {
	
	}

	@Override
	protected void execute() {
		gyro.resetGyro();
		isFinished = true;
	}

	@Override
	protected boolean isFinished() {
		return isFinished;
	}

	@Override
	protected void end() {
		
	}

	@Override
	protected void interrupted() {

	}

}
