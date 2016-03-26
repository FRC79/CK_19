package org.usfirst.frc.team79.robot.commands.auton.commands;

import org.usfirst.frc.team79.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class SetPlow extends CommandBase {
	
	Value value;
	boolean isFinished;
	
	public SetPlow(Value value) {
		requires(plow);
		this.value = value;
	}

	@Override
	protected void initialize() {
		
	}

	@Override
	protected void execute() {
		plow.set(value);
		isFinished = true;
	}

	@Override
	protected boolean isFinished() {
		return true;
	}

	@Override
	protected void end() {
		
	}

	@Override
	protected void interrupted() {
		
	}

}
