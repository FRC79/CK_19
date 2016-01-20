package org.usfirst.frc.team79.robot.subsystems;

import org.usfirst.frc.team79.robot.RobotMap;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain extends Subsystem {
	
	RobotDrive drive;
	
	public DriveTrain() {
		drive = new RobotDrive(RobotMap.MOTORLEFT, RobotMap.MOTORRIGHT);
	}
	
	public void moveTank(double left, double right) {
		drive.tankDrive(left, right);
	}
	
	public void moveArcade(double moveValue, double rotateValue) {
		drive.arcadeDrive(moveValue, rotateValue);
	}

	@Override
	protected void initDefaultCommand() {
		
	}

}
