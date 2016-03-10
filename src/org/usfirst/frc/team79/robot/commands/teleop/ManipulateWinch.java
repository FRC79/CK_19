package org.usfirst.frc.team79.robot.commands.teleop;

import org.usfirst.frc.team79.robot.OI;
import org.usfirst.frc.team79.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ManipulateWinch extends CommandBase {

	boolean pneumaticToggle;
	boolean pneumaticButtonToggle;
	boolean servoToggle;
	boolean servoButtonToggle;
	
	boolean servoEngaged;
	
	double ELEVATION_MAX = 0.51;
	
	public ManipulateWinch() {
		requires(winch);
	}

	@Override
	protected void initialize() {
		
	}

	@SuppressWarnings("deprecation")
	@Override
	protected void execute() {
				
		listenPneumaticToggle();
		listenMoveArm();
		listenEngageServo();
		
		
		SmartDashboard.putDouble("Elevation Potentiometer Value", winch.getElevationValue());
		SmartDashboard.putBoolean("Limit Switch for elevation stop", winch.getLimit());
		SmartDashboard.getBoolean("Is the servo stop engaged ?", servoEngaged);
		
	}
	
	private void listenPneumaticToggle() {
		
		if(OI.winchArmToggle.get() && !pneumaticButtonToggle) {
			pneumaticButtonToggle = true;
		} else if(!OI.winchArmToggle.get() && pneumaticButtonToggle) {
			pneumaticButtonToggle = false;
			winch.set(pneumaticToggle ? Value.kForward : Value.kReverse);
			pneumaticToggle = !pneumaticToggle;
		}
		
	}
	
	private void listenMoveArm() {
		
		double joyValue = OI.getY();
		boolean joystickForward = !(joyValue > 0);
		
		if(joystickForward && winch.getElevationValue() < ELEVATION_MAX) {
			winch.elevate(joyValue);
		} else if(!joystickForward && !winch.getLimit()) {
			winch.elevate(joyValue);
		} else {
			winch.elevate(0);
		}
		
	}
	
	private void listenEngageServo() {
		
		if(OI.servoStopToggle.get() && !servoButtonToggle) {
			servoButtonToggle = true;
		} else if(!OI.servoStopToggle.get() && servoButtonToggle) {
			servoButtonToggle = false;
			servoToggle = !servoToggle;
			winch.setServo(servoToggle ? 30 : 0);
			servoEngaged = !servoEngaged;
		}
		
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}

}
