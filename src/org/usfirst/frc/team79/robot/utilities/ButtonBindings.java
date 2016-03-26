package org.usfirst.frc.team79.robot.utilities;

import java.util.Collection;
import java.util.HashMap;

import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class ButtonBindings {
	
	// WARNING
	
	// okay
	// first off
	// why are you even in this class
	// go away, shoo
	
	// WARNING

	// okay, here we declare a button toggle
	// a state called state
	// and a joystick button
	private boolean toggle;
	private State state;
	private JoystickButton button;
	
	// here is a hashmap with its key being a state
	// and its value pair being a ButtonBindings object
	// which is actually an object that is this class
	// so our value pair is actually one of these ButtonBindings objects
	// Klein bottle *I recommend googling that*
	private static final HashMap<State, ButtonBindings> buttonInfos = new HashMap<>();
	
	// here is the bind method, which takes a state and a button
	// and binds it to the hashmap we declared
	// called buttonInfos
	public static final void bind(State state, JoystickButton button) {
		ButtonBindings buttonInfo = new ButtonBindings(state, button);
		buttonInfos.put(state, buttonInfo);
	}
	
	// here is a getter for returning a ButtonBindings object's state
	public static final ButtonBindings get(State state) {
		return buttonInfos.get(state);
	}
	
	// aaaand magic
	// we return a collection of ButtonBindings that returns the value pair for buttonInfos
	public static final Collection<ButtonBindings> getCollection() {
		return buttonInfos.values();
	}
	
	// yes this is a private constructor
	// and yes it is the only constructor
	// writecha own damn object fool, this is a static bean meant to be called from other classes
	// so no
	// you can't make one
	// because I said so
	private ButtonBindings(State state, JoystickButton button) {
		this.state = state;
		this.button = button;
	}

	// an obtuse name for a method that returns the buttons toggle state
	public boolean isToggle() {
		return toggle;
	}

	// a not so obtuse method for actually setting the buttons state
	public void setToggle(boolean toggle) {
		this.toggle = toggle;
	}

	// and get state is easy to follow
	// it just returns the state, of this currently being referenced object
	public State getState() {
		return state;
	}

	// sets the state on this object
	public void setState(State state) {
		this.state = state;
	}

	// returns the joystick button of this object
	public JoystickButton getButton() {
		return button;
	}

	// sets the button for this particular object
	public void setButton(JoystickButton button) {
		this.button = button;
	}

}
