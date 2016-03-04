package org.usfirst.frc.team79.robot.utilities.io;

public class DataBean {
	
	private final double left;
	private final double right;
	
	public DataBean(double left, double right) {
		this.left = left;
		this.right = right;
	}
	
	public double getLeft() {
		return left;
	}
	
	public double getRight() {
		return right;
	}

}
