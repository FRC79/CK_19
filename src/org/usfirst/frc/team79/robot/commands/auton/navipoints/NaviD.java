package org.usfirst.frc.team79.robot.commands.auton.navipoints;

import org.usfirst.frc.team79.robot.commands.auton.DriveDistanceEncoder;
import org.usfirst.frc.team79.robot.commands.auton.FireBall;
import org.usfirst.frc.team79.robot.commands.auton.RotateToDegree;
import org.usfirst.frc.team79.robot.commands.auton.SetPlow;
import org.usfirst.frc.team79.robot.commands.auton.WaitForTime;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class NaviD extends CommandGroup {
	
	public NaviD(CommandGroup obstacle) {
		addSequential(obstacle);
		addSequential(new RotateToDegree(0)); // realign the bot
//		addSequential(new DriveUntilDistanceSonar(0.5));
		addSequential(new DriveDistanceEncoder(16));
		addSequential(new RotateToDegree(-30));
		addSequential(new DriveDistanceEncoder(9.5));
		addSequential(new SetPlow(Value.kReverse));
		addSequential(new WaitForTime(0.5));
		addSequential(new FireBall());
		addSequential(new DriveDistanceEncoder(-5));
	}

}
