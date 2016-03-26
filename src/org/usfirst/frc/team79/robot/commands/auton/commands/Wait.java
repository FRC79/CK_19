package org.usfirst.frc.team79.robot.commands.auton.commands;

import org.usfirst.frc.team79.robot.commands.CommandBase;

public class Wait extends CommandBase {

	
	public Wait(double timeOut) {
		setTimeout(timeOut);
	}
	
	@Override
	protected void initialize() {

	}

	@Override
	protected void execute() {
		
	}

	@Override
	protected boolean isFinished() {
		return isTimedOut();
	}

	@Override
	protected void end() {
		
	}

	@Override
	protected void interrupted() {
		
	}

}
