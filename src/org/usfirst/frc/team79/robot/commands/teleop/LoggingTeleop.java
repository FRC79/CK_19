package org.usfirst.frc.team79.robot.commands.teleop;

import org.usfirst.frc.team79.robot.commands.teleop.logging.RecordDrivetrain;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class LoggingTeleop extends CommandGroup {
	
	public LoggingTeleop() {
		addParallel(new RecordDrivetrain());
	}

}
