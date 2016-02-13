package org.usfirst.frc.team79.robot.commands.WinchState;

import org.usfirst.frc.team79.robot.OI;
import org.usfirst.frc.team79.robot.commands.Winch;

public class Resting  implements State {
	Winch  WinchMechanism;
	
	public Resting (Winch WinchMechanism) {
		this.WinchMechanism = WinchMechanism;

	}

	@Override
	public void execute() {
		if (OI.WinchStart.get()) {
			
			WinchMechanism.setState(WinchMechanism.getRotateState());
			
		}
	}
}
