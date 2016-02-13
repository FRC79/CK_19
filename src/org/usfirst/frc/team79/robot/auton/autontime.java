package org.usfirst.frc.team79.robot.auton;

import org.usfirst.frc.team79.robot.subsystems.MoveForTime;
import edu.wpi.first.wpilibj.command.CommandGroup;
public class autontime extends CommandGroup {
    public autontime () {
     addSequential(new MoveForTime(.75,.75,5));//forward 5 second 
     addSequential(new MoveForTime(0,0,1));//stop 1 second
     addSequential(new MoveForTime(.75,-.75,1));//right 1 second
     addSequential(new MoveForTime(0,0,1));//stop 1 second
     addSequential(new MoveForTime(.75,.75,1));//forward 1 second
     addSequential(new MoveForTime(0,0,1));//stop 1 second
     addSequential(new MoveForTime(-.75,-.75,1));//back 1 second
     addSequential(new MoveForTime(0,0,1));//stop 1 second
     addSequential(new MoveForTime(-.75,.75,1));//left 1 second
     addSequential(new MoveForTime(-.6,-.6,7));//back 5 second
    }
}
