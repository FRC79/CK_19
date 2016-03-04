package org.usfirst.frc.team79.robot.commands.auton;

import org.usfirst.frc.team79.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveDistance extends CommandBase {
	
	double distance;
	boolean isFinished;
	
	public DriveDistance(double distance) {
		requires(drivetrain);
		drivetrain.resetEncoders();
		this.distance = distance;
	}

	@Override
	protected void initialize() {

	}

	@SuppressWarnings("deprecation")
	@Override
	protected void execute() {
		
		SmartDashboard.putDouble("Encoder distance", getDistanceFeet());

		if(distance > 0) {
			if(getDistanceFeet() < distance) {
				drivetrain.moveTank(1.0, 1.0);
			} else {
				drivetrain.moveTank(0, 0);
				isFinished = true;
			}
		} else {
			if(getDistanceFeet() > distance) {
				drivetrain.moveTank(-1.0, -1.0);
			} else {
				drivetrain.moveTank(0, 0);
				isFinished = true;
			}
		}
		
	}
	
	public double getDistanceFeet() {
		return ((drivetrain.getLeftEncoder() * 25.13) / 254) / 12;
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
