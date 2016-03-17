package org.usfirst.frc.team79.robot.utilities;

import edu.wpi.first.wpilibj.DigitalInput;

public class LimitSwitch extends DigitalInput {
	
	// swiped some code from last year
	// to make limit switches easier
	
	// the whole normally open normally closed thing
	// is really a pain though
	// no matter how you compensate for the value

	public LimitSwitch(int channel) {
		super(channel);
	}

	@Override
	public boolean get() {
		return super.get();
	}
}
