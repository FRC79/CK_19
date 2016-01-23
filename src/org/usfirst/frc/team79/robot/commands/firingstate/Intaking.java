package org.usfirst.frc.team79.robot.commands.firingstate;

import org.usfirst.frc.team79.robot.commands.Fire;

public class Intaking implements State {
	
	Fire fireMechanism;
	
	public Intaking(Fire fireMechanism) {
		this.fireMechanism = fireMechanism;
	}
 
	@Override
	public void execute() {
		
		if(fireMechanism.isIntakeEmpty()) {
			fireMechanism.setFireIntake(-1.0);
		}
		
		if(fireMechanism.isBallHeld()) {
			fireMechanism.setState(fireMechanism.getHoldingState());
		}
		
	}

}
