package org.firstinspires.ftc.teamcode.subsystems;

import com.acmerobotics.dashboard.config.Config;
import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.controller.PController;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

@Config
public class SlideSusbsytem extends SubsystemBase {

    MotorEx slide;

    PController p = new PController(0.05);

    public SlideSusbsytem(HardwareMap hardware) {
        slide = new MotorEx(hardware, "slider");
    }

    public void run_to_high() {
        p.setSetPoint(-2827);
    }

    public void lower() {
       p.setSetPoint(0);
    }


    public void update() {
        double out = p.calculate(slide.getCurrentPosition(), p.getSetPoint());
        slide.set(-out);
    }

}
