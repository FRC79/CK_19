package org.usfirst.frc.team79.robot.commands.teleop.logging;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

import org.usfirst.frc.team79.robot.OI;
import org.usfirst.frc.team79.robot.commands.CommandBase;
import org.usfirst.frc.team79.robot.utilities.io.DataBean;
import org.usfirst.frc.team79.robot.utilities.io.ThreadKillable;
import org.usfirst.frc.team79.robot.utilities.io.write.DataWriter;

public class RecordDrivetrain extends CommandBase implements ThreadKillable {
	
	private boolean startedLogging = false;
	private boolean endedLogging = false;
	
	private boolean buttonToggle = false;
	
	private long referenceTime;
	
	private AtomicBoolean doneStatus = new AtomicBoolean();
	
	// dataQueue acts as a threadSafe membrane between the main application and the writer thread
	BlockingQueue<DataBean> dataQueue; 
	
	DataWriter consumer;

	public RecordDrivetrain() {
		
		requires(drivetrain);
		
		dataQueue = new LinkedBlockingQueue<DataBean>();
		consumer = new DataWriter(dataQueue, this);
		
		referenceTime = System.currentTimeMillis();

	}

	@Override
	protected void execute() {
		
		long currentTime = System.currentTimeMillis();
		
		if(!startedLogging) {
			listenBegin();
		} else if(!endedLogging){
			listenEnd();
		} else {
			// do absolutely nothing
		}
		
		if(startedLogging && !endedLogging) {
			double trainLeft = drivetrain.getLeftSet();
			double trainRight = drivetrain.getRightSet();
			if(currentTime >= referenceTime + 100 || currentTime < referenceTime) {
				dataQueue.add(new DataBean(trainLeft, trainRight));
				referenceTime = currentTime;
			}
		}
		
		drivetrain.moveArcade(OI.getY(), OI.getX());

	}
	
	private void listenBegin() {
		if(OI.loggingToggle.get() && !buttonToggle) {
			buttonToggle = true;
		} else if(!OI.loggingToggle.get() && buttonToggle) {
			buttonToggle = false;
			startedLogging = true;
			new Thread(consumer).start();
		}
	}
	
	private void listenEnd() {
		if(OI.loggingToggle.get() && !buttonToggle) {
			buttonToggle = true;
		} else if(!OI.loggingToggle.get() && buttonToggle) {
			buttonToggle = false;
			endedLogging = true;
			setDone();
		}
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

	@Override
	protected void initialize() {

	}
	
	@Override
	public void setDone() {
		doneStatus.set(true);
	}

	@Override
	public boolean isDone() {
		return doneStatus.get();
	}

}
