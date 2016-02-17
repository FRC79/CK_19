package org.usfirst.frc.team79.robot.subsystems;

import org.usfirst.frc.team79.robot.RobotMap;
import org.usfirst.frc.team79.robot.utilities.LimitSwitch;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class IntakeMechanism extends Subsystem {
	
	Encoder intakeEncoder;
	Victor motor;
	
	// this beautifully magical constant
	// is the optical encoders distance per one revolution
	// and yeas the divisor of 2.5 is to account for the gearing on the intake arm
	// <twitches>
	double DISTPERPULSE = 0.00208768267d / 2.5; // gear ratio is (aproximately) 1 to 2
	
	LimitSwitch calibrationSwitch = new LimitSwitch(RobotMap.LIMITARM);
	
	public IntakeMechanism() {
		
		motor = new Victor(RobotMap.INTAKEMOTOR);
		
		intakeEncoder = new Encoder(RobotMap.INTAKEENCODERA, RobotMap.INTAKEENCODERB);
		intakeEncoder.setMaxPeriod(1.0);
		intakeEncoder.setDistancePerPulse(DISTPERPULSE);  // mult by 1.93 : 2 aproximately
		intakeEncoder.reset();
		
	}

	@Override
	protected void initDefaultCommand() {
		
	}
	
	// rotate the arm's motor
	public void rotate(double speed) {
		motor.set(speed);
	}
	
	// get the optical encoders current distance
	public double getDistance() {
		return Math.abs(intakeEncoder.getDistance());
	}
	
	// not sure I should have this hear anymore, the rotate command in auton is now obsolete
	public boolean getFinished() {
		return intakeEncoder.getStopped();
	}
	
	// resets the encoder to zero, used for calibration
	public void reset() {
		intakeEncoder.reset();
	}
	
	// returns the limit switch value
	public boolean getLimit() {
		return calibrationSwitch.get();
	}
	
}
