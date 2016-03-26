package org.usfirst.frc.team79.robot;

import org.usfirst.frc.team79.robot.commands.CommandBase;
import org.usfirst.frc.team79.robot.commands.GlobalAutonData;
import org.usfirst.frc.team79.robot.commands.auton.HighFast;
import org.usfirst.frc.team79.robot.commands.auton.LowSlow;
import org.usfirst.frc.team79.robot.commands.auton.NavigateChevalDeFris;
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

    	CommandBase.init();
    	OI.init();

    	server = CameraServer.getInstance();
    	server.setQuality(100);
    	server.startAutomaticCapture("cam0");
    	
    	autonSelector = new SendableChooser();
    	
    	autonSelector.addDefault("Default / PortCullis", new LowSlow());
    	autonSelector.addObject("High Wall / Rough Terrain / Moat", new HighFast());
    	autonSelector.addObject("Cheval de Fris", new NavigateChevalDeFris());
    	
    	SmartDashboard.putData("Autonamous mode Selection", autonSelector);
    	
		SmartDashboard.putNumber("kpChooser", GlobalAutonData.kd);
		SmartDashboard.putNumber("kiChooser", GlobalAutonData.ki);
		SmartDashboard.putNumber("kdChooser", GlobalAutonData.kd);
		
		SmartDashboard.putBoolean("UsePID", true);
		
    }

    public void teleopInit() {
    	Scheduler.getInstance().removeAll();
    	new Teleop().start();
    }
    
    public void teleopPeriodic() {
    	Scheduler.getInstance().run();
    }
    
    public void autonomousInit() {
    	
    	Scheduler.getInstance().removeAll();
    	
    	if(SmartDashboard.getBoolean("UsePID")) {
    		GlobalAutonData.kp = SmartDashboard.getNumber("kpChooser");
    		GlobalAutonData.ki = SmartDashboard.getNumber("kiChooser");
    		GlobalAutonData.kd = SmartDashboard.getNumber("kdChooser");
    	} else {
    		GlobalAutonData.kp = 0;
    		GlobalAutonData.ki = 0;
    		GlobalAutonData.kd = 0;
    	}
    	
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
