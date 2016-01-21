package org.usfirst.frc.team79.robot.subsystems;
import org.usfirst.frc.team79.robot.RobotMap;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain extends Subsystem {
 
 RobotDrive drivefmotors;
 RobotDrive drivemmotors;
 RobotDrive drivebmotors;
 public static boolean isArcDrive;
 public static Command setArcTrue; 
 public DriveTrain() {
  drivefmotors = new RobotDrive(RobotMap.MOTORRFRONT,RobotMap.MOTORLFRONT);// ITS THE FRONT!!!
  drivemmotors = new RobotDrive(RobotMap.MOTORRMIDDLE,RobotMap.MOTORLMIDDLE);//ITS THE MIDDLE!!!
  drivebmotors = new RobotDrive(RobotMap.MOTORRBACK,RobotMap.MOTORLBACK);//ITS THE BACK!!!!!
 }//you cannot stop these amazing commenting skillz
	

 public void moveTD(double left, double right) {

  drivefmotors.tankDrive(left, right);//YAY 3 DRIVES!!!
  drivemmotors.tankDrive(left, right);
  drivebmotors.tankDrive(left, right);
 }//TAKE THIS BRACKET U CODE!!! HAAAHAHAHAHAHAHA
 
	 public void moveAD(double power,double rotate) {
			  drivefmotors.arcadeDrive(power, rotate);
			  drivemmotors.arcadeDrive(power, rotate);
			  drivebmotors.arcadeDrive(power, rotate);
	 }
			  //i am an mlc pro
 public void stop() {
  moveTD(0,0);
  moveAD(0,0);
 }//Pro major league commenter
 @Override
 protected void initDefaultCommand() {
 }
}

}
