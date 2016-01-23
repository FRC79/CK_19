package org.usfirst.frc.team79.robot.subsystems;

import org.usfirst.frc.team79.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class FiringMechanism extends Subsystem {
	
	public DigitalInput bannerFront;
	public DigitalInput bannerBack;
	
	public Victor intakeFire;
	
	public FiringMechanism() {
		bannerFront = new DigitalInput(4);
		bannerBack = new DigitalInput(5);
		intakeFire = new Victor(RobotMap.INTAKEFIRINGMOTOR);
	}
	
	public void setFireIntake(double direction) {
		intakeFire.set(direction);
	}
	
	public boolean isBallHeld() {
		return (bannerFront.get() && bannerBack.get());
	}
	
	public boolean isIntakeEmpty() {
		return (!bannerFront.get() && !bannerBack.get());
	}

	@Override
	protected void initDefaultCommand() {
		
	}

}
