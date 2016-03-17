package org.usfirst.frc.team79.robot.commands.auton.navipoints;

import org.usfirst.frc.team79.robot.commands.auton.DriveDistanceEncoder;
import org.usfirst.frc.team79.robot.commands.auton.ResetEncoders;
import org.usfirst.frc.team79.robot.commands.auton.SetPlow;
import org.usfirst.frc.team79.robot.commands.auton.SetWinch;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class Default extends CommandGroup {
	
	public Default(CommandGroup obstacle) {
		addSequential(new SetPlow(Value.kForward));
		addSequential(new SetWinch(Value.kReverse));
		addSequential(new WaitCommand(3.0));
		addSequential(new DriveDistanceEncoder(13, 0.5));
		addSequential(new SetPlow(Value.kReverse));
		addSequential(new SetWinch(Value.kForward));
		addSequential(new WaitCommand(2.0));
		addSequential(new ResetEncoders());
//		addSequential(new RotateToDegree(85));
//		addSequential(new WaitCommand(2.0));
//		addSequential(new ResetEncoders());
//		addSequential(new DriveDistanceEncoder(4, 0.5));
//		addSequential(new SetPlow(Value.kReverse));
//		addSequential(new WaitForTime(3.0));
//		addSequential(new FireBall());
	}

}
