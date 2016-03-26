package org.usfirst.frc.team79.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.command.Subsystem;

public class GyroSystem extends Subsystem {
	
	double setAngle;
	
	public AnalogGyro gyro;
	
	public GyroSystem() {
		gyro = new AnalogGyro(0);
		resetGyro();
	}
	
	/*
	 * scales the gyro output to a value between -1.0 and 1.0
	 * and shunts values that rollover from either > 180 or < -180
	 * to their equivolent value closest to zero
	 */
	public double pidValue() {
		
		double gyroRead = getGyroAngle() % 360;
		double returnValue;
		
		if(gyroRead < -180D) {
			returnValue = 360D + gyroRead;
		} else if(gyroRead > 180D) {
			returnValue = -360D + gyroRead;
		} else {
			returnValue = gyroRead;
		}
		
		return returnValue / 180;
		
	}
	
	public double getGyroAngle() {
		return -(gyro.getAngle());
	}

	public void resetGyro() {
		gyro.reset();
	}
		
	@Override
	protected void initDefaultCommand() {
		
	}
	
}
