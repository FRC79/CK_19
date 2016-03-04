package org.usfirst.frc.team79.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */

public class OI {
	
	public static boolean controllerToggle;
	
	public static Joystick left, right;
	public static Joystick gamePad;
	public static JoystickButton rotateArm, firing, intaking, plowDown, plowUp, calibrate, winchArmToggle, loggingToggle;
//	public static final JoystickButton[] TOGGLE_STATE = new JoystickButton[4];
	
	public static void init() {
		
		left = new Joystick(RobotMap.LEFTCONTROLLER);
		right = new Joystick(RobotMap.RIGHTCONTROLLER);
		gamePad = new Joystick(1);
		rotateArm = new JoystickButton(left, 2);
		
		firing = new JoystickButton(gamePad, 3);
		intaking = new JoystickButton(gamePad, 1);
		plowDown = new JoystickButton(gamePad, 2);
		plowUp = new JoystickButton(gamePad, 4);
		
		calibrate = new JoystickButton(gamePad, 5);
		
		winchArmToggle = new JoystickButton(gamePad, 7);
		
		loggingToggle = new JoystickButton(left, 1);
		
	}
	
	public static boolean getDPadLeft() {
		return(gamePad.getRawAxis(5) < -0.5);
	}
	
	public static boolean getDPadRight() {
		return(gamePad.getRawAxis(5) > 0.5); 
	}
	
//	public static boolean getDPadUp() {
//		return(gamePad.getRawAxis(6) < -0.5);
//	}
//	
//	public static boolean getDPadDown() {
//		return(gamePad.getRawAxis(6) > 0.5);
//	}
	
	public static double getLeft() {
		return left.getY();
	}
	
	public static double getRight() {
		return right.getY();
	}
	
	public static double getX() {
		return left.getX();
	}
	
	public static double getY() {
		return left.getY();
	}

}

