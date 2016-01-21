package org.usfirst.frc.team79.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	public static Joystick left;
	public static Joystick right;
	public static JoystickButton arcButton;
	
	public static void init() {
		
		left = new Joystick(RobotMap.DRIVESTICKLEFT);
		right = new Joystick(RobotMap.DRIVESTICKRIGHT);
		arcButton = new JoystickButton(left, RobotMap.ARCBUTTON);
	}
}
	
	public static double getX() {
		return left.getX();
	}
	
	public static double getY() {
		return left.getX();
	}

}

