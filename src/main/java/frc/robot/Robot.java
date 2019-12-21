package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.subsystems.*;
import frc.robot.commands.*;

public class Robot extends TimedRobot {
  	@Override
  	public void robotInit() {
		OI.getInstance();
		Drivetrain.getInstance();
  	}

  	@Override
  	public void robotPeriodic() {
	}
	
  	@Override
  	public void autonomousInit() {}
	
  	@Override
  	public void autonomousPeriodic() {}
	
  	@Override
  	public void teleopPeriodic() { Scheduler.getInstance().run(); }
	  
  	@Override
  	public void testPeriodic() {}
}
