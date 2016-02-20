package org.usfirst.frc.team79.robot.commands.teleop;

import org.usfirst.frc.team79.robot.OI;
import org.usfirst.frc.team79.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ManipulateWinch extends CommandBase {
	
	// very immature
	// expect radical changes
	
	public ManipulateWinch() {
		requires(winch);
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("deprecation")
	@Override
	protected void execute() {
		
		SmartDashboard.putDouble("Encoder for winch extend, distend", winch.getExtendDistance());
		SmartDashboard.putDouble("Encoder value for arm rotation", winch.getArmRotationDistance());
		winch.extend(OI.gamePad.getX());
		winch.rotate(OI.gamePad.getY());
		
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}

}
