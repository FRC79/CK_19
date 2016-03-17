package org.usfirst.frc.team79.robot.commands.auton.obstacles;

import org.usfirst.frc.team79.robot.commands.auton.DriveDistanceEncoder;
import org.usfirst.frc.team79.robot.commands.auton.ResetEncoders;
import org.usfirst.frc.team79.robot.commands.auton.SetPlow;
import org.usfirst.frc.team79.robot.commands.auton.SetWinch;
import org.usfirst.frc.team79.robot.commands.auton.WaitForTime;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class NavigateMoat extends CommandGroup {
	
	public NavigateMoat() {
		addParallel(new SetPlow(Value.kReverse));
		addSequential(new SetWinch(Value.kForward));
		addSequential(new WaitForTime(3.0));
		// cover the distance from start to ramp 
		addSequential(new DriveDistanceEncoder(4, 0.5)); // bust over that moat at full speed
		addSequential(new ResetEncoders());
	}

}
