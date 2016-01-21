import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {
 SendableChooser arcadetrue;
  SendableChooser arcadefalse;
  SendableChooser auntonselector;
  
    Command enabled;
    Command disabled;

    CameraServer server;
    
    public void robotInit() {
     RobotMap.init();
     
        OI.init();
        CommandBase.init();  
        
        auntonselector = new SendableChooser();
        auntonselector.addObject("aunton", new autontime() );
        SmartDashboard.putData("aunton!", auntonselector);

        server = CameraServer.getInstance();
        server.setQuality(50);
        server.startAutomaticCapture("cam0");
    }
    
 
 public void disabledPeriodic() {
  Scheduler.getInstance().run();
 }

    public void autonomousInit() {
    	
    }

    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        
    }

    public void teleopInit() {
     new TeleopDrive().start();
    }

    public void disabledInit(){

    }

    public void teleopPeriodic() {
    	
     Scheduler.getInstance().run();
     
    }

    public void testPeriodic() {
    }
}
    public void autonomousPeriodic() {
    	
    }
    
    public void disabledInit(){

    }
    
    public void testPeriodic() {
    	
    }
	
	public void disabledPeriodic() {
		
	}
	
}
