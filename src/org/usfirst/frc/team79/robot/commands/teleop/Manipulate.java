package org.usfirst.frc.team79.robot.commands.teleop;

import org.usfirst.frc.team79.robot.OI;
import org.usfirst.frc.team79.robot.commands.CommandBase;
import org.usfirst.frc.team79.robot.commands.teleop.manipulatorstate.Firing;
import org.usfirst.frc.team79.robot.commands.teleop.manipulatorstate.Intaking;
import org.usfirst.frc.team79.robot.commands.teleop.manipulatorstate.PlowDown;
import org.usfirst.frc.team79.robot.commands.teleop.manipulatorstate.PlowUp;
import org.usfirst.frc.team79.robot.commands.teleop.manipulatorstate.State;

public class Manipulate extends CommandBase {
	
	public State intakingState;
	public State firingState;
	public State plowDownState;
	public State plowUpState;

	boolean fireToggle;
	boolean intakeToggle;
	boolean upToggle;
	boolean downToggle;
	
	public State state;
	
	public boolean fired = false;
	
	public Manipulate() {
		
		requires(fire);
		requires(intake);
		
		intakingState = new Intaking(this);
		firingState = new Firing(this);
		plowDownState = new PlowDown(this);
		plowUpState = new PlowUp(this);
		
		state = plowUpState;
		
	}

	@Override
	protected void initialize() {

	}

	@Override
	protected void execute() {
		
		if(OI.firing.get()) {
			fireToggle = true;
		} else if(fireToggle && !OI.firing.get()) {
			fireToggle = false;
			setState(firingState);
		}
		
		if(OI.intaking.get()) {
			intakeToggle = true;
		} else if(intakeToggle && !OI.intaking.get()) {
			intakeToggle = false;
			setState(intakingState);
		}
		
		if(OI.plowUp.get()) {
			upToggle = true;
		} else if(upToggle && !OI.plowUp.get()) {
			upToggle = false;
			setState(plowUpState);
		}
		
		if(OI.plowDown.get()) {
			downToggle = true;
		} else if(downToggle && !OI.plowDown.get()) {
			downToggle = false;
			setState(plowDownState);
		}
		
		state.execute();
		
	}
	
	public boolean hasFired() {
		return fired;
	}
	
	public void setFired(boolean val) {
		fired = val;
	}
	
	public boolean isBallHeld() {
		return fire.isBallHeld();
	}
	
	public boolean isIntakeEmpty() {
		return fire.isIntakeEmpty();
	}
	
	public double getIntakeRotation() {
		return intake.getDistance();
	}
	
	public void rotateIntake(double speed) {
		intake.rotate(speed);
	}

	public void setFireIntake(double speed) {
		fire.setFireIntake(speed);
	}
	
	public void setState(State state) {
		this.state = state;
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
