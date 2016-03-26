package org.usfirst.frc.team79.robot.commands.teleop;

import org.usfirst.frc.team79.robot.OI;
import org.usfirst.frc.team79.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ManipulateWinch extends CommandBase {
	
	boolean elevationUpToggle;
	boolean elevationDownToggle;
	
	boolean manualUpSwitch;
	boolean manualDownSwitch;
	
	boolean overrideBothUpSwitch;
	boolean overrideBothDownSwitch;
	
	boolean servoToggle;
	boolean servoButtonToggle;
	
	boolean servoEngaged;
	
	private final double ELEVATION_MAX = 0.72; 
	private final double ELEVATION_COMP_MIN = 0.17; // previous comp value @ 0.17
	
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
		
	}
	
	private void listenPneumaticToggle() {
		
		if(OI.manualArmUp.get() && !manualUpSwitch) {
			manualUpSwitch = true;
		} else if(!OI.manualArmUp.get() && manualUpSwitch) {
			manualUpSwitch = false;
			winch.set(Value.kForward);
		}
		
		if(OI.manualArmDown.get() && !manualDownSwitch) {
			manualDownSwitch = true;
		} else if(!OI.manualArmDown.get() && manualDownSwitch) {
			manualDownSwitch = false;
			winch.set(Value.kReverse);
		}
		
		if(OI.overrideBothUp.get() && !overrideBothUpSwitch) {
			overrideBothUpSwitch = true;
		} else if(!OI.overrideBothUp.get() && overrideBothUpSwitch) {
			overrideBothUpSwitch = false;
			winch.set(Value.kForward);
		}
		
		if(OI.overrideBothDown.get() && !overrideBothDownSwitch) {
			overrideBothDownSwitch = true;
		} else if(!OI.overrideBothDown.get() && overrideBothDownSwitch) {
			overrideBothDownSwitch = false;
			winch.set(Value.kReverse);
		}
		
	}
	
	private void listenMoveArm() {
		
//		 || (elevationValue < 0 && winch.getLimit())
		
		double elevationValue = -OI.gamePad.getY();
		
		if((winch.getElevationValue() >= ELEVATION_MAX && elevationValue > 0)) {
			winch.elevate(0);
		} else if((winch.getElevationValue() <= ELEVATION_COMP_MIN && elevationValue < 0)) {
			winch.elevate(0);
		} else {
			winch.elevate(elevationValue);
		}
		
//		if(OI.elevateUp.get() && !elevationUpToggle) {
//			elevationUpToggle = true;
//		} else if(!OI.elevateUp.get() && elevationUpToggle) {
//			if(winch.getElevationValue() <= ELEVATION_MAX) {
//				winch.elevate(1.0);
//			} else {
//				winch.elevate(0);
//				elevationUpToggle = false;
//			}
//		}
//		
//		if(OI.elevateDown.get() && !elevationDownToggle) {
//			elevationDownToggle = true;
//		} else if(!OI.elevateDown.get() && elevationDownToggle) {
//			if(winch.getElevationValue() >= ELEVATION_COMP_MIN) {
//				winch.elevate(-1.0);
//			} else {
//				winch.elevate(0);
//				elevationDownToggle = false;
//			}
//		}
		
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
		
	}

	@Override
	protected void interrupted() {
		
	}

}
