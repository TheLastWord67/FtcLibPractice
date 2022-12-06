package org.firstinspires.ftc.teamcode.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class IntakeSubsytem extends SubsystemBase {

    public CRServo servo1;
    public CRServo servo2;

    public IntakeSubsytem (HardwareMap hardware) {
        servo1 = hardware.crservo.get("servo1");
        servo2 = hardware.crservo.get("servo2");

        servo1.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    public void intake() {
        servo1.setPower(1);
        servo2.setPower(1);
    }

    public void out() {
        servo1.setPower(-0.5);
        servo2.setPower(-0.5);
    }

    public void nuetral() {
        servo1.setPower(0);
        servo2.setPower(0);
    }
}
