package org.usfirst.frc.team79.robot.commands.teleop.manipulatorstate;

import java.util.Collection;
import java.util.HashMap;

import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class ButtonBindings {

	private boolean toggle;
	private State state;
	private JoystickButton button;
	
	private static final HashMap<State, ButtonBindings> buttonInfos = new HashMap<>();
	
	public static final void bind(State state, JoystickButton button) {
		ButtonBindings buttonInfo = new ButtonBindings(state, button);
		buttonInfos.put(state, buttonInfo);
	}
	
	public static final ButtonBindings get(State state) {
		return buttonInfos.get(state);
	}
	
	public static final Collection<ButtonBindings> getCollection() {
		return buttonInfos.values();
	}
	
	private ButtonBindings(State state, JoystickButton button) {
		this.state = state;
		this.button = button;
	}

	public boolean isToggle() {
		return toggle;
	}

	public void setToggle(boolean toggle) {
		this.toggle = toggle;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public JoystickButton getButton() {
		return button;
	}

	public void setButton(JoystickButton button) {
		this.button = button;
	}

}
