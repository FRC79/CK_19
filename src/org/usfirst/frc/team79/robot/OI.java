package org.usfirst.frc.team79.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */

public class OI {
	
	public static boolean controllerToggle;
	
	//  left top, 5, left bottom 7
	// rightntop, 6, right bottom 8
	
	public static Joystick left, right;
	public static Joystick gamePad;
	
	public static JoystickButton 
		 firing, intaking,
		 overrideBothUp, overrideBothDown,
		 servoStopToggle, 
		 loggingToggle,
		 manualPlowUp, manualPlowDown, manualArmUp, manualArmDown,
		 elevateUp, elevateDown;
	
	public static void init() {
		
		left = new Joystick(RobotMap.LEFTCONTROLLER);
		right = new Joystick(RobotMap.RIGHTCONTROLLER);
		
		gamePad = new Joystick(1);
		
		firing = new JoystickButton(gamePad, 3);
		intaking = new JoystickButton(gamePad, 1);
		
		overrideBothUp = new JoystickButton(gamePad, 4);
		overrideBothDown = new JoystickButton(gamePad, 2);
		
		servoStopToggle = new JoystickButton(left, 3);
		
		loggingToggle = new JoystickButton(left, 1);
		
		manualArmUp = new JoystickButton(gamePad, 5);
		manualArmDown = new JoystickButton(gamePad, 7);
		
		manualPlowUp = new JoystickButton(gamePad, 6);
		manualPlowDown = new JoystickButton(gamePad, 8);
		
		elevateUp = new JoystickButton(gamePad, 10);
		elevateDown = new JoystickButton(gamePad, 9);
		
		
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
	
	public static double getZ() {
		return left.getZ();
	}
	
	public static double getY() {
		return left.getY();
	}

}

