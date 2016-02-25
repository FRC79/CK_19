package org.usfirst.frc.team79.robot;

import org.usfirst.frc.team79.robot.commands.CommandBase;
import org.usfirst.frc.team79.robot.commands.auton.AutonA;
import org.usfirst.frc.team79.robot.commands.auton.AutonB;
import org.usfirst.frc.team79.robot.commands.auton.AutonTest;
import org.usfirst.frc.team79.robot.commands.teleop.Teleop;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {

	CameraServer server;
	SendableChooser autonSelector;
	
    public void robotInit() {
    	
    	RobotMap.init();
    	CommandBase.init();
    	OI.init();
    	
    	server = CameraServer.getInstance();
    	server.setQuality(100);
    	server.startAutomaticCapture("cam0");
    	
    	autonSelector = new SendableChooser();
    	
    	autonSelector.addObject("Navi point A", new AutonA());
    	autonSelector.addObject("Navi point B", new AutonB());
    	autonSelector.addDefault("Navi Test Command", new AutonTest());
    	
    	SmartDashboard.putData("Autonamout Navi", autonSelector);
    	
    }

    public void teleopInit() {
    	new Teleop().start();
    }

    public void teleopPeriodic() {
    	Scheduler.getInstance().run();
    }
    
    public void autonomousInit() {
    	Command autonCommand = (Command) autonSelector.getSelected();
    	autonCommand.start();
    }

    public void autonomousPeriodic() {
    	Scheduler.getInstance().run();
    }
    
    public void disabledInit(){
    	Scheduler.getInstance().removeAll();
    }
    
    public void testPeriodic() {
    	
    }
	
	public void disabledPeriodic() {
		
	}
	
}
