package org.usfirst.frc.team79.robot.commands.teleop;

import org.usfirst.frc.team79.robot.OI;
import org.usfirst.frc.team79.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class DumbManupulatePlow extends CommandBase {
	
	boolean manualPlowUpToggle;
	boolean manualPlowDownToggle;
	
	boolean bothUpToggled;
	boolean bothDownToggled;
	
	public DumbManupulatePlow() {
		requires(plow);
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void execute() {
		
		listenPlow();

	}

	private void listenPlow() {
		
		if(OI.manualPlowUp.get() && !manualPlowUpToggle) {
			manualPlowUpToggle = true;
		} else if(!OI.manualPlowUp.get() && manualPlowUpToggle) {
			plow.set(Value.kReverse);
			manualPlowUpToggle = false;
		}
		
		if(OI.manualPlowDown.get() && !manualPlowDownToggle) {
			manualPlowUpToggle = true;
		} else if(!OI.manualPlowDown.get() && manualPlowDownToggle) {
			plow.set(Value.kForward);
			manualPlowDownToggle = false;
		}
		
		if(OI.overrideBothUp.get() && !bothUpToggled) {
			bothUpToggled = true;
		} else if(!OI.overrideBothUp.get() && bothUpToggled) {
			plow.set(Value.kReverse);
			manualPlowUpToggle = false;
		}
		
		if(OI.overrideBothDown.get() && !bothDownToggled) {
			bothDownToggled = true;
		} else if(!OI.overrideBothDown.get() && bothDownToggled) {
			plow.set(Value.kForward);
			manualPlowUpToggle = false;
		}
		
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
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
