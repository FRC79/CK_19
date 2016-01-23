package org.usfirst.frc.team79.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class RotateIntake extends CommandBase {
	
	double encoderCurrent;
	double duration = 10.0D;
	
	public RotateIntake() {
		requires(intake);
	}

	@Override
	protected void initialize() {
		encoderCurrent = intake.getDistance();
		setTimeout(duration);
	}

	@Override
	protected void execute() {
		
        SmartDashboard.putDouble("revolutions?", intake.getDistance());
        
        if(intake.getDistance() <= encoderCurrent + 0.25) {
            intake.rotate(0.1);
        } else {
        	intake.rotate(0.0);
        }

        
	}

	@Override
	protected boolean isFinished() {
		return isTimedOut();
	}

	@Override
	protected void end() {
		intake.rotate(0);
	}

	@Override
	protected void interrupted() {
	
	}

}
