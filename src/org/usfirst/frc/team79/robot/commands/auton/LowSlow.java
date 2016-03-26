package org.usfirst.frc.team79.robot.commands.auton;

import org.usfirst.frc.team79.robot.commands.auton.commands.DriveDistance;
import org.usfirst.frc.team79.robot.commands.auton.commands.ResetEncoders;
import org.usfirst.frc.team79.robot.commands.auton.commands.ResetGyro;
import org.usfirst.frc.team79.robot.commands.auton.commands.SetPlow;
import org.usfirst.frc.team79.robot.commands.auton.commands.SetWinch;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class LowSlow extends CommandGroup {
	
	public LowSlow() {	
		addSequential(new ResetGyro());
		addSequential(new SetPlow(Value.kForward));
		addSequential(new SetWinch(Value.kReverse));
		addSequential(new WaitCommand(3.0));
		addSequential(new ResetEncoders());
		addSequential(new DriveDistance(0.5, 13));  // TODO : Find PID tunings
		addSequential(new SetPlow(Value.kReverse));
		addSequential(new SetWinch(Value.kForward));
	}

}
