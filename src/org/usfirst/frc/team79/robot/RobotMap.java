package org.usfirst.frc.team79.robot;

public class RobotMap {

	// Controllers for Joysticks
	
	public static int LEFTCONTROLLER = 0;
	public static int RIGHTCONTROLLER = 1;
	
	
	//	......(\_/)
	//	......( '_')
	//	..../""""""""""""\======░ ▒▓▓█D
	//	/"""""""""""""""""""""""\
	//	\@_@_@_@_@_/ \_@_@_@_@_@/
	
	public static int MOTORFRONTLEFT = 0;
	public static int MOTORMIDDLELEFT = 1;
	public static int MOTORBACKLEFT = 2;
	
	public static int MOTORFRONTRIGHT = 3;
	public static int MOTORMIDDLRIGHT = 4;
	public static int MOTORBACKRIGHT = 5;
	
	// winch elevation motors
	
	public static int WINCH_EXTEND = 6;
	public static int WINCH_EXTEND_OPPOSITE = 7;
	
	// Solenoids
	
	public static int PLOW_SOLENOID_A = 4;
	public static int PLOW_SOLENOID_B = 5;
	
	public static int WINCH_SOLENOID_A = 6;
	public static int WINCH_SOLENOID_B = 7;
	
	// Encoders 
	
	// move back for comp bot
	
	public static int LEFT_WHEEL_ENCODER_A = 3;
	public static int LEFT_WHEEL_ENCODER_B = 2;
	
	public static int RIGHT_WHEEL_ENCODER_A = 0;
	public static int RIGHT_WHEEL_ENCODER_B = 1;

	public static int WINCH_ELEVATION_ENCODER_A = 9;
	public static int WINCH_ELEVATION_ENCODER_B = 8;
	
	// Banner Sensors
	
	public static int BANNERFRONT = 4;
	public static int BANNERBACK = 5;
	
	// Shooter Mechanism motors

	public static int FIRINGMOTOR = 9;
	
	// Potentiometers
	
	public static int WINCH_ELEVATION_POTENTIOMETER = 1;
	
	// Limits
	
	public static int LIMIT_BOTTOM_ELEVATOR = 8;
	
	// Servos
	
	public static int STOP_SERVO = 12;
	
	// Sonar
	
	public static int PING_CHANNEL = 23;
	public static int ECHO_CHANNEL = 24;
	
	public static void init() {
		
	}
	
}
