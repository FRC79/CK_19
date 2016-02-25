package org.usfirst.frc.team79.robot.commands.auton;

import org.usfirst.frc.team79.robot.commands.CommandBase;

public class DriveBot extends CommandBase {
	
	double speed;
	double left, right;
	double duration;
	
	public DriveBot(double timeOut) {
		requires(driveTrain);
		setTimeout(duration);
	}
	
	public DriveBot(double left, double right, double timeOut) {
		this(timeOut);
		this.left = left;
		this.right = right;
	}

	@Override
	protected void initialize() {
		
	}

	@Override
	protected void execute() {
		move(-left, -right);
	}
	
	protected void move(double left, double right) {
		driveTrain.moveTank(left, right);
	}

	@Override
	protected boolean isFinished() {
		return isTimedOut();
	}

	@Override
	protected void end() {
		driveTrain.moveTank(0, 0);
	}

	@Override
	protected void interrupted() {
	
	}

}
