
package org.usfirst.frc.team79.robot.commands.auton;

import org.usfirst.frc.team79.robot.commands.auton.commands.DriveDistance;
import org.usfirst.frc.team79.robot.commands.auton.commands.ResetEncoders;
import org.usfirst.frc.team79.robot.commands.auton.commands.ResetGyro;
import org.usfirst.frc.team79.robot.commands.auton.commands.SetPlow;
import org.usfirst.frc.team79.robot.commands.auton.commands.SetWinch;
import org.usfirst.frc.team79.robot.commands.auton.commands.Wait;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class HighFast extends CommandGroup {
	
	public HighFast() {
		addSequential(new ResetGyro());
		addSequential(new SetPlow(Value.kReverse));
		addSequential(new SetWinch(Value.kForward));
		addSequential(new Wait(3.0));
		addSequential(new ResetEncoders());
		addSequential(new DriveDistance(1.0, 13)); // TODO : Find PID Tuning values
	}

}
