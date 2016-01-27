package org.usfirst.frc.team79.robot.commands;

import org.usfirst.frc.team79.robot.commands.firingstate.Firing;
import org.usfirst.frc.team79.robot.commands.firingstate.Holding;
import org.usfirst.frc.team79.robot.commands.firingstate.Intaking;
import org.usfirst.frc.team79.robot.commands.firingstate.State;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Fire extends CommandBase {
	
	State intakingState;
	State holdingState;
	State firingState;

	State state;
	
	public Fire() {
		
		requires(fire);
		
		intakingState = new Intaking(this);
		holdingState = new Holding(this);
		firingState = new Firing(this);
		
		state = intakingState;
		
	}

	@Override
	protected void initialize() {
		
	}

	@Override
	protected void execute() {
		SmartDashboard.putBoolean("Is the Intake Empty?", isIntakeEmpty());
		SmartDashboard.putBoolean("Is the Ball Being Held?", isBallHeld());
		state.execute();
	}
	
	public boolean isBallHeld() {
		return fire.isBallHeld();
	}
	
	public boolean isIntakeEmpty() {
		return fire.isIntakeEmpty();
	}

	public void setFireIntake(double speed) {
		fire.setFireIntake(speed);
	}
	
	public void setState(State state) {
		this.state = state;
	}
	
	public State getIntakingState() {
		return intakingState;
	}
	
	public State getHoldingState() {
		return holdingState;
	}
	
	public State getFiringState() {
		return firingState;
	}
	
	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {

	}

	@Override
	protected void interrupted() {

	}

}
