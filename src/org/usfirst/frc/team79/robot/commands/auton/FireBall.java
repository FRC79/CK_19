package org.usfirst.frc.team79.robot.commands.auton;

import org.usfirst.frc.team79.robot.commands.CommandBase;

public class FireBall extends CommandBase {

	public FireBall() {
		requires(fire);
	}

	@Override
	protected void initialize() {
		
	}

	@Override
	protected void execute() {
//		if(!fire.isIntakeEmpty()) {
//			fire.setFireIntake(1.0);
//		} else {
//			Timer.delay(0.5);
//			fire.setFireIntake(0);
//		}
		fire.setFireIntake(1.0);
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
