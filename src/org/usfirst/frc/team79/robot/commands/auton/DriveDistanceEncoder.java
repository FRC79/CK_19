package org.usfirst.frc.team79.robot.commands.auton;

import org.usfirst.frc.team79.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveDistanceEncoder extends CommandBase {
	
	double distance;
	boolean isFinished;
	double speed;
	
	public DriveDistanceEncoder(double distance, double speed) {
		requires(drivetrain);
		this.distance = distance;
		this.speed = speed;
	}

	@Override
	protected void initialize() {

	}

	@SuppressWarnings("deprecation")
	@Override
	protected void execute() {
		
		SmartDashboard.putDouble("Encoder distance", drivetrain.getRightEncoder());

		if(distance > 0) {
			if(drivetrain.getRightEncoder() < distance) {
				drivetrain.moveTank(speed, speed);
			} else {
				drivetrain.moveTank(0, 0);
				isFinished = true;
			}
		} else {
			if(drivetrain.getRightEncoder() > distance) {
				drivetrain.moveTank(-speed, -speed);
			} else {
				drivetrain.moveTank(0, 0);
				isFinished = true;
			}
		}
				
	}

	@Override
	protected boolean isFinished() {
		return isFinished;
	}

	@Override
	protected void end() {
		drivetrain.moveTank(0, 0);
	}

	@Override
	protected void interrupted() {
	
	}

}
