package org.usfirst.frc.team79.robot.commands.auton;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class NavigateLowBar extends CommandGroup {
	
	public NavigateLowBar() {
//		addSequential(new DriveBot(1.0, 1.0));
		addSequential(new rotateBotDegrees(90));
		addSequential(new rotateBotDegrees(-90));
//		addSequential(new DriveBot(1.0, 1.0));
//		addSequential(new FireBall());
	}
	
}
