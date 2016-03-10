package org.usfirst.frc.team79.robot;

import org.usfirst.frc.team79.robot.commands.CommandBase;
import org.usfirst.frc.team79.robot.commands.auton.navipoints.Default;
import org.usfirst.frc.team79.robot.commands.auton.navipoints.NaviA;
import org.usfirst.frc.team79.robot.commands.auton.navipoints.NaviB;
import org.usfirst.frc.team79.robot.commands.auton.navipoints.NaviD;
import org.usfirst.frc.team79.robot.commands.auton.obstacles.NavigateChevalDeFris;
import org.usfirst.frc.team79.robot.commands.auton.obstacles.NavigateHighWall;
import org.usfirst.frc.team79.robot.commands.auton.obstacles.NavigateMoat;
import org.usfirst.frc.team79.robot.commands.auton.obstacles.NavigatePortcullis;
import org.usfirst.frc.team79.robot.commands.auton.obstacles.NavigateRoughTerrain;
import org.usfirst.frc.team79.robot.commands.teleop.Teleop;
import org.usfirst.frc.team79.robot.utilities.ObstacleReference;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {
	
	CameraServer server;
	SendableChooser naviPointSelector;
	SendableChooser obstacleSelector;
	
    public void robotInit() {
    	
    	RobotMap.init();
    	CommandBase.init();
    	OI.init();

    	server = CameraServer.getInstance();
    	server.setQuality(100);
    	server.startAutomaticCapture("cam0");
    	
    	naviPointSelector = new SendableChooser();
    	obstacleSelector = new SendableChooser();
    	
    	obstacleSelector.addDefault("Port Cullis", new NavigatePortcullis());
    	obstacleSelector.addObject("Shovel The Fries", new NavigateChevalDeFris());
    	obstacleSelector.addObject("Navigate High Wall", new NavigateHighWall());
    	obstacleSelector.addObject("Navigate Moat", new NavigateMoat());
    	obstacleSelector.addObject("Navigate Rough Terrain", new NavigateRoughTerrain());
    	
    	naviPointSelector.addDefault("default low bar", new ObstacleReference(1));
    	naviPointSelector.addObject("Navi point A", new ObstacleReference(2));
    	naviPointSelector.addObject("Navi point B", new ObstacleReference(3));
    	naviPointSelector.addObject("Navi pint D", new ObstacleReference(4));
    	
    	SmartDashboard.putData("Select an obstacle", obstacleSelector);
    	SmartDashboard.putData("Autonamout Navi", naviPointSelector);
    	
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
    	
    	CommandGroup autonCommand = new Default(null);
    	ObstacleReference obstacle = (ObstacleReference) naviPointSelector.getSelected();
    	
    	int identifier = obstacle.getIdentifier();
    	
    	if(identifier == 2) {
    		autonCommand = new NaviA((CommandGroup) obstacleSelector.getSelected());
    	} else if(identifier == 3) {
    		autonCommand = new NaviB((CommandGroup) obstacleSelector.getSelected());
    	} else if(identifier == 4) {
    		autonCommand = new NaviD((CommandGroup) obstacleSelector.getSelected());
    	} else {
    		autonCommand = new Default(null);
    	}

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
