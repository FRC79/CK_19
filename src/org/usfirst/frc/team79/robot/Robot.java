package org.usfirst.frc.team79.robot;

import org.usfirst.frc.team79.robot.commands.CommandBase;
import org.usfirst.frc.team79.robot.commands.auton.Auton;
import org.usfirst.frc.team79.robot.commands.teleop.Teleop;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;

public class Robot extends IterativeRobot {

    public void robotInit() {
    	RobotMap.init();
    	CommandBase.init();
    	OI.init();
    	
    	CameraServer server;
    	server = CameraServer.getInstance();
    	server.setQuality(100);
    	server.startAutomaticCapture("cam0");
    }

    public void teleopInit() {
    	new Teleop().start();
    }

    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
    
    public void autonomousInit() {
    	new Auton().start();
    }

    public void autonomousPeriodic() {
    	Scheduler.getInstance().run();
    }
    
    public void disabledInit(){

    }
    
    public void testPeriodic() {
    	
    }
	
	public void disabledPeriodic() {
		
	}
	
}
