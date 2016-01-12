package org.usfirst.frc.team79.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Teleop extends CommandGroup {

	public Teleop() {
		addParallel(new TankDrive());
	}
	
}
