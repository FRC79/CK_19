package org.usfirst.frc.team79.robot.commands.auton;

import org.usfirst.frc.team79.robot.commands.CommandBase;

public class FireBall extends CommandBase {
	
	private boolean fired;
	private long lastFiringTime;
	
	public FireBall() {
		requires(cannon);
	}

	@Override
	protected void initialize() {
		
	}

	@Override
	protected void execute() {
		if(!fired) {
			long currentTime = System.currentTimeMillis();
			if(!cannon.isIntakeEmpty()) {
				cannon.setFireIntake(1.0);
				lastFiringTime = currentTime;
			} else {
				if(currentTime >= lastFiringTime + 2 || currentTime < lastFiringTime) {
					cannon.setFireIntake(0);
					fired = true;
				}
			}
		}
	}
	
	@Override
	protected boolean isFinished() {
		return fired;
	}

	@Override
	protected void end() {
		
	}

	@Override
	protected void interrupted() {
		
	}
}
