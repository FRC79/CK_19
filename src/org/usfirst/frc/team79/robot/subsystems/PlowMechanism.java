package org.usfirst.frc.team79.robot.subsystems;

import org.usfirst.frc.team79.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class PlowMechanism extends Subsystem {
	
	Encoder intakeEncoder;
	Victor motor;
	
	double DISTPERPULSE = 0.00208768267d / 2.5; // gear ratio is (aproximately) 1 to 2
	
	public PlowMechanism() {
		
		motor = new Victor(RobotMap.PLOWMOTOR);
		
		intakeEncoder = new Encoder(RobotMap.INTAKEENCODERA, RobotMap.INTAKEENCODERB);
		intakeEncoder.setMaxPeriod(1.0);
		intakeEncoder.setDistancePerPulse(DISTPERPULSE);  // mult by 1.93 : 2 aproximately
		intakeEncoder.reset();
		
	}

	@Override
	protected void initDefaultCommand() {
		
	}
	
	public void rotate(double speed) {
		motor.set(speed);
	}
	
	public double getDistance() {
		return Math.abs(intakeEncoder.getDistance());
	}
	
	public boolean getFinished() {
		return intakeEncoder.getStopped();
	}

}
