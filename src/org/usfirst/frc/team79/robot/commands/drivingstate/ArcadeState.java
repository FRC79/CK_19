package org.usfirst.frc.team79.robot.commands.drivingstate;

import org.usfirst.frc.team79.robot.OI;
import org.usfirst.frc.team79.robot.commands.Drive;

public class ArcadeState implements State {
	
	boolean buttonToggle = false;
	
	Drive driveMechanism;
	
	public ArcadeState(Drive driveMechanism) {
		this.driveMechanism = driveMechanism;
	}

	@Override
	public void execute() {

		if(OI.toggle.get()) {
			buttonToggle = true;
		}
		
		if(buttonToggle && !OI.toggle.get()) {
			driveMechanism.setState(driveMechanism.getTankState());
			buttonToggle = false;
		} else {
			driveMechanism.getAcceleration(OI.getY());
			driveMechanism.arcadeDrive(driveMechanism.getAcceleration(OI.getY()), driveMechanism.getAcceleration(OI.getX()));
		}
		
	}

}
