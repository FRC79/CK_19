package org.usfirst.frc.team79.robot.subsystems;

import org.usfirst.frc.team79.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;

// the subsystem that controlls the wheels on the ground

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain extends Subsystem {
	
	private Victor frontLeft;
	private Victor middleLeft;
	private Victor backLeft;
	
	private Victor frontRight;
	private Victor middleRight;
	private Victor backRight;
	
	Encoder leftWheelEncoder;
	Encoder rightWheelEncoder;
	
	// mapping out all of the control motors for the train
	public DriveTrain() {
		
		// need to invert the left side
		frontLeft = new Victor(RobotMap.MOTORFRONTLEFT);
		frontLeft.setInverted(true);
		middleLeft = new Victor(RobotMap.MOTORMIDDLELEFT);
		middleLeft.setInverted(true);
		backLeft = new Victor(RobotMap.MOTORBACKLEFT);
		backLeft.setInverted(true);
		
		// the right's good though
		frontRight = new Victor(RobotMap.MOTORFRONTRIGHT);
		middleRight = new Victor(RobotMap.MOTORMIDDLRIGHT);
		backRight = new Victor(RobotMap.MOTORBACKRIGHT);
		
		leftWheelEncoder = new Encoder(RobotMap.LEFT_WHEEL_ENCODER_A, RobotMap.LEFT_WHEEL_ENCODER_B);
		rightWheelEncoder = new Encoder(RobotMap.RIGHT_WHEEL_ENCODER_A, RobotMap.RIGHT_WHEEL_ENCODER_B);
		
	}
	
	public double getLeftSet() {
		return backLeft.get();
	}
	
	public double getRightSet() {
		return backRight.get();
	}
	
	// pretty self explanatory
	// moves one half of the drivetrain one value
	// and the other half the other
	// 
	// NOTE
	// joystick inputs on the y axis down as positive, up as negative
	// so we invert all of the input set calls
	// logitech Y ?
	public void moveTank(double left, double right) {
		frontLeft.set(-left);
		middleLeft.set(-left);
		backLeft.set(-left);
		
		frontRight.set(-right);
		middleRight.set(-right);
		backRight.set(-right);
	}
	
	// custom rolled arcade code written by tooling through the native arcade drive class
	public void moveArcade(double moveValue, double rotateValue) {
		
		if(moveValue > 0) {
			
			if(rotateValue > 0) {

				// when move is 1, and rotate is zero, left goes backward
				// when move is 0, and rotate is one, left goes backwards
				frontLeft.set(moveValue - rotateValue);
				middleLeft.set(moveValue - rotateValue);
				backLeft.set(moveValue - rotateValue);
				
				// when move is one, and rotate is zero, right goes forward
				// when move is zero, and rotate is one, right goes backwards
				frontRight.set(Math.max(moveValue, rotateValue));
				middleRight.set(Math.max(moveValue, rotateValue));
				backRight.set(Math.max(moveValue, rotateValue));
				
			} else {

				// when move is 1, and rotate is zero, left goes backward
				// when move is 0, and rotate is one, left goes forward
				frontLeft.set(Math.max(moveValue, -rotateValue));
				middleLeft.set(Math.max(moveValue, -rotateValue));
				backLeft.set(Math.max(moveValue, - rotateValue));
				
				// when move is one, and rotate is zero, right goes forward
				// when move is one, and rotate is zero, right goes forward
				frontRight.set(moveValue + rotateValue);
				middleRight.set(moveValue + rotateValue);
				backRight.set(moveValue + rotateValue);
				
			}
			
		} else {
			
			if(rotateValue > 0 ) {
				
				// move = 0, rotate = 1, left goes backwards
				// move = -1, rotate = 0, left goes forward
				frontLeft.set(-Math.max(-moveValue, rotateValue));
				middleLeft.set(-Math.max(-moveValue, rotateValue));
				backLeft.set(-Math.max(-moveValue, rotateValue));
				
				// move = 0, rotate = 1, right goes backwards
				// move = -1, rotate = 0, right goes backwards
				frontRight.set(moveValue + rotateValue);
				middleRight.set(moveValue + rotateValue);
				backRight.set(moveValue + rotateValue);
				
			} else {
				
				// move = 0, rotate = -1, left goes forward
				// move = -1, rotate = 0, left goes forward
				frontLeft.set(moveValue - rotateValue);
				middleLeft.set(moveValue - rotateValue);
				backLeft.set(moveValue - rotateValue);
				
				// move = 0, rotate = -1, right goes forward
				// move = -1, rotate = 0, right goes backwards  
				frontRight.set(-Math.max(-moveValue, -rotateValue));
				middleRight.set(-Math.max(-moveValue, -rotateValue));
				backRight.set(-Math.max(-moveValue, -rotateValue));
				
			}
			
		}
		
	}
	
	public double getLeftEncoder() {
//		return leftWheelEncoder.getDistance();
		return ((leftWheelEncoder.getDistance() * 25.13) / 254) / 12;
	}
	
	public double getRightEncoder() {
//		return rightWheelEncoder.getDistance();
		return ((rightWheelEncoder.getDistance() * 25.13) / 254) / 12;
	}
	
	public void resetEncoders() {
		leftWheelEncoder.reset();
		rightWheelEncoder.reset();
	}
	
	@Override
	protected void initDefaultCommand() {
		
	}

}
