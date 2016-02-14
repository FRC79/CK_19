package org.usfirst.frc.team79.robot.subsystems;

import org.usfirst.frc.team79.robot.RobotMap;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain extends Subsystem {
	
	Victor frontLeft;
	Victor middleLeft;
	Victor backLeft;
	
	Victor frontRight;
	Victor middleRight;
	Victor backRight;
	
	public DriveTrain() {
		frontLeft = new Victor(RobotMap.MOTORFRONTLEFT);
		frontLeft.setInverted(true);
		middleLeft = new Victor(RobotMap.MOTORMIDDLELEFT);
		middleLeft.setInverted(true);
		backLeft = new Victor(RobotMap.MOTORBACKLEFT);
		backLeft.setInverted(true);
		
		frontRight = new Victor(RobotMap.MOTORFRONTRIGHT);
		middleRight = new Victor(RobotMap.MOTORMIDDLRIGHT);
		backRight = new Victor(RobotMap.MOTORBACKRIGHT);
	}
	
	public void moveTank(double left, double right) {
		frontLeft.set(left);
		middleLeft.set(right);
		backLeft.set(left);
		
		frontRight.set(right);
		middleRight.set(right);
		backRight.set(right);
	}
	
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

	@Override
	protected void initDefaultCommand() {
		
	}

}
