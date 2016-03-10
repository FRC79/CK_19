package org.usfirst.frc.team79.robot.commands.auton.obstacles;

import org.usfirst.frc.team79.robot.commands.auton.DriveDistanceEncoder;
import org.usfirst.frc.team79.robot.commands.auton.SetPlow;
import org.usfirst.frc.team79.robot.commands.auton.SetWinch;
import org.usfirst.frc.team79.robot.commands.auton.WaitForTime;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class NavigatePortcullis extends CommandGroup {
	
	public NavigatePortcullis() {
		// set winch and plow down
		addSequential(new SetPlow(Value.kForward));
		addParallel(new SetWinch(Value.kReverse));
		addSequential(new WaitForTime(0.5));
		addSequential(new DriveDistanceEncoder(4)); // blow through both distances
	}

}
