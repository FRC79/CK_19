package org.usfirst.frc.team79.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.command.Subsystem;

public class GyroSystem extends Subsystem {
	
	public AnalogGyro gyro;
	
	public GyroSystem() {
		gyro = new AnalogGyro(0);
	}
	
	public double getGyroAngle() {
		return gyro.getAngle();
	}

	public void resetGyro() {
		gyro.reset();
	}
	@Override
	protected void initDefaultCommand() {
		
	}

}
