package org.usfirst.frc.team79.robot;

import org.usfirst.frc.team79.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.command.Command;
public abstract class CommandBase extends Command {

	public static DriveTrain drive;
	
	public static void init() {
		drive = new DriveTrain();
	}
	
	public CommandBase(String name) {
		super(name);
	}
	
	public CommandBase() {
		super();
	}
	
}
