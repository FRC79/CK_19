package org.usfirst.frc.team79.robot.commands.firingstate;

import org.usfirst.frc.team79.robot.OI;
import org.usfirst.frc.team79.robot.commands.Fire;

public class Holding implements State {
	
	Fire fireMechanism;
	
	public Holding(Fire fireMechanism) {
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
