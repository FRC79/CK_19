package org.usfirst.frc.team79.robot.subsystems;

import org.usfirst.frc.team79.robot.RobotMap;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain extends Subsystem {
	
	RobotDrive drive;
	
	public DriveTrain() {
		drive = new RobotDrive(RobotMap.MOTORLEFT, RobotMap.MOTORRIGHT);
	}
	
	public void move(double left, double right) {
		drive.tankDrive(left, right);
	}

	@Override
	protected void initDefaultCommand() {
		
	}

}
