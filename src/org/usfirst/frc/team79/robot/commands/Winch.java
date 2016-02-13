package org.usfirst.frc.team79.robot.commands;

import org.usfirst.frc.team79.robot.commands.WinchState.State;
import org.usfirst.frc.team79.robot.commands.WinchState.waiting;
import org.usfirst.frc.team79.robot.commands.WinchState.Extend;
import org.usfirst.frc.team79.robot.commands.WinchState.Pulling;
import org.usfirst.frc.team79.robot.commands.WinchState.Resting;
import org.usfirst.frc.team79.robot.commands.WinchState.Rotate;


public class Winch extends CommandBase {
	//states
State ExtendState;
State PullingState;
State RestingState;
State RotateState;
State WaitingState;

State state;
    public Winch() { //construct states
		requires(WinchStart);
		WaitingState = new waiting(this);
		ExtendState = new Extend(this);
		PullingState = new Pulling(this);
		RestingState = new Resting(this);
		RotateState = new Rotate(this);
		state = RestingState;
		

    	    }

    protected void initialize() {
    }

    protected void execute() { // executes state
		state.execute();
    }
    public void setState(State state) { 
		this.state = state; 
    }
    protected boolean isFinished() { // when finished
        return false;
    }
	public State getExtedState() { //go to extend state
		return ExtendState;
	}
	
	public State getPullingState() { //go to pulling state
		return PullingState;
	}
	
	public State getRestingState() {//go to resting state
		return RestingState;
	}
	public State getWaitingState() {//go to waiting state
		return WaitingState;
	}
	
	public State getRotateState() {//go to rotate state
		return RotateState;
	}
	

    protected void end() {
    }


    protected void interrupted() {
    }
}
