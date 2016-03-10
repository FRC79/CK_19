package org.usfirst.frc.team79.robot.commands.auton.navipoints;

import org.usfirst.frc.team79.robot.commands.auton.DriveDistanceEncoder;
import org.usfirst.frc.team79.robot.commands.auton.FireBall;
import org.usfirst.frc.team79.robot.commands.auton.RotateToDegree;
import org.usfirst.frc.team79.robot.commands.auton.SetPlow;
import org.usfirst.frc.team79.robot.commands.auton.WaitForTime;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class NaviA extends CommandGroup {
	
	public NaviA(CommandGroup obstacle) {
		addSequential(obstacle); // navigate that obstacle
		addSequential(new RotateToDegree(0)); // realign the bot
//		addSequential(new DriveUntilDistanceSonar(0.5));
		addSequential(new DriveDistanceEncoder(22));
		addSequential(new RotateToDegree(90));
		addSequential(new DriveDistanceEncoder(7.5));
		addSequential(new RotateToDegree(60));
		addSequential(new DriveDistanceEncoder(2));
		addSequential(new SetPlow(Value.kReverse));
		addSequential(new WaitForTime(0.5));
		addSequential(new FireBall());
		addSequential(new DriveDistanceEncoder(-5));
		
	}

}
