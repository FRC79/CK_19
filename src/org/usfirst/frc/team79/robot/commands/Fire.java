package org.usfirst.frc.team79.robot.commands;

import org.usfirst.frc.team79.robot.OI;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Fire extends CommandBase {
	
	public boolean toggle = false;
	public boolean firing = false;
	
	public Fire() {
		requires(fire);
	}

	@Override
	protected void initialize() {
		
	}

	@Override
	protected void execute() {
		
		SmartDashboard.putBoolean("BannerFront", fire.getFront());
		SmartDashboard.putBoolean("BannerBack", fire.getBack());
		
		if(
			(!fire.getFront() && !fire.getBack() && !toggle) || 
			(fire.getFront() && !fire.getBack() && !toggle)
		) {
			
			fire.setFireIntake(-1.0);
			
		}
		
		if(
			(fire.getBack() && fire.getBack()) ||
			(!fire.getBack() && fire.getFront() && toggle)
			) {
			
			if(!toggle) {
				fire.setFireIntake(0.0);
			}
			toggle = true;
			
		}
		
		if(toggle) {
			
			if(OI.fire.get()) {
				firing = true;
			}
			
			if(firing) {
				fire.setFireIntake(1.0);
			}
			
			if(!fire.getBack() && !fire.getFront()) {
				toggle = false;
				firing = false;
				Timer.delay(2.0);
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
