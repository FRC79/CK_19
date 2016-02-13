package org.usfirst.frc.team79.robot.subsystems;

import org.usfirst.frc.team79.robot.RobotMap;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class WinchMechanism extends Subsystem {
	//encoders
	
	Encoder RotateEncoder;
	Encoder WinchEncoder;
	
	//motors
	
	Victor WinchMotorLeft;    
	Victor WinchMotorRight;
	Victor ArmMotorLift;
	
	public WinchMechanism() {//constructs encoders
		
	   RotateEncoder = new Encoder (RobotMap.ARMENCODERA, RobotMap.ARMENCODERB);//maps rotate encoder
	   RotateEncoder.setMaxPeriod(1.0); //sets the max period
	   RotateEncoder.setDistancePerPulse(0.00208768267D);//sets the distance per pulse

		WinchEncoder = new Encoder (RobotMap.WINCHENCODERA, RobotMap.WINCHENCODERB);
		WinchEncoder.setMaxPeriod(1.0);
		WinchEncoder.setDistancePerPulse(0.00208768267D);
	
	}
	
		public void Increase(double speed) {
			
			WinchMotorLeft.set(speed);
			WinchMotorRight.set(speed);
	
		}
		
		
		public void rotate (double LiftSpeed) {
			
			ArmMotorLift.set(LiftSpeed);
	
		}
		
		public double getDistance() {
			
			return Math.abs(WinchEncoder.getDistance());
		
		}
		
		public double getAngle() {
			
			return Math.abs(RotateEncoder.getDistance());
		
		}
		
		public boolean getFinishedArm() {
			
			return RotateEncoder.getStopped();
		
		}
		
		public boolean getFinished() {
			
			return WinchEncoder.getStopped();
		}
		
		@Override
		protected void initDefaultCommand() {
			// TODO Auto-generated method stub
			
		}
  }
