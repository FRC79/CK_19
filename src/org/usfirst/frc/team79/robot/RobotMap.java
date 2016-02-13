package org.usfirst.frc.team79.robot;

public class RobotMap {

	// Controllers for Joysticks
	
	public static int LEFTCONTROLLER = 0;
	public static int RIGHTCONTROLLER = 1;
	
	
		//	......(\_/)
		//	......( '_')
		//	..../""""""""""""\======â–‘ â–’â–“â–“â–ˆD
		//	/"""""""""""""""""""""""\
		//	\@_@_@_@_@_/ \_@_@_@_@_@/
	
	//da motors
	public static int MOTORFRONTLEFT = 0;
	public static int MOTORMIDDLELEFT = 1;
	public static int MOTORBACKLEFT = 2;
	public static int MOTORFRONTRIGHT = 3;
	public static int MOTORMIDDLRIGHT = 4;
	public static int MOTORBACKRIGHT = 5;
	
	//da winch
	public static int WINCHLEFT = 6;
	public static int WINCHRIGHT = 7;
	public static int WINCHACTUATION =8;
	
	//da winch encoders
	
	public static int WINCHENCODERA = 10;
	public static int WINCHENCODERB = 11;
	
	// da arm encodees
	public static int ARMENCODERA = 12;
	public static int ARMENCODERB = 13;

	//da plow encoders
	
	public static int INTAKEENCODERA = 8;
	public static int INTAKEENCODERB = 9;
	//da intake motors
	
	public static int INTAKEROLLER = 8;
	public static int INTAKEFIRINGMOTOR = 9;
	
	//da banners sensors
	
	public static int BANNERFRONT = 4;
	public static int BANNERBACK = 5;
	
	public static void init() {
		
	}
	
}
