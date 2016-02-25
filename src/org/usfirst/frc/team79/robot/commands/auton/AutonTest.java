package org.usfirst.frc.team79.robot.commands.auton;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonTest extends CommandGroup {

	public AutonTest() {
		addSequential(new DriveBot(0.5, 0.5, 0.25));
		addSequential(new DriveBot(-0.5, -0.5, 0.25));
		addSequential(new DriveBot(0.5, 0.5, 0.25));
		addSequential(new DriveBot(-0.5, -0.5, 0.25));
		addSequential(new DriveBot(0.5, 0.5, 0.25));
		addSequential(new DriveBot(-0.5, -0.5, 0.25));
	}
	
}
