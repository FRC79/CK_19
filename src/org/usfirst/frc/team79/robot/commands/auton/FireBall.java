package org.usfirst.frc.team79.robot.commands.auton;

import org.usfirst.frc.team79.robot.commands.CommandBase;

public class FireBall extends CommandBase {
	
	private boolean fired;
	private long lastFiringTime;
	
	public FireBall() {
		requires(fire);
	}

	@Override
	protected void initialize() {
		
	}

	@Override
	protected void execute() {
		if(!fired) {
			long currentTime = System.currentTimeMillis();
			if(!fire.isIntakeEmpty()) {
				fire.setFireIntake(1.0);
				lastFiringTime = System.currentTimeMillis();
			} else {
				if(currentTime >= lastFiringTime || currentTime < lastFiringTime) {
					fire.setFireIntake(0);
					fired = true;
				}
			}
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
