package org.usfirst.frc.team79.robot.commands.auton;

import org.usfirst.frc.team79.robot.commands.CommandBase;

public class DriveBot extends CommandBase {
	
	double speed;
	double duration;
	
	public DriveBot(double speed, double duration) {
		requires(driveTrain);
		this.speed = speed;
		this.duration = duration;
	}

	@Override
	protected void initialize() {
		setTimeout(duration);
	}

	@Override
	protected void execute() {
		move(-speed);
	}
	
	protected void move(double speed) {
		driveTrain.moveTank(speed, speed);
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
