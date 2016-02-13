package org.usfirst.frc.team79.robot.commands;

import org.usfirst.frc.team79.robot.commands.RollerState.RollerFiring;
import org.usfirst.frc.team79.robot.commands.RollerState.RollerHolding;
import org.usfirst.frc.team79.robot.commands.RollerState.RollerIntaking;
import org.usfirst.frc.team79.robot.commands.RollerState.State;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Fire extends CommandBase {
	

State FiringState;
State HoldingState;
State IntakingState;
State state;
	
	
	public Fire() {
		
		requires(fire);
		IntakingState = new RollerIntaking(this);
		HoldingState = new RollerHolding(this);
		FiringState = new RollerFiring(this);
		
		state = IntakingState;
		
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
	return IntakingState;
}

public State getHoldingState() {
	return HoldingState;
}

public State getFiringState() {
	return FiringState;
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
