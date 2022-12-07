package org.firstinspires.ftc.teamcode.commandGroups.roadrunnerCommands;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.arcrobotics.ftclib.command.CommandBase;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.teamcode.roadrunner.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.roadrunner.trajectorysequence.TrajectorySequence;

public class ParkCommand extends CommandBase {

    SampleMecanumDrive drive;

    int found_tag;

    public ParkCommand (HardwareMap hardware, int tag) {
        drive = new SampleMecanumDrive(hardware);
        found_tag = tag;
        //I am hot
    }

    @Override
    public void initialize() {
        Pose2d startPose = new Pose2d(0, 0, 0);
        Pose2d dumpPose = new Pose2d(29, -12.8, 0);
        TrajectorySequence trajTo1_left = drive.trajectorySequenceBuilder(dumpPose)
                .waitSeconds(1)
                .lineToSplineHeading(new Pose2d(28,28, Math.toRadians(0)))
                .build();
        TrajectorySequence trajTo3_right = drive.trajectorySequenceBuilder(dumpPose)
                .waitSeconds(1)
                .lineToSplineHeading(new Pose2d(28,-28, Math.toRadians(0)))
                .build();
        TrajectorySequence trajTo2_C = drive.trajectorySequenceBuilder(dumpPose)
                .waitSeconds(1)
                .lineToSplineHeading(new Pose2d(28,0, Math.toRadians(0)))
                .build();
        if (found_tag == 20) {
            drive.followTrajectorySequenceAsync(trajTo1_left);
        } else if (found_tag == 21) {
            drive.followTrajectorySequenceAsync(trajTo2_C);
        } else {
            drive.followTrajectorySequenceAsync(trajTo3_right);
        }
    }

    @Override
    public void execute() {
        drive.update();
    }

    @Override
    public boolean isFinished() {
        return drive.isBusy();
    }

}
