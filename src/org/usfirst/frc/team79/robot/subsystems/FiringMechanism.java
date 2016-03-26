package org.usfirst.frc.team79.robot.subsystems;

import org.usfirst.frc.team79.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class FiringMechanism extends Subsystem {
	
	// the firing mechanism for this bot has 2 banner sensors
	// that trip to let us know when a ball is in the actual mechanics of the firing mechanism
	
	public DigitalInput bannerFront;
	public DigitalInput bannerBack;
	
	// motor to control the actual firing/intaking motor
	
	public Victor intakeFire;
		
	// create the mechanism object
	public FiringMechanism() {
		bannerFront = new DigitalInput(4);
		bannerBack = new DigitalInput(5);
		intakeFire = new Victor(RobotMap.FIRINGMOTOR);
	}
	
	// a semi obtuse name for setting
	// the motor in the mechanism
	// that is used for both firing and intaking
	public void setFireIntake(double direction) {
		intakeFire.set(direction);
	}
	
	// returns true if both banners are tripped
	public boolean isBallHeld() {
		return (!bannerFront.get() && !bannerBack.get());
	}
	
	// returns true if both banners are clear
	public boolean isIntakeEmpty() {
		return (bannerBack.get());
	}

	// again, we literally never use this
	@Override
	protected void initDefaultCommand() {
		
	}

}
