package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.Drive;

public class Drivetrain extends Subsystem {

    private static Drivetrain INSTANCE = new Drivetrain();

    private Spark leftController;
    private Spark rightController;

    private Drivetrain() {
        super("Drivetrain");
        this.leftController = new Spark(RobotMap.DRIVETRAIN.LEFT_CONTROLLER_CHANNEL);
        this.rightController = new Spark(RobotMap.DRIVETRAIN.RIGHT_CONTROLLER_CHANNEL);
    }

    /**
     * Tank drive.
     *
     * @param leftSpeed  Speed of left side.
     * @param rightSpeed Speed of right side.
     */
    public void tankDrive(double leftSpeed, double rightSpeed) {
        this.leftController.set(leftSpeed);
        this.rightController.set(-rightSpeed);
    }

    public void stop() {
        this.tankDrive(0, 0);
    }

    @Override
    public void periodic() {}

    public static Drivetrain getInstance() {
        return INSTANCE;
    }

    @Override
    public void initDefaultCommand() {
        setDefaultCommand(new Drive());
    }
}
