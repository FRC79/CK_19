package org.usfirst.frc.team79.robot.utilities;

public class PIDController {

	/*working variables*/
	long lastTime;
	double output, setPoint;
	double errSum, lastErr;
	double kp, ki, kd;
		
	/*
	 * @param setPoint is the setpoint for this pid controller
	 */
	public PIDController(double setPoint) {
		this.setPoint = setPoint;
	}
	
	/*
	 * @param setPoint is the setpoint for this pid controller
	 * @param kp the proportional factor
	 * @param ki the integral factor
	 * @param kd the derivitave factor
	 */
	public PIDController(double setPoint, double kp, double ki, double kd) {
		this(setPoint);
		this.kp = kp;
		this.ki = ki;
		this.kd = kd;
	}
	
	public double calculateOutput(double input) {
		
	   /*How long since we last calculated*/
	   long currentTime = System.currentTimeMillis();
	   double timeChange = (currentTime - lastTime);
	   
	   timeChange = (timeChange < 0) ? 0 : timeChange;
	  
	   /*Compute all the working error variables*/
	   double error = setPoint - input;
	   errSum += (error * timeChange);
	   double dErr = (error - lastErr) / timeChange;
	   
	   error = (error > 1.0) ? 1.0 : error;
	   error = (error < -1.0) ? -1.0 : error;
	   
	   errSum = (errSum > 1.0) ? 1.0 : errSum;
	   errSum = (errSum < -1.0) ? -1.0 : errSum;
	   
	   dErr = (dErr > 1.0) ? 1.0 : dErr;
	   dErr = (dErr < -1.0) ? -1.0 : dErr;
	  
	   /*Compute PID Output*/
	   output = (kp * error) + (ki * errSum) + (kd * dErr);
	   
	   output = (output > 1.0) ? 1.0 : output;
	   output = (output < -1.0) ? -1.0 : output;
	   
	   /*Remember some variables for next time*/
	   lastErr = error;
	   lastTime = currentTime;
	   
	   return output;
	   
	}
	  
	public void SetTunings(double Kp, double Ki, double Kd) {
	   kp = Kp;
	   ki = Ki;
	   kd = Kd;
	}
	
	void setSetPoint(double setPoint) {
		this.setPoint = setPoint;
	}
	
}
