package org.usfirst.frc.team79.robot.subsystems;
import org.usfirst.frc.team79.robot.CommandBase;

public class MoveForTime extends CommandBase {
 
 double duration = 0.0;
 double left = 0.0;
 double right = 0.0;
 double power = 0.0;
 double rotate = 0.0;
 
 public MoveForTime (double left, double right, double duration) {
  requires (drive);
  
  this.left = left;
  this.right = right;
  this.duration = duration;
 }
 @Override
 protected void initialize() {
  setTimeout(duration);  
 }

 @Override
 protected void execute() {
  drive.moveTD(left, right);  
 }

 @Override
 protected boolean isFinished() {
  // TODO Auto-generated method stub
  return isTimedOut();
 }

 @Override
 protected void end() {
  // TODO Auto-generated method stub
  drive.stop();
  
 }

 @Override
 protected void interrupted() {
  // TODO Auto-generated method stub
  
 }

}
