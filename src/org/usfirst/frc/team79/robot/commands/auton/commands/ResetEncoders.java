package org.usfirst.frc.team79.robot.commands.auton.commands;

import org.usfirst.frc.team79.robot.commands.CommandBase;

public class ResetEncoders extends CommandBase {
	
	private boolean isFinished;
	
	public ResetEncoders() {
		requires(drivetrain);
	}

	@Override
	protected void initialize() {

	}

	@Override
	protected void execute() {
		drivetrain.resetEncoders();
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
