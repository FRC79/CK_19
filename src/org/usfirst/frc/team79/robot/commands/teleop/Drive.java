package org.usfirst.frc.team79.robot.commands.teleop;

import org.usfirst.frc.team79.robot.commands.CommandBase;
import org.usfirst.frc.team79.robot.commands.teleop.drivingstate.ArcadeState;
import org.usfirst.frc.team79.robot.utilities.State;

public class Drive extends CommandBase {
	
	State drivingArcadeState;
	State state;
	
	public Drive() {
		
		requires(driveTrain);
		
		drivingArcadeState = new ArcadeState(this);
		
		state = drivingArcadeState;
		
	}
	
	public void setState(State state) {
		this.state = state;
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
