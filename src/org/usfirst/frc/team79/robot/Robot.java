package org.usfirst.frc.team79.robot;

import org.usfirst.frc.team79.robot.commands.CommandBase;
import org.usfirst.frc.team79.robot.commands.Teleop;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;

public class Robot extends IterativeRobot {

    public void robotInit() {
    	OI.init();
    	CommandBase.init();
    }

    public void teleopInit() {
    	new Teleop().start();
    }

    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
    
    public void autonomousInit() {
    	
    }

    public void autonomousPeriodic() {
    	
    }
    
    public void disabledInit(){

    }
    
    public void testPeriodic() {
    	
    }
	
	public void disabledPeriodic() {
		
	}
	
}
