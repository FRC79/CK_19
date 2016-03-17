package org.usfirst.frc.team79.robot.commands.auton.navipoints;

import org.usfirst.frc.team79.robot.commands.auton.DriveDistanceEncoder;
import org.usfirst.frc.team79.robot.commands.auton.ResetEncoders;
import org.usfirst.frc.team79.robot.commands.auton.RotateToDegree;
import org.usfirst.frc.team79.robot.commands.auton.SetPlow;
import org.usfirst.frc.team79.robot.commands.auton.SetWinch;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class NaviD extends CommandGroup {
	
	public NaviD(CommandGroup obstacle) {
		addSequential(obstacle);
		addSequential(new RotateToDegree(0)); 
		addSequential(new DriveDistanceEncoder(10, 0.75));
		addSequential(new SetPlow(Value.kReverse));
		addSequential(new SetWinch(Value.kForward));
		addSequential(new WaitCommand(2.0));
		addSequential(new ResetEncoders());
//		addSequential(new DriveDistanceEncoder(3));
//		addSequential(new RotateToDegree(-30));
//		addSequential(new DriveDistanceEncoder(6.5));
//		addSequential(new FireBall());
	}

}
