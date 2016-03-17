package org.usfirst.frc.team79.robot.commands.teleop;

import org.usfirst.frc.team79.robot.OI;
import org.usfirst.frc.team79.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.Timer;

public class DumbManipulateShooter extends CommandBase {
	
	double currentTime;
	
	boolean firingToggle;
	boolean intakingToggle;
	
	public DumbManipulateShooter() {
		requires(cannon);
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void execute() {

		if(OI.firing.get() && !firingToggle) {
			firingToggle = true;
			intakingToggle = false;
		} else if(!OI.firing.get() && firingToggle) {
			firingToggle = false;
			fire();
		}
		
		if(OI.intaking.get() && !intakingToggle) {
			firingToggle = true;
			intakingToggle = false;
		} else if(!OI.intaking.get() && intakingToggle) {
			intakingToggle = false;
			intake();
		}
		
	}
	
	private void intake() {
		
		if(!cannon.isBallHeld()) {
			cannon.setFireIntake(-1.0);
		} else {
			cannon.setFireIntake(0);	
		}
		
	}
	
	private void fire() {
		
		if(!cannon.isIntakeEmpty()) {
			cannon.setFireIntake(1.0);
			currentTime = Timer.getFPGATimestamp();
		}
		
		if(cannon.isIntakeEmpty()) {
			if(Timer.getFPGATimestamp() >= currentTime+2.0) {
				cannon.setFireIntake(0);
			}
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
