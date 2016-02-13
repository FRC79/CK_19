package org.usfirst.frc.team79.robot;

import org.usfirst.frc.team79.robot.commands.CommandBase;
import org.usfirst.frc.team79.robot.commands.Teleop;
import org.usfirst.frc.team79.robot.commands.Winch;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;

public class Robot extends IterativeRobot {

    public void robotInit() {
    	RobotMap.init();
    	CommandBase.init();
    	OI.init();
    }

    public void teleopInit() {
    	new Teleop().start();
    }

    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        OI.WinchStart.whenPressed(new Winch());
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
