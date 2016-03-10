package org.usfirst.frc.team79.robot.commands.auton;

import org.usfirst.frc.team79.robot.commands.CommandBase;

public class WaitForTime extends CommandBase {

	
	public WaitForTime(double timeOut) {
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
