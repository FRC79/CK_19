package org.usfirst.frc.team79.robot.commands;

import org.usfirst.frc.team79.robot.OI;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class RotatePlow extends CommandBase {
	
	double encoderCurrent;
	double duration = 10.0D;
	
	public RotatePlow() {
		requires(plow);
	}

	@Override
	protected void initialize() {
		encoderCurrent = plow.getDistance();
		setTimeout(duration);
	}

	@Override
	protected void execute() {
        SmartDashboard.putDouble("revolutions?", plow.getDistance());

        if(OI.Drive.get()== true){
        	if(plow.getDistance()< 0.34 ){
        		plow.rotate(.5);
        	}
        	else if(plow.getDistance()> 0.4) {
        		plow.rotate(-.5);
        	}
        	else if(plow.getDistance()> 0.36 || plow.getDistance()< 0.38) {
        		plow.rotate(0);
        	}
        }
        if(OI.FireBall.get()== true){
        	if(plow.getDistance()< -.3 ){
        		plow.rotate(.5);
        	}
        	else if(plow.getDistance()> 0.3) {
        		plow.rotate(-.5);
        	}
        	else if(plow.getDistance()> 0.0 || plow.getDistance()< 0.0) {
        		plow.rotate(0);
        	}
        	
        }
        if(OI.Up.get()== true){
        	if(plow.getDistance()< 0.2 ){
        		plow.rotate(.5);
        	}
        	else if(plow.getDistance()> 0.3) {
        		plow.rotate(-.5);
        	}
        	else if(plow.getDistance()> 0.21 || plow.getDistance()< 0.25) {
        		plow.rotate(0);
        	}
        }
            if(OI.Intake.get()== true){
            	if(plow.getDistance()< 0.2 ){
            		plow.rotate(.5);
            	}
            	else if(plow.getDistance()> 0.3) {
            		plow.rotate(-.5);
            	}
            	else if(plow.getDistance()> 0.21 || plow.getDistance()< 0.25) {
            		plow.rotate(0);
            	}
        }

        
	}

	@Override
	protected boolean isFinished() {
		return isTimedOut();
	}

	@Override
	protected void end() {
		plow.rotate(0.0);;
	}

	@Override
	protected void interrupted() {
	
	}

}
