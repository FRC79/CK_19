package org.usfirst.frc.team79.robot.commands.WinchState;

import org.usfirst.frc.team79.robot.commands.Winch;
import org.usfirst.frc.team79.robot.subsystems.WinchMechanism;

public class Pulling implements State {
	Winch  WinchCommand;
	WinchMechanism winch;
	
	public Pulling (Winch WinchCommand) {
		
		this.WinchCommand = WinchCommand;
	
	}
	@Override
	public void execute() {
			// distance meters
		if(winch.getDistance() > 0) {
			winch.Increase(-1);
		}
		else
		{
			winch.Increase(0);
		}
	}
}
