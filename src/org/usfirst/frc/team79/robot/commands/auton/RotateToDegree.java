package org.usfirst.frc.team79.robot.commands.auton;

import org.usfirst.frc.team79.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class RotateToDegree extends CommandBase {
	
	double degrees;
	
	public RotateToDegree(double degrees) {
		
		requires(gyro);
		requires(drivetrain);	
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
			if(gyroReadout < degrees - 10) {
				drivetrain.moveTank(-0.6, 0.6);
			} else {
				drivetrain.moveTank(-1.0, 1.0);
			}
		} else if(degrees > gyroReadout) {
			if(gyroReadout > degrees + 10) {
				drivetrain.moveTank(0.6, -0.6);
			} else {
				drivetrain.moveTank(1.0, -1.0);
			}
		}
		
	}

	@Override
	protected boolean isFinished() {
		return (gyro.getGyroAngle() < degrees + 5 && gyro.getGyroAngle() > degrees - 5);
	}

	@Override
	protected void end() {
		drivetrain.moveTank(0, 0);
		drivetrain.resetEncoders();
	}

	@Override
	protected void interrupted() {
		
	}

}
