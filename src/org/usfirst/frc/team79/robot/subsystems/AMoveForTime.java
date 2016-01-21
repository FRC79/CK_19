protected void initialize() {
		// TODO Auto-generated method stub
		  setTimeout(duration);  

	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		  drive.moveAD(power, rotate);

	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
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

