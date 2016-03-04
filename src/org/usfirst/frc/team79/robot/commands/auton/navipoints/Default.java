package org.usfirst.frc.team79.robot.commands.auton.navipoints;

import org.usfirst.frc.team79.robot.commands.auton.DriveDistance;
import org.usfirst.frc.team79.robot.commands.auton.RotateToDegree;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class Default extends CommandGroup {
	
	public Default(Command command) {
		addSequential(new DriveDistance(26));
		addSequential(new RotateToDegree(90));
		addSequential(new DriveDistance(13.5));
		addSequential(new RotateToDegree(60));
		addSequential(new DriveDistance(2));
		// fire
		addSequential(new DriveDistance(-10));
	}

}
