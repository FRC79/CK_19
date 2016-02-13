package org.usfirst.frc.team79.robot.commands.RollerState;

import org.usfirst.frc.team79.robot.commands.Fire;

public class RollerLowered implements State {

	
	Fire fireMechanism;
	
	public RollerLowered(Fire fireMechanism) {
		this.fireMechanism = fireMechanism;
	}
	
	@Override
	public void execute() {
		
		if(fireMechanism.isIntakeEmpty()) {
			fireMechanism.setFireIntake(0.0);
		}	
	}
}
