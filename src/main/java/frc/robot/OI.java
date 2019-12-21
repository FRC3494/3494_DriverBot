package frc.robot;

import edu.wpi.first.wpilibj.Joystick;

public class OI {

    private static OI INSTANCE = new OI();
    
    private Joystick leftFlight;
    private Joystick rightFlight;

    private OI() {
        rightFlight = new Joystick(RobotMap.OI.RIGHT_JOY);
        leftFlight = new Joystick(RobotMap.OI.LEFT_JOY);
    }

    public double getLeftY() {
        return leftFlight.getY();
    }

    public double getRightY() {
        return rightFlight.getY();
    }

    public static OI getInstance() {
        return INSTANCE;
    }
}