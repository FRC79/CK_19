package org.usfirst.frc.team79.robot.commands;

import org.usfirst.frc.team79.robot.subsystems.DriveTrain;
import org.usfirst.frc.team79.robot.subsystems.FiringMechanism;
import org.usfirst.frc.team79.robot.subsystems.GyroSystem;
import org.usfirst.frc.team79.robot.subsystems.PlowMechanism;

import edu.wpi.first.wpilibj.command.Command;

public abstract class CommandBase extends Command {
	
	public static DriveTrain driveTrain;	
	public static PlowMechanism intake;
	public static FiringMechanism fire;
	public static GyroSystem gyro;
	
	public static void init() {
		driveTrain = new DriveTrain();
		intake = new PlowMechanism();
		fire = new FiringMechanism();
		gyro = new GyroSystem();
	}

	public CommandBase(String name) {
        super(name);
    }

    public CommandBase() {
        super();
    }
    
}
