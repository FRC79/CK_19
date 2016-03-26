package org.usfirst.frc.team79.robot.commands.auton.commands;

import org.usfirst.frc.team79.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class SetWinch extends CommandBase {
	
	Value value;
	boolean isFinished;
	
	public SetWinch(Value value) {
		requires(winch);
		this.value = value;
	}

	@Override
	protected void initialize() {
		
	}

	@Override
	protected void execute() {
		winch.set(value);
		isFinished = true;
	}

	@Override
	protected boolean isFinished() {
		return isFinished;
	}

	@Override
	protected void end() {
		
	}

	@Override
	protected void interrupted() {
		
	}

}
