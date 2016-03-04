package org.usfirst.frc.team79.robot.utilities.io.write;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.concurrent.BlockingQueue;

import org.usfirst.frc.team79.robot.utilities.io.DataBean;
import org.usfirst.frc.team79.robot.utilities.io.ThreadKillable;

public class DataWriter implements Runnable {
	
	BlockingQueue<DataBean> dataQueue;
	
	FileWriter dataWriter;
	
	ThreadKillable threadInvoker;
	
	private final String FILEPATH = "/home/lvuser/data.txt";
	
	public DataWriter(BlockingQueue<DataBean> dataQueue, ThreadKillable invoker) {
		this.dataQueue = dataQueue;
		this.threadInvoker = invoker;
	}

	@Override
	public void run() {
		
	//initialize the data writer
	initWriter(false);
	
	// run this thread forever
	while(true) {
		
		// if this threads invoker gets flushed, than we break
		if(threadInvoker != null) {
			// if the thread is done, we wait for the queue to empty, because we still want this data
			if(!threadInvoker.isDone() || !dataQueue.isEmpty()) {
				logData();
			} else {
				// if the killable returns isDone == true, and the queue is empty, than we break
				break;
			}
			
		} else {
			// called if the threadInvoker has been flushed from the scheduler
			break;
		}
		
	}

	// lastly, we close the data writer
	closeWriter();
	
	}
	
	private void logData() {
		
		if(!dataQueue.isEmpty()) {
			
			try {
				
				DataBean data = dataQueue.take();
				StringBuilder dataBuilder = new StringBuilder(45);
				
				dataBuilder.append(formatDouble(data.getLeft()));
				dataBuilder.append(",");
				dataBuilder.append(formatDouble(data.getRight()));
				dataBuilder.append("\n");
				
				dataWriter.write(dataBuilder.toString());
				
			} catch(InterruptedException e) {
				// interrupted exception occurs when we can't pull anything from the queue
				// we check if the queue is even empty before logging the data			
			} catch (IOException e) {
				// we've lost the filewriter for some reason
				// try and establish a connection
				// we're probably S.O.L if this ends up happening though
				initWriter(true);
			}
			
		}
		
	}
	
	private void initWriter(boolean append) {	
		
		File dataLog = new File(FILEPATH);
		
		try {
			if(!dataLog.exists()) {
				dataLog.createNewFile();
			}
			dataWriter = new FileWriter(dataLog.getAbsoluteFile(), append);
		} catch(IOException e) {
			return;
		}
		
	}
	
	private void closeWriter() {	
		
		if(dataWriter != null) {
			try {
				dataWriter.close();
			} catch(IOException e) {
				// ignore
				// we perform a null check before closing
			}
		}
		
	}

	private static String formatDouble(double value) {
        return new BigDecimal(value).setScale(10, RoundingMode.DOWN).toPlainString();
    }

}
