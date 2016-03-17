package org.usfirst.frc.team79.robot.commands.auton.obstacles;

import org.usfirst.frc.team79.robot.commands.auton.DriveDistanceEncoder;
import org.usfirst.frc.team79.robot.commands.auton.ResetEncoders;
import org.usfirst.frc.team79.robot.commands.auton.SetPlow;
import org.usfirst.frc.team79.robot.commands.auton.SetWinch;
import org.usfirst.frc.team79.robot.commands.auton.WaitForTime;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class NavigateChevalDeFris extends CommandGroup {
	
	public NavigateChevalDeFris() {
		addParallel(new SetPlow(Value.kReverse)); // move both up
		addSequential(new SetWinch(Value.kForward));
		addSequential(new WaitForTime(3.0));
		addSequential(new DriveDistanceEncoder(2, 0.5)); // distance of robot to ramp
		addSequential(new SetPlow(Value.kForward));
		addSequential(new WaitForTime(3.0));
		addSequential(new DriveDistanceEncoder(2, 0.5)); // not sure if I want to handle it that way, but drive through the obstacle
		addSequential(new ResetEncoders());
	}

}
