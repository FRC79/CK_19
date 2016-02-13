package org.usfirst.frc.team79.robot.commands.RollerState;

import org.usfirst.frc.team79.robot.commands.Fire;

import edu.wpi.first.wpilibj.Timer;

public class RollerFiring implements State {
	
	Fire fireMechanism;
	
	public RollerFiring(Fire fireMechanism) {
		this.fireMechanism = fireMechanism;
	}

	@Override
	public void execute() {
		
		if(!fireMechanism.isIntakeEmpty()) {
			fireMechanism.setFireIntake(1.0);
		}
		
		if(fireMechanism.isIntakeEmpty()) {
			Timer.delay(2.0);
			fireMechanism.setState(fireMechanism.getIntakingState());
			Timer.delay(1.0);

		}
		
	}

}
