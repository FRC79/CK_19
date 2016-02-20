package org.usfirst.frc.team79.robot.commands.auton;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonA extends CommandGroup {
	
	public AutonA() {
		addSequential(new DriveBot(0.0, 1.0));
		addSequential(new DriveBot(1.0, 1.5));
		addSequential(new DriveBot(0, 0.5));
		addSequential(new rotateBotDegrees(90));
		addSequential(new DriveBot(1.0, 1.0));
		addSequential(new rotateBotDegrees(60));
		addSequential(new FireBall());
	}

}
