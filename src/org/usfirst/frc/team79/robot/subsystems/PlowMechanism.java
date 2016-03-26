package org.usfirst.frc.team79.robot.subsystems;

import org.usfirst.frc.team79.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

public class PlowMechanism extends Subsystem {
	
	DoubleSolenoid armActuator;
	
	public PlowMechanism() {
		armActuator = new DoubleSolenoid(RobotMap.PLOW_SOLENOID_A, RobotMap.PLOW_SOLENOID_B);
	}
	
	public void set(Value value) {
		armActuator.set(value);
	}

	@Override
	protected void initDefaultCommand() {
		
	}
	
}
