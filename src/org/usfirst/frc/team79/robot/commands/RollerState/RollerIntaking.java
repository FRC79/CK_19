package org.usfirst.frc.team79.robot.commands.RollerState;

import org.usfirst.frc.team79.robot.OI;
import org.usfirst.frc.team79.robot.commands.Fire;

public class RollerHolding implements State {
	
	Fire fireMechanism;
	
	public RollerHolding(Fire fireMechanism) {
		this.fireMechanism = fireMechanism;
	}

	@Override
	public void execute() {
		
		if(!OI.fire.get()) {
			fireMechanism.setFireIntake(0.0);
		}
		
		if(OI.fire.get()) {
			fireMechanism.setState(fireMechanism.getFiringState());
		}
		
	}

}
