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
	
	public static DriveTrain drivetrain;	
	public static PlowMechanism plow;
	public static FiringMechanism cannon;
	public static GyroSystem gyro;
	public static WinchMechanism winch;
//	public static SonarMechanism sonar;
	
	public static void init() {
		drivetrain = new DriveTrain();
		plow = new PlowMechanism();
		cannon = new FiringMechanism();
		gyro = new GyroSystem();
		winch = new WinchMechanism();
//		sonar = new SonarMechanism();
	}

	public CommandBase(String name) {
        super(name);
    }

    public CommandBase() {
        super();
    }
    
}
