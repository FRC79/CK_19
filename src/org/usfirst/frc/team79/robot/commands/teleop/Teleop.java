package org.usfirst.frc.team79.robot.commands.teleop;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Teleop extends CommandGroup {
	
	// all of the parallel commands that are run in teleop

	public Teleop() {
		addParallel(new Drive());
		addParallel(new Manipulate());
		addParallel(new ManipulateWinch());
	}
	
}
