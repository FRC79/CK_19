package org.usfirst.frc.team79.robot.commands.drivingstate;

import org.usfirst.frc.team79.robot.OI;
import org.usfirst.frc.team79.robot.commands.Drive;

public class TankState implements State {
	
	boolean buttonToggle = false;
	
	Drive driveMechanism;

	public TankState(Drive driveMechanism) {
		this.driveMechanism = driveMechanism;
	}
	
	@Override
	public void execute() {
		
		if(OI.toggle.get()) {
			buttonToggle = true;
		}
		
		if(buttonToggle && !OI.toggle.get()) {
			driveMechanism.setState(driveMechanism.getArcadeState());
			buttonToggle = false;
		} else {
			driveMechanism.tankDrive(driveMechanism.getAcceleration(OI.getLeft()), driveMechanism.getAcceleration(OI.getRight()));
		}
		
	}

}
