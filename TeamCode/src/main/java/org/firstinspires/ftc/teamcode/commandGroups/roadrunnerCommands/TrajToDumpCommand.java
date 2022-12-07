package org.firstinspires.ftc.teamcode.commandGroups.roadrunnerCommands;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.arcrobotics.ftclib.command.CommandBase;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.teamcode.roadrunner.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.roadrunner.trajectorysequence.TrajectorySequence;

public class TrajToDumpCommand extends CommandBase {

    SampleMecanumDrive drive;

    public TrajToDumpCommand (HardwareMap hardware) {
        drive = new SampleMecanumDrive(hardware);
        //I am hot
    }

    @Override
    public void initialize() {
        Pose2d startPose = new Pose2d(0, 0, 0);
        drive.setPoseEstimate(startPose);
        TrajectorySequence dump = drive.trajectorySequenceBuilder(startPose)
                .lineTo(new Vector2d(26, 0))
                .lineTo(new Vector2d(29, -12.8))
                .build();
        drive.followTrajectorySequenceAsync(dump);
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
