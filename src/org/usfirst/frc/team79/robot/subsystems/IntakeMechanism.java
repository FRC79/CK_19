package org.usfirst.frc.team79.robot.subsystems;

import org.usfirst.frc.team79.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class IntakeMechanism extends Subsystem {
	
	Encoder intakeEncoder;
	Victor motor;
	
	public IntakeMechanism() {
		
		motor = new Victor(RobotMap.INTAKEROLLER);
		
		intakeEncoder = new Encoder(RobotMap.INTAKEENCODERA, RobotMap.INTAKEENCODERB);
		intakeEncoder.setMaxPeriod(1.0);
		intakeEncoder.setDistancePerPulse(0.00208768267D);
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
