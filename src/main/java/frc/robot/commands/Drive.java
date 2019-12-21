package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;
import frc.robot.RobotMap;
import frc.robot.subsystems.Drivetrain;

public class Drive extends Command {

    public Drive() {
        requires(Drivetrain.getInstance());
    }

    private static double powerCurve(double x) {
        // old: https://www.desmos.com/calculator/g07ukjj7bl
        // old: double curve = (0.5D * (Math.atan(Math.PI * (Math.abs(x) - 0.5D)))) + 0.5D;
        double curve = Math.pow(Math.sin(Math.PI/2*Math.abs(x)),RobotMap.DRIVE.POWER_CURVE_EXPONENT) * Math.signum(x);
        return Math.copySign(curve, x);
    }

    @Override
    protected void initialize() {}

    @Override
    protected void execute() {
        double leftRaw = OI.getInstance().getLeftY();
        double rightRaw = OI.getInstance().getRightY();
        Drivetrain.getInstance().tankDrive(-leftRaw, -rightRaw);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
