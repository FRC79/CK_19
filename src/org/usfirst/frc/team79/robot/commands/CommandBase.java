package org.usfirst.frc.team79.robot.commands;

import org.usfirst.frc.team79.robot.OI;
import org.usfirst.frc.team79.robot.subsystems.DriveTrain;
import org.usfirst.frc.team79.robot.subsystems.FiringMechanism;
import org.usfirst.frc.team79.robot.subsystems.IntakeMechanism;

import edu.wpi.first.wpilibj.command.Command;

public abstract class CommandBase extends Command {
	
	public static DriveTrain driveTrain;	
	public static OI oi;
	public static IntakeMechanism intake;
	public static FiringMechanism fire;
	
	public static void init() {
		driveTrain = new DriveTrain();
		intake = new IntakeMechanism();
		oi = new OI();
		fire = new FiringMechanism();
	}

	public CommandBase(String name) {
        super(name);
    }

    public CommandBase() {
        super();
    }
    
}
