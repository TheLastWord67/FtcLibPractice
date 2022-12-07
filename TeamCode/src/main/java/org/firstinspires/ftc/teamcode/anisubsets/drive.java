package org.firstinspires.ftc.teamcode.anisubsets;
import com.arcrobotics.ftclib.drivebase.MecanumDrive;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

    // taken from ftc library thing adam sent ->> used to code mecanum but need to import meanings
   /* MecanumDrive mecanum = new MecanumDrive(frontLeft, frontRight,
            backLeft, backRight);  */
@TeleOp
public class drive extends OpMode {

    MotorEx fL, fR, bL, bR;
    private MecanumDrive drive;
    private GamepadEx driverOp;

    @Override
    public void init() {
        /* instantiate motors */
        fL = new MotorEx(hardwareMap, "front_left");
        fR = new MotorEx(hardwareMap, "front_right");
        bL = new MotorEx(hardwareMap, "back_left");
        bR = new MotorEx(hardwareMap, "back_right");
        drive = new MecanumDrive(fL, fR, bL, bR);
        driverOp = new GamepadEx(gamepad1);
    }

    @Override
    public void loop() {
        drive.driveRobotCentric(
                driverOp.getLeftX(),
                driverOp.getLeftY(),
                driverOp.getRightY()
        );
    }

}