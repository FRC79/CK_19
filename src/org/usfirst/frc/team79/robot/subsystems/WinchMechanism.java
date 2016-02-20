package org.usfirst.frc.team79.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class WinchMechanism extends Subsystem {
	
	// has a lot of maturing to do
	// expect to change some
	
	Encoder winchArmEncoder;
	Encoder winchExtendEncoder;
	
	Victor push, pull;
	Victor rotator;
	
	double DISTPERPULSE = 0.00208768267d;
	
	public WinchMechanism() {
		
		push = new Victor(6);
		pull = new Victor(7);
		rotator = new Victor(10);
		
		winchArmEncoder = new Encoder(6, 7);
		winchArmEncoder.setMaxPeriod(1.0);
		winchArmEncoder.setDistancePerPulse(DISTPERPULSE);  // mult by 1.93 : 2 aproximately
		winchArmEncoder.reset();
		
		winchExtendEncoder = new Encoder(12, 13);
//		winchExtendEncoder.setMaxPeriod(1.0);
//		winchExtendEncoder.setDistancePerPulse(DISTPERPULSE);
		winchExtendEncoder.reset();
		
	}
	
	public void rotate(double speed) {
		rotator.set(speed);
	}
	
	public double getArmRotationDistance() {
		return winchArmEncoder.getDistance();
		//moving down down is positive;
	}
	
	public double getExtendDistance() {
		return winchExtendEncoder.getDistance();
	}
	
	public void extend(double speed) {
		push.set(speed);
		pull.set(-speed);
	}

	@Override
	protected void initDefaultCommand() {
		
	}

}
