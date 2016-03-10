package org.usfirst.frc.team79.robot.commands.teleop;

import org.usfirst.frc.team79.robot.commands.CommandBase;
import org.usfirst.frc.team79.robot.commands.teleop.drivingstate.ArcadeState;
import org.usfirst.frc.team79.robot.utilities.State;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Drive extends CommandBase {
	
	State drivingArcadeState;
	State state;
	
	public Drive() {
		
		requires(drivetrain);
		
		drivingArcadeState = new ArcadeState(drivetrain);
		
		state = drivingArcadeState;
		
	}
	
	public void setState(State state) {
		this.state = state;
	}
	
	@Override
	protected void initialize() {
		
	}

	@SuppressWarnings("deprecation")
	@Override
	protected void execute() {
		state.execute();
		SmartDashboard.putDouble("Left encoder in Feet", drivetrain.getLeftEncoder());
		SmartDashboard.putDouble("Right Encoder Feet", drivetrain.getRightEncoder());
		SmartDashboard.putDouble("Gyro degrees", gyro.getGyroAngle());
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
