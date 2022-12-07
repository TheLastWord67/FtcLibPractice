package org.firstinspires.ftc.teamcode.subsystems;

import com.acmerobotics.dashboard.config.Config;
import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.controller.PController;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

@Config
public class SlideSusbsytem extends SubsystemBase {

    MotorEx slide;

    PController p = new PController(0.05);

    GamepadEx gamepadEx;

    public SlideSusbsytem(HardwareMap hardware, GamepadEx gamepad2) {
        slide = new MotorEx(hardware, "slider");
        gamepadEx = gamepad2;
    }

    public void run_to_high() {
        p.setSetPoint(-2827);
    }

    public void lower() {
       p.setSetPoint(0);
    }


    public void updatePID() {
        double out = p.calculate(slide.getCurrentPosition(), p.getSetPoint());
        slide.set(-out);
    }

    public void manual() {
        if ((slide.getCurrentPosition() < -41 && gamepadEx.getRightY() > 0.1) || (slide.getCurrentPosition() > -2827 && gamepadEx.getRightY() < -0.1)) {
            slide.set(gamepadEx.getRightY()*0.6);
        } else {
            slide.set(0);
        }
    }

}
