package org.usfirst.frc.team79.robot.commands.auton.obstacles;

import org.usfirst.frc.team79.robot.commands.auton.DriveDistanceEncoder;
import org.usfirst.frc.team79.robot.commands.auton.ResetEncoders;
import org.usfirst.frc.team79.robot.commands.auton.SetPlow;
import org.usfirst.frc.team79.robot.commands.auton.SetWinch;
import org.usfirst.frc.team79.robot.commands.auton.WaitForTime;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class NavigateHighWall extends CommandGroup {
	
	public NavigateHighWall() {
		addParallel(new SetPlow(Value.kReverse));
		addSequential(new SetWinch(Value.kForward));
		addSequential(new WaitForTime(3.0));
		addSequential(new DriveDistanceEncoder(4, 1.0)); // bust through the wall at full speed !
		addSequential(new ResetEncoders());
	}

}