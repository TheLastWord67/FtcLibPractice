package org.firstinspires.ftc.teamcode.subsystems;

import com.acmerobotics.dashboard.config.Config;
import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.controller.PController;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

@Config
public class SlideSusbsytem extends SubsystemBase {

    DcMotor slide;

    GamepadEx gamepadEx;

    public SlideSusbsytem(HardwareMap hardware, GamepadEx gamepad2) {
        slide = hardware.dcMotor.get("slider");
        slide.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        gamepadEx = gamepad2;
    }

    public void run_to_high() {
        slide.setTargetPosition(-2827);
        slide.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        slide.setPower(0.7);
    }

    public void run_to_med() {
        slide.setTargetPosition(-2030);
        slide.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        slide.setPower(0.7);
    }

    public void lower() {
       slide.setTargetPosition(0);
        slide.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        slide.setPower(0.7);
    }


    public void manual() {
        if ((slide.getCurrentPosition() < -41 && gamepadEx.getRightY() > 0.1) || (slide.getCurrentPosition() > -2827 && gamepadEx.getRightY() < -0.1)) {
            slide.setPower(gamepadEx.getRightY()*0.6);
        } else {
            slide.setPower(0);
        }
    }

    public double getCurrentPosition() {
        return slide.getCurrentPosition();
    }

    public double getTarget() {
        return slide.getTargetPosition();
    }

    public void setPower(double power) {
        slide.setPower(power);
    }

}
