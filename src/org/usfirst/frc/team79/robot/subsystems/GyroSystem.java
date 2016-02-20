package org.usfirst.frc.team79.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.command.Subsystem;

public class GyroSystem extends Subsystem {
	
	// do we even have a gyro on the bot right now?
	
	public AnalogGyro gyro;
	
	public GyroSystem() {
		gyro = new AnalogGyro(0);
		resetGyro();
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