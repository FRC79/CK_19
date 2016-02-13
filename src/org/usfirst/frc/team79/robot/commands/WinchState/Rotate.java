package org.usfirst.frc.team79.robot.commands.WinchState;

import org.usfirst.frc.team79.robot.commands.Winch;
import org.usfirst.frc.team79.robot.subsystems.WinchMechanism;;

public class Rotate implements State {

	
	Winch  WinchCommand;
	WinchMechanism winch;
	
	public Rotate (Winch WinchCommand) {
		
		this.WinchCommand = WinchCommand;
	}
	@Override
	public void execute() {
		
		if(winch.getAngle()< 60) {
			winch.rotate(1.0);
		}
		
		else {
			
			winch.rotate(0);
			WinchCommand.setState(WinchCommand.getExtedState());
		
		}
	}

}
