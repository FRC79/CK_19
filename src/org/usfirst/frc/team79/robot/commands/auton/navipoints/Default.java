package org.usfirst.frc.team79.robot.commands.auton.navipoints;

import org.usfirst.frc.team79.robot.commands.auton.DriveDistanceEncoder;
import org.usfirst.frc.team79.robot.commands.auton.FireBall;
import org.usfirst.frc.team79.robot.commands.auton.RotateToDegree;
import org.usfirst.frc.team79.robot.commands.auton.SetPlow;
import org.usfirst.frc.team79.robot.commands.auton.SetWinch;
import org.usfirst.frc.team79.robot.commands.auton.WaitForTime;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class Default extends CommandGroup {
	
	public Default(Command command) {
		addParallel(new SetPlow(Value.kForward));
		addSequential(new SetWinch(Value.kReverse));
		addSequential(new DriveDistanceEncoder(26));
		addSequential(new RotateToDegree(90));
//		addSequential(new DriveUntilDistanceSonar(0.5));
		addSequential(new DriveDistanceEncoder(13.5));
		addSequential(new RotateToDegree(60));
		addSequential(new DriveDistanceEncoder(2));
		addSequential(new SetPlow(Value.kReverse));
		addSequential(new WaitForTime(0.5));
		addSequential(new FireBall());
		addSequential(new DriveDistanceEncoder(-5));
	}

}
