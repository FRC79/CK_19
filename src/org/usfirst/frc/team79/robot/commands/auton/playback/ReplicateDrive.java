package org.usfirst.frc.team79.robot.commands.auton.playback;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

import org.usfirst.frc.team79.robot.commands.CommandBase;
import org.usfirst.frc.team79.robot.utilities.io.DataBean;
import org.usfirst.frc.team79.robot.utilities.io.ThreadKillable;
import org.usfirst.frc.team79.robot.utilities.io.read.DataRetriever;

public class ReplicateDrive extends CommandBase implements ThreadKillable {
	
	BlockingQueue<DataBean> dataQueue;
	
	DataRetriever retriever;
	
	private static AtomicBoolean doneStatus = new AtomicBoolean();
	
	private boolean isFinished = false;
	
	private long referenceTime;

	public ReplicateDrive() {
		
		requires(drivetrain);
		
		dataQueue = new LinkedBlockingQueue<DataBean>();
		retriever = new DataRetriever(dataQueue, this);
		
		new Thread(retriever).start();
		
	}

	@Override
	protected void execute() {
		
		if(!isDone() || !dataQueue.isEmpty()) {
			long currentTime = System.currentTimeMillis();
			if(currentTime >= referenceTime + 100 || currentTime < referenceTime) {
				referenceTime = currentTime;
				if(!dataQueue.isEmpty()) {
					try {
						DataBean data = dataQueue.take();
						drivetrain.moveArcade(data.getLeft(), data.getRight());
					} catch (InterruptedException e) {
						// shouldn't ever happen
						// we make the sanity checks before getting here
					}
				}
			}
		} else {
			isFinished = true;
		}
		
	}

	@Override
	protected boolean isFinished() {
		return isFinished;
	}

	@Override
	protected void end() {
		drivetrain.moveTank(0, 0);
	}

	@Override
	protected void interrupted() {
		// if autonamous mode has ended before these threads have completed
		// we flip this boolean
		// ugly, but if this command dies, there's no point in continuing
		// and these threads will live forever in memory
		// or crash as they try and call isDone;
		// luckily, I'm pretty sure these threads update quicker than the 20ms delay
		// that the wpilib Scheduler gives before each command's update
		setDone();
	}

	@Override
	public void setDone() {
		doneStatus.set(true);
	}

	@Override
	public boolean isDone() {
		return doneStatus.get();
	}
	
	@Override
	protected void initialize() {
		
	}

}
