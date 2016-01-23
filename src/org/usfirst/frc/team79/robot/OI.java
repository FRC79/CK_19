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
	public static JoystickButton toggle, rotateArm, fire;
	
	public static void init() {
		left = new Joystick(RobotMap.LEFTCONTROLLER);
		right = new Joystick(RobotMap.RIGHTCONTROLLER);
		toggle = new JoystickButton(left, 1);
		rotateArm = new JoystickButton(left, 2);
		fire = new JoystickButton(left, 3);
	}
	
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

