package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvWebcam;

public class Webcam {

    public OpenCvWebcam cvWebcam;

    public void webcamOnly(HardwareMap hwMap, OpMode op) {
        try {
            int cameraMonitorViewId = hwMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hwMap.appContext.getPackageName());
            cvWebcam = OpenCvCameraFactory.getInstance().createWebcam(hwMap.get(WebcamName.class, "webcam"), cameraMonitorViewId);
            cvWebcam.setMillisecondsPermissionTimeout(2500);
        } catch (Exception e) {
            op.telemetry.addLine("WARNING: Camera init may have failed, OpModes that use it might crash (try physically restarting the robot)");
            op.telemetry.update();
        }
    }

}
