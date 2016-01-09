package org.usfirst.frc.team79.robot;


import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;

public class Robot extends SampleRobot {
	
    RobotDrive myRobot;  
    Joystick leftStick;  
    Joystick rightStick; 
    
    public Robot() {
    	
        myRobot = new RobotDrive(0, 1);
        leftStick = new Joystick(0);
        rightStick = new Joystick(1);
        
    }

    public void operatorControl() {
    	
        myRobot.setSafetyEnabled(true);
        
        while (isOperatorControl() && isEnabled()) {
        	myRobot.tankDrive(leftStick, rightStick);
            Timer.delay(0.005);		
        }
    }

}
