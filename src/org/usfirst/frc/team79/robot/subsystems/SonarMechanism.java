package org.usfirst.frc.team79.robot.subsystems;

import org.usfirst.frc.team79.robot.RobotMap;

import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Subsystem;

public class SonarMechanism extends Subsystem {
	
	Ultrasonic rangeFinder;
	
	public SonarMechanism() {
		rangeFinder = new Ultrasonic(RobotMap.PING_CHANNEL , RobotMap.ECHO_CHANNEL);
	}
	
	public double getDistanceInches() {
		return rangeFinder.getRangeInches();
	}
	
	public double getDistanceFeet() {
		return (rangeFinder.getRangeInches() / 12);
	}
 
	@Override
	protected void initDefaultCommand() {

	}

}
