package org.usfirst.frc.team79.robot.commands.auton;

import org.usfirst.frc.team79.robot.commands.CommandBase;

public class rotateBotDegrees extends CommandBase {
	
	double degrees;
	
	public rotateBotDegrees(double degrees) {
		requires(gyro);
		requires(driveTrain);
		gyro.resetGyro();
		this.degrees = degrees;
	}

	@Override
	protected void initialize() {

	}

	@Override
	protected void execute() {
		rotateDegrees(degrees);
	}
	
	public void rotateDegrees(double degrees) {
		
		if(degrees < gyro.getGyroAngle()) {
			driveTrain.moveTank(1, -1);
		} else if(degrees > gyro.getGyroAngle()) {
			driveTrain.moveTank(-1, 1);
		} 
		
		if(degrees > gyro.getGyroAngle() - 5 && degrees < gyro.getGyroAngle() + 5) {
			driveTrain.moveTank(0, 0);
		}
		
	}

	@Override
	protected boolean isFinished() {
		return (degrees > gyro.getGyroAngle() - 5 && degrees < gyro.getGyroAngle() + 5);
	}

	@Override
	protected void end() {
		driveTrain.moveTank(0, 0);
	}

	@Override
	protected void interrupted() {
		
	}

}
