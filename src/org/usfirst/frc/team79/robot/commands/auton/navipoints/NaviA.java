package org.usfirst.frc.team79.robot.commands.auton.navipoints;

import org.usfirst.frc.team79.robot.commands.auton.DriveDistanceEncoder;
import org.usfirst.frc.team79.robot.commands.auton.ResetEncoders;
import org.usfirst.frc.team79.robot.commands.auton.RotateToDegree;
import org.usfirst.frc.team79.robot.commands.auton.SetPlow;
import org.usfirst.frc.team79.robot.commands.auton.SetWinch;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class NaviA extends CommandGroup {
	
	public NaviA(CommandGroup obstacle) {
		addSequential(obstacle);
		addSequential(new RotateToDegree(0));
		addSequential(new DriveDistanceEncoder(10, 0.75));
		addSequential(new SetPlow(Value.kReverse));
		addSequential(new SetWinch(Value.kForward));
		addSequential(new WaitCommand(2.0));
		addSequential(new ResetEncoders());
//		addSequential(new DriveDistanceEncoder(6));
//		addSequential(new RotateToDegree(90));
//		addSequential(new DriveDistanceEncoder(4.5));
//		addSequential(new RotateToDegree(60));
//		addSequential(new DriveDistanceEncoder(2));
//		addSequential(new SetPlow(Value.kReverse));
//		addSequential(new WaitForTime(3.0));
//		addSequential(new FireBall());
		
	}

}
