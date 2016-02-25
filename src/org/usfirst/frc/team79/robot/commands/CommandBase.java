package org.usfirst.frc.team79.robot.commands;

import org.usfirst.frc.team79.robot.subsystems.DriveTrain;
import org.usfirst.frc.team79.robot.subsystems.FiringMechanism;
import org.usfirst.frc.team79.robot.subsystems.GyroSystem;
import org.usfirst.frc.team79.robot.subsystems.PlowMechanism;
import org.usfirst.frc.team79.robot.subsystems.WinchMechanism;

import edu.wpi.first.wpilibj.command.Command;

public abstract class CommandBase extends Command {
	
	// the basis for all of our commands
	// the literal core for command based programming
	
	// although its kind of annoying
	// because you can actually say that each written command 
	// is a CommandBase because of its lineage
	
	public static DriveTrain driveTrain;	
	public static PlowMechanism intake;
	public static FiringMechanism fire;
	public static GyroSystem gyro;
	public static WinchMechanism winch;
	
	public static void init() {
		driveTrain = new DriveTrain();
		intake = new PlowMechanism();
		fire = new FiringMechanism();
		gyro = new GyroSystem();
		winch = new WinchMechanism();
	}

	public CommandBase(String name) {
        super(name);
    }

    public CommandBase() {
        super();
    }
    
}
