package org.usfirst.frc.team79.robot.subsystems;

import org.usfirst.frc.team79.robot.RobotMap;
import org.usfirst.frc.team79.robot.utilities.LimitSwitch;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class WinchMechanism extends Subsystem {
	
	DoubleSolenoid wincher;
	Victor elevator;
	Victor elevatorComplement;
	AnalogPotentiometer elevationPot;
	LimitSwitch lowerStop;	
	
	public WinchMechanism() {
		elevator = new Victor(RobotMap.WINCH_EXTEND);
		elevatorComplement = new Victor(RobotMap.WINCH_EXTEND_OPPOSITE);
		wincher = new DoubleSolenoid(RobotMap.WINCH_SOLENOID_A, RobotMap.WINCH_SOLENOID_B);
		elevationPot = new AnalogPotentiometer(RobotMap.WINCH_ELEVATION_POTENTIOMETER);
		wincher.set(Value.kReverse);
		lowerStop = new LimitSwitch(RobotMap.LIMIT_BOTTOM_ELEVATOR);
	}
	
	public void elevate(double speed) {
		elevator.set(speed);
		elevatorComplement.set(-speed);
	}
	
	public boolean getLimit() {
		return lowerStop.get();
	}

	public void set(Value value) {
		wincher.set(value);
	}
	
	public double getElevationValue() {
		return elevationPot.get();
	}
	
	@Override
	protected void initDefaultCommand() {
		
	}

}
