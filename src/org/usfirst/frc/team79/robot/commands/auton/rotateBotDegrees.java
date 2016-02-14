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
		if(degrees < 0.0 && Math.abs(gyro.getGyroAngle()) <= Math.abs(degrees)) {
			driveTrain.moveTank(1, -1);
		} else if(degrees > 0.0 && (gyro.getGyroAngle() <= degrees)) {
			driveTrain.moveTank(-1, 1);
		} else {
			end();
		}
	}
	
//	public void rotateDegrees(double degrees) {
//		if(degrees < 0.0) {
//			while(Math.abs(gyro.getGyroAngle()) <= Math.abs(degrees)) {
////				SmartDashboard.putDouble("GyroAngle", gyro.getGyroAngle());
//				driveTrain.moveTank(0.5, -0.5);
//			}
//		} else {
//			while(gyro.getGyroAngle() <= degrees) {
////				SmartDashboard.putDouble("GyroAngle", gyro.getGyroAngle());
//				driveTrain.moveTank(-0.5, 0.5);
//			}
//		}
//	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		driveTrain.moveTank(0, 0);
	}

	@Override
	protected void interrupted() {
		
	}

}
