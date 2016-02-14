package org.usfirst.frc.team79.robot.commands.auton;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Auton extends CommandGroup {
	
	public Auton() {
		addSequential(new rotateBotDegrees(90), 5.0);
		addSequential(new rotateBotDegrees(-90), 5.0);
		addSequential(new rotateBotDegrees(45), 5.0);
		addSequential(new rotateBotDegrees(-45), 5.0);
	}

}
