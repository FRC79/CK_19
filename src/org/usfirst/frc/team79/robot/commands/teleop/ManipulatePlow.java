package org.usfirst.frc.team79.robot.commands.teleop;

import org.usfirst.frc.team79.robot.OI;
import org.usfirst.frc.team79.robot.commands.CommandBase;
import org.usfirst.frc.team79.robot.commands.teleop.manipulatorstate.Firing;
import org.usfirst.frc.team79.robot.commands.teleop.manipulatorstate.Intaking;
import org.usfirst.frc.team79.robot.commands.teleop.manipulatorstate.PlowDown;
import org.usfirst.frc.team79.robot.commands.teleop.manipulatorstate.PlowUp;
import org.usfirst.frc.team79.robot.utilities.ButtonBindings;
import org.usfirst.frc.team79.robot.utilities.State;

import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class ManipulatePlow extends CommandBase {
	
	// here we're declaring a default state called state
	// this is the state we're going to call execute on
	// for every execution tick of this command
	volatile State state;
	
	// I hate that this machine still needs a boolean called from outside of it's respective state
	// but if I touch anything to try and "fix" this quasi dirty bit
	// Sunni's going to kill me	
	
	// We construct a manipulate object
	public ManipulatePlow() {
		
		// we say that these subsystems are needed
		requires(cannon);
		requires(plow);
		
		// here we declare our different states
		// and since we used an interface to do so
		// instead of making a new Fire() or Intake()
		// we make it a state
		// so that we can always call execute on it
		// polymorphism, n00bs
		State intakingState = new Intaking(cannon, plow);
		State firingState = new Firing(cannon, plow);
		State plowDownState = new PlowDown(cannon, plow);
		State plowUpState = new PlowUp(cannon, plow);
	
		// we set the default state to the calibration state
		// so that when teleop creates this object as part of a command group
		// it calibrates the arm
		state = plowUpState;
		
		// okay, here is where some magic happens
		// I'm binding different buttons to the different states we have here
		// writing them into a bean
		// that is more of a factory than anything in its pattern
		// and for all purposes you need to know, is voodoo magic that binds buttons to different states
		// if you'd like to see how it works
		// check my comments inside of the buttonbindings class in the util package
		ButtonBindings.bind(firingState, OI.firing);
		ButtonBindings.bind(intakingState, OI.intaking);
		
		ButtonBindings.bind(plowUpState, OI.manualPlowUp);
		ButtonBindings.bind(plowDownState, OI.manualPlowDown);
		
//		ButtonBindings.bind(plowUpState, OI.overrideBothUp);
//		ButtonBindings.bind(plowDownState, OI.overrideBothDown);
		
	}

	// we don't ever use this really anywhere
	@Override
	protected void initialize() {

	}
	
	// and we now call the commands native execute method
	@Override
	protected void execute() {
		
		// again, here's a little bit of java voodoo magic
		// for each of the bindings in ButtonBindings bindings
		// we call getCollection
		// which returns the value pair for each of the bindings
		// that are in the bean's hashmap
		for(ButtonBindings bindings : ButtonBindings.getCollection()) {
			// and than we say that the current button we're polling
			// is this current bindings.getButton()
			// which is the button we've paired with the command
			JoystickButton button = bindings.getButton();
			// if that button is pressed
			if(button.get()) {
				// we set the bindings toggle to true
				bindings.setToggle(true);
			// if the button has been let go, and the toggle is true
			} else if(bindings.isToggle() && !button.get()) {
				// set this bindings button toggle to false
				bindings.setToggle(false);
				// and set it to the state paired to that button
				setState(bindings.getState());
			}
		}

		state.execute();
		
	}
	
	// long handed explicit method for setting the current state
	public void setState(State state) {
		this.state = state;
	}
	
	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {

	}

	@Override
	protected void interrupted() {

	}

}
