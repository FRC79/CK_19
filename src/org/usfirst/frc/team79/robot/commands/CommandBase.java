package org.usfirst.frc.team79.robot.commands;

import org.usfirst.frc.team79.robot.OI;
import org.usfirst.frc.team79.robot.subsystems.DriveTrain;
import org.usfirst.frc.team79.robot.subsystems.FiringMechanism;
import org.usfirst.frc.team79.robot.subsystems.IntakeMechanism;
import org.usfirst.frc.team79.robot.subsystems.WinchMechanism;

import edu.wpi.first.wpilibj.command.Command;

public abstract class CommandBase extends Command {
	
	public static DriveTrain driveTrain;	
	public static OI oi;
	public static IntakeMechanism plow;
	public static FiringMechanism fire;
	public static WinchMechanism WinchStart;
	
	public static void init() {
		driveTrain = new DriveTrain();
		plow = new IntakeMechanism();
		oi = new OI();
		fire = new FiringMechanism();
		WinchStart = new WinchMechanism();
	}

	public CommandBase(String name) {
        super(name);
    }

    public CommandBase() {
        super();
    }
    
}
