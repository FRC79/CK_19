package org.usfirst.frc.team79.robot.commands;

import org.usfirst.frc.team79.robot.commands.drivingstate.ArcadeState;
import org.usfirst.frc.team79.robot.commands.drivingstate.State;
import org.usfirst.frc.team79.robot.commands.drivingstate.TankState;

public class Drive extends CommandBase {
	
	State drivingArcadeState;
	State drivingTankState;
	State state;
	
	public Drive() {
		
		requires(driveTrain);
		
		drivingArcadeState = new ArcadeState(this);
		drivingTankState = new TankState(this);
		
		state = drivingArcadeState;
		
	}
	
	public void setState(State state) {
		this.state = state;
	}
	
	public State getArcadeState() {
		return drivingArcadeState;
	}
	
	public State getTankState() {
		return drivingTankState;
	}

	public void tankDrive(double left, double right) {
		driveTrain.moveTank(left, right);
	}
	
	public void arcadeDrive(double moveValue, double rotateValue) {
		driveTrain.moveArcade(moveValue, rotateValue);
	}
	
	@Override
	protected void initialize() {
		
	}

	@Override
	protected void execute() {
		state.execute();
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
