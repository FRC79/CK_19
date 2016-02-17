package org.usfirst.frc.team79.robot.commands.teleop;

import org.usfirst.frc.team79.robot.OI;
import org.usfirst.frc.team79.robot.commands.CommandBase;
import org.usfirst.frc.team79.robot.commands.teleop.manipulatorstate.ButtonBindings;
import org.usfirst.frc.team79.robot.commands.teleop.manipulatorstate.Firing;
import org.usfirst.frc.team79.robot.commands.teleop.manipulatorstate.Intaking;
import org.usfirst.frc.team79.robot.commands.teleop.manipulatorstate.PlowDown;
import org.usfirst.frc.team79.robot.commands.teleop.manipulatorstate.PlowUp;
import org.usfirst.frc.team79.robot.commands.teleop.manipulatorstate.State;

import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class Manipulate extends CommandBase {
	
//	public State intakingState;
//	public State firingState;
//	public State plowDownState;
//	public State plowUpState;
//	
	volatile State state;
//	
	public boolean fired = false;
	
//	private HashMap<State, JoystickButton> map = new HashMap<>();
	
	public Manipulate() {
		
		requires(fire);
		requires(intake);
		
		State intakingState = new Intaking(fire, intake);
		State firingState = new Firing(fire, intake);
		State plowDownState = new PlowDown(fire, intake);
		State plowUpState = new PlowUp(fire, intake);
	
		state = intakingState;
		
		ButtonBindings.bind(firingState, OI.firing);
		ButtonBindings.bind(intakingState, OI.intaking);
		ButtonBindings.bind(plowDownState, OI.plowDown);
		ButtonBindings.bind(plowUpState, OI.plowUp);
		
	}

	@Override
	protected void initialize() {

	}

	@Override
	protected void execute() {
		
		for(ButtonBindings bindings : ButtonBindings.getCollection()) {
			JoystickButton button = bindings.getButton();
			if(button.get()) {
				bindings.setToggle(true);
			} else if(bindings.isToggle() && !button.get()) {
				bindings.setToggle(false);
				setState(bindings.getState());
			}
		}
	
		state.execute();
		
	}
	
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
