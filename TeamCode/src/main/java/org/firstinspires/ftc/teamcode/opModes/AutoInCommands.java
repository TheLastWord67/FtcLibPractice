package org.firstinspires.ftc.teamcode.opModes;

import com.arcrobotics.ftclib.command.CommandScheduler;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.commandGroups.OuttakeCommand;
import org.firstinspires.ftc.teamcode.commandGroups.roadrunnerCommands.FirstBranch;
import org.firstinspires.ftc.teamcode.commandGroups.roadrunnerCommands.ParkCommand;
import org.firstinspires.ftc.teamcode.commandGroups.roadrunnerCommands.SecondBranch;
import org.firstinspires.ftc.teamcode.commandGroups.roadrunnerCommands.TrajToDumpCommand;
import org.firstinspires.ftc.teamcode.subsystems.AprilTagDetectionPipeline;
import org.firstinspires.ftc.teamcode.subsystems.IntakeSubsytem;
import org.firstinspires.ftc.teamcode.subsystems.SlideSusbsytem;
import org.firstinspires.ftc.teamcode.subsystems.Webcam;
import org.openftc.apriltag.AprilTagDetection;
import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.easyopencv.OpenCvCameraRotation;

import java.util.ArrayList;

@Autonomous
public class AutoInCommands extends LinearOpMode {

    AprilTagDetectionPipeline aprilTagDetectionPipeline;

    double fx = 578.272;
    double fy = 578.272;
    double cx = 402.145;
    double cy = 221.506;

    double tagsize = 0.166;

    int TOI1 = 20; //case 1
    int TOI2 = 21; //case 2
    int TOI3 = 22; //case 3

    int fTag;

    AprilTagDetection tagOfInterest = null;
    Webcam cameraInit = new Webcam();

    GamepadEx gamepadEx = new GamepadEx(gamepad2);

    SlideSusbsytem slide = new SlideSusbsytem(hardwareMap, gamepadEx);

    IntakeSubsytem intake = new IntakeSubsytem(hardwareMap);

    @Override
    public void runOpMode() {
        cameraInit.webcamOnly(hardwareMap, this);

        aprilTagDetectionPipeline = new AprilTagDetectionPipeline(tagsize, fx, fy, cx, cy);

        cameraInit.cvWebcam.setPipeline(aprilTagDetectionPipeline);
        cameraInit.cvWebcam.openCameraDeviceAsync(new OpenCvCamera.AsyncCameraOpenListener()
        {
            @Override
            public void onOpened()
            {
                cameraInit.cvWebcam.startStreaming(800,448, OpenCvCameraRotation.UPRIGHT);
            }

            @Override
            public void onError(int errorCode)
            {

            }
        });

        while (!isStarted() && !isStopRequested())
        {
            ArrayList<AprilTagDetection> currentDetections = aprilTagDetectionPipeline.getLatestDetections();

            if(currentDetections.size() != 0)
            {
                boolean tagFound = false;

                for(AprilTagDetection tag : currentDetections)
                {
                    if(tag.id == TOI1 || tag.id == TOI2 || tag.id == TOI3)
                    {
                        tagOfInterest = tag;
                        fTag = tag.id;
                        tagFound = true;
                        break;
                    }
                }

                if(tagFound)
                {
                    telemetry.addLine("Tag of interest is in sight!\n\nLocation data:");
                    tagToTelemetry(tagOfInterest);
                }
                else
                {
                    telemetry.addLine("Don't see tag of interest :(");

                    if(tagOfInterest == null)
                    {
                        telemetry.addLine("(The tag has never been seen)");
                    }
                    else
                    {
                        telemetry.addLine("\nBut we HAVE seen the tag before; last seen at:");
                        tagToTelemetry(tagOfInterest);
                    }
                }

            }
            else
            {
                telemetry.addLine("Don't see tag of interest :(");

                if(tagOfInterest == null)
                {
                    telemetry.addLine("(The tag has never been seen)");
                }
                else
                {
                    telemetry.addLine("\nBut we HAVE seen the tag before; last seen at:");
                    tagToTelemetry(tagOfInterest);
                }

            }

            telemetry.update();
        }

        cameraInit.cvWebcam.stopStreaming();


        CommandScheduler.getInstance().schedule( new SequentialCommandGroup (
                new FirstBranch(hardwareMap, slide),
                new OuttakeCommand(intake),
                new SecondBranch(hardwareMap, slide, fTag)
                )
        );


        while (opModeIsActive()) {
            CommandScheduler.getInstance().run();
        }

    }

    void tagToTelemetry(AprilTagDetection detection)
    {
        telemetry.addLine(String.format("\nDetected tag ID=%d", detection.id));
    }
}
