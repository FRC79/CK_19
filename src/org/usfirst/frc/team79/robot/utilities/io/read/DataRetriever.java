package org.usfirst.frc.team79.robot.utilities.io.read;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;

import org.usfirst.frc.team79.robot.utilities.io.DataBean;
import org.usfirst.frc.team79.robot.utilities.io.ThreadKillable;

public class DataRetriever implements Runnable {
	
	private final static String FILEPATH = "/home/lvuser/data.txt";
	private final String DELIMINATER = ",";
	private byte errorCycles;
	
	BlockingQueue<DataBean> dataQueue;
	
	ThreadKillable threadInvoker;
	
	BufferedReader dataReader;
	
	public DataRetriever(BlockingQueue<DataBean> dataQueue, ThreadKillable threadInvoker) {
		this.dataQueue = dataQueue;
		this.threadInvoker = threadInvoker;
	}

	@Override
	public void run() {
		
		initReader();
		parseData();
		closeReader();
		threadInvoker.setDone();
		
	}
	
	private void parseData() {
		try {
			while(dataReader.ready()) {
				if(dataQueue.isEmpty()) {
					String[] data = dataReader.readLine().split(DELIMINATER);
					dataQueue.add(new DataBean(Double.parseDouble(data[0]), Double.parseDouble(data[1])));
				}
			}
		} catch (IOException e) {
			
		}
	}
	
	private void initReader() {
		try {
			dataReader = new BufferedReader(new FileReader(FILEPATH));
		} catch (FileNotFoundException e) {
			if(errorCycles < 10) {
				errorCycles ++;
				initReader();
			} else {
				throw new ThreadDeath();
			}
			// we're probably S.O.L in this area if this fails
			// so we'll end this thread if it does *
			// * not sure what this does once it reaches the jvm thread handler
			// the robot 'cannot' die during competition
		}
	}
	
	private void closeReader() {
		
		if(dataReader != null) {
			try {
				dataReader.close();
			} catch (IOException e) {
				// shouldn't happen
			}
		}
	}

}
