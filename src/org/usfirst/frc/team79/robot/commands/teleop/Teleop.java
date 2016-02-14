package org.usfirst.frc.team79.robot.commands.teleop;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Teleop extends CommandGroup {

	public Teleop() {
		addParallel(new Drive());
		addParallel(new Manipulate());
	}
	
}
