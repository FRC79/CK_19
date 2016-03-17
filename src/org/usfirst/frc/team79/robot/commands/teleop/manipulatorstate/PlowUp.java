package org.usfirst.frc.team79.robot.commands.teleop.manipulatorstate;

import org.usfirst.frc.team79.robot.subsystems.FiringMechanism;
import org.usfirst.frc.team79.robot.subsystems.PlowMechanism;
import org.usfirst.frc.team79.robot.utilities.State;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class PlowUp implements State {
	
	FiringMechanism firingSystem;
	PlowMechanism intakeSystem;
	
	public PlowUp(FiringMechanism firingSystem, PlowMechanism intakeSystem) {
		this.firingSystem = firingSystem;
		this.intakeSystem = intakeSystem;
	}

	@Override
	public void execute() {
		firingSystem.setFireIntake(0);
		intakeSystem.set(Value.kReverse);
	}

}
