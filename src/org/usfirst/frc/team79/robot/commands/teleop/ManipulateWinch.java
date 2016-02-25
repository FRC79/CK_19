package org.usfirst.frc.team79.robot.commands.teleop;

import org.usfirst.frc.team79.robot.OI;
import org.usfirst.frc.team79.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ManipulateWinch extends CommandBase {

	boolean toggle;
	boolean buttonToggle;
	
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
		
		double joyValue = OI.getY();
		boolean joystickForward = !(joyValue > 0); // joystick moving up registers as a negative value, and down registers as a positive value
		
		if(OI.winchArmToggle.get() && !buttonToggle) {
			buttonToggle = true;
		} else if(!OI.winchArmToggle.get() && buttonToggle) {
			buttonToggle = false;
			winch.set(toggle ? Value.kForward : Value.kReverse);
			toggle = !toggle;
		}
		
		// if the joystick is positive, and we're below the string pots max
		if(joystickForward && winch.getElevationValue() < ELEVATION_MAX) {
		// we set the elevation motors to the joystick's value
			winch.elevate(joyValue);
		// if the joystick is negative, and the limit switch isn't triggered
		} else if(!joystickForward && !winch.getLimit()) {
		// we set the elevation motors to the joysticl's value
			winch.elevate(joyValue);
		// if the joystick is positive, and we're above the max
		// or the joystick is negative and we've flipped the switch
		// than kill the motors
		} else {
			winch.elevate(0);
		}
		
		SmartDashboard.putDouble("Elevation Potentiometer Value", winch.getElevationValue());
		SmartDashboard.putBoolean("Limit Switch for elevation stop", winch.getLimit());
		
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
