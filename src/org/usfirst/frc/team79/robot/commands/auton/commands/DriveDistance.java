package org.usfirst.frc.team79.robot.commands.auton.commands;

import org.usfirst.frc.team79.robot.commands.CommandBase;
import org.usfirst.frc.team79.robot.commands.GlobalAutonData;
import org.usfirst.frc.team79.robot.utilities.PIDController;

public class DriveDistance extends CommandBase {
	
	PIDController gyroController;
	double speedVector;
	double distance;
	
	/*
	 * @param speedVector the speed that we would like to traverse in the Y direction
	 */
	public DriveDistance(double speedVector, double distance) {
		requires(drivetrain);
		requires(gyro);
		gyroController = new PIDController(0, GlobalAutonData.kp, GlobalAutonData.ki, GlobalAutonData.kd);
		this.speedVector = speedVector;
		this.distance = distance;
	}
	
	public DriveDistance(double speedVector, double distance, double kp, double ki, double kd) {
		this(speedVector, distance);
		gyroController.SetTunings(kp, ki, kd);
	}
 
	@Override
	protected void initialize() {
	
	}

	@Override
	protected void execute() {
		gyroController.SetTunings(GlobalAutonData.kp, GlobalAutonData.ki, GlobalAutonData.kd);
		drivetrain.moveArcade(-speedVector, gyroController.calculateOutput(gyro.pidValue()));
	}

	@Override
	protected boolean isFinished() {
		return (drivetrain.getRightEncoder() >= distance);
	}

	@Override
	protected void end() {
		drivetrain.moveTank(0, 0);
	}

	@Override
	protected void interrupted() {

	}

}
