package org.usfirst.frc.team79.robot.commands.WinchState;

import org.usfirst.frc.team79.robot.commands.Winch;
import org.usfirst.frc.team79.robot.subsystems.WinchMechanism;

public class Extend implements State {
	Winch  WinchCommand;
	WinchMechanism winch;
	
	public Extend (Winch WinchCommand) {
		this.WinchCommand = WinchCommand;
	}
	@Override
	public void execute() {// distance meters
		if(winch.getDistance() < 2) {
			winch.Increase(1);
		}
		else
		{
			winch.Increase(0);
			WinchCommand.setState(WinchCommand.getWaitingState());

		}
	}
}
