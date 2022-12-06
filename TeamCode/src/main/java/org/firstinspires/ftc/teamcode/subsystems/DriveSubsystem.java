package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.drivebase.MecanumDrive;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.hardware.RevIMU;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.teamcode.roadrunner.util.AxisDirection;
import org.firstinspires.ftc.teamcode.roadrunner.util.BNO055IMUUtil;

public class DriveSubsystem extends SubsystemBase {

    MotorEx fL;
    MotorEx fR;
    MotorEx bL;
    MotorEx bR;

    BNO055IMU imu;

    MecanumDrive m_drive;

    GamepadEx controller;

    public DriveSubsystem (HardwareMap hardware) {
        fL = new MotorEx(hardware, "front_left");
        fR = new MotorEx(hardware, "front_right");
        bL = new MotorEx(hardware, "back_left");
        bR = new MotorEx(hardware, "back_right");

        fL.setInverted(true);
        bL.setInverted(true);

        imu = hardware.get(BNO055IMU.class, "imu");
        BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();
        parameters.angleUnit = BNO055IMU.AngleUnit.RADIANS;
        imu.initialize(parameters);
        BNO055IMUUtil.remapZAxis(imu, AxisDirection.NEG_Y);

        m_drive = new MecanumDrive(fL, fR, bL, bR);
    }

    public void driveFC(GamepadEx gamepad1) {
        controller = gamepad1;
        m_drive.driveFieldCentric(controller.getLeftX(),
                controller.getRightY(),
                controller.getRightX(),
                -imu.getAngularOrientation().firstAngle);
    }

    public void driveRC(GamepadEx gamepad1) {
        controller = gamepad1;
        m_drive.driveRobotCentric(controller.getLeftX(),
                controller.getRightY(),
                controller.getRightX());
    }

}
