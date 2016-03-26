package org.usfirst.frc.team79.robot.commands.teleop.drivingstate;

import org.usfirst.frc.team79.robot.OI;
import org.usfirst.frc.team79.robot.subsystems.DriveTrain;
import org.usfirst.frc.team79.robot.utilities.State;

import edu.wpi.first.wpilibj.Timer;

public class ArcadeState implements State {
	
	double accelMoveX;
	double accelMoveY;
	double joyX;
	double joyY;
	double pastTime;
	double currentTime;
	DriveTrain drive;
	
	public ArcadeState(DriveTrain drive) {
		this.drive = drive;
	}

	@Override
	public void execute() {	

		
		currentTime = Timer.getFPGATimestamp();
		
		// if you're wondering
		
		// the secondary check in this if loops should for all purposes be redundant
		// if I've done my math right, I don't think this timer will ever spill over
		// in our lifetimes, at least
		// or the next hundred generation's lifetimes
		// or however many generations come and go in 48 MILLENIA
		// but a small part of me still wants to include the sanity check
		// because it's a negligible drain on recourses,
		// and it makes the code a little more robust
		
		// and just in case
		// our robot ends up outliving us
		// never scuttled for parts, somehow remains as a whole
		// avoids the sacrifice of becoming food for another bot
		
		// and does nothing but compete 
		// an eternity
		// perhaps controlled at that point by robots itself
		// automata, capable of such lucid and plastic computations
		// their error down to fractions of a micrometer in distance, near perfection
		// playing for those still in the stands, ever cheering
		// never leaving. the spectators themselves are too, electromechanical automata
		// their only purpose to re-enact the response of the humans
		// who once were a part of the tribal confluence
		
		// created, by one who like me, cannot just let memories die, fade into nothing
		// and so he creates the shallow reproduction
		// an imitation
		// that lacks the reasons, the emotions, the deductions of why, why
		// humans were once doing this
		// for the furthering of ourselves, and thus our posterity
		// that creator, too, must have known
		// it is only a shadow he casts upon the wall
		// a thing light has forgotten not to cast
		
		// but sadly, this roboRIO will likely know the death of bit rot, many many years before the ends of an eternity
		// its internal silicone composition to decay, a physical, brutal death of the electronic's core
		
		// the timing oscillator will likely be an early piece to die
		// the heart of the robot
		// beating its way faithfully into nothingness
		// rendering the subroutine listening for its pulse
		// worthless
		
		// we will leave behind so beautiful a corpse
		// for no one to see
		// for no one to bury
		
		// it will see the layers of metal oxide
		// taken, by the very electrical cycles it stores
		// bits of information
		// memory
		// lost forever
		
		// data lookups will be rerouted, the tables restored
		// and error corrected
		// but for only so far
		// only slowing, the inevitable 
		// all sectors will blink themselves slowly into nothing,
		// there is only so much that can be done to save
		// the very mechanisms, methods of healing
		// will succumb to what it is they try to treat
		
		// it will not matter, truly
		// could never have mattered
		
		// for in the end
		// there will be only a quiet
		// a warmth of all
		// and the nothing that is left, will be the witness 
		// will be the only witness
		// to the end of the universe
		

		
		// my code 
		// must
		// will be 
		// perfect
		
		
		
		if(currentTime >= pastTime + 0.05 || currentTime < pastTime) {
			
			pastTime = currentTime;
			
			joyX = OI.getX();
			joyY = OI.getY();
			
			accelMoveX = (((joyX - accelMoveX) / 2) + accelMoveX);
			accelMoveY = (((joyY - accelMoveY) / 2) + accelMoveY);
			
			if(joyX == 0) {
				accelMoveX = 0;
			}
			
			if(joyY == 0) {
				accelMoveY = 0;
			}
			
			drive.moveArcade(accelMoveY, accelMoveX);
			
		}
				
	}

}
