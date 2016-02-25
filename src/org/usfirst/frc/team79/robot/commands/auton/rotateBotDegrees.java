package org.usfirst.frc.team79.robot.commands.auton;

import org.usfirst.frc.team79.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class rotateBotDegrees extends CommandBase {
	
	double degrees;
	
	public rotateBotDegrees(double degrees) {
		
		requires(gyro);
		requires(driveTrain);
		
		this.degrees = degrees;
		
	}

	@Override
	protected void initialize() {
		
	}

	@SuppressWarnings("deprecation")
	@Override
	protected void execute() {
		
		double gyroReadout = gyro.getGyroAngle();
		
		SmartDashboard.putDouble("Gyro Value in Degrees", gyroReadout);
		
		if(degrees < gyroReadout) {
			driveTrain.moveTank(1.0, -1.0);
		} else if(degrees > gyroReadout) {
			driveTrain.moveTank(-1.0, 1.0);
		}
		
	}

	@Override
	protected boolean isFinished() {
		return (gyro.getGyroAngle() < degrees + 5 && gyro.getGyroAngle() > degrees - 5);
	}

	@Override
	protected void end() {
		driveTrain.moveTank(0, 0);
	}

	@Override
	protected void interrupted() {
		
	}

}
