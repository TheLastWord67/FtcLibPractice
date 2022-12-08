package org.firstinspires.ftc.teamcode.commandGroups.roadrunnerCommands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.command.ParallelCommandGroup;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.commandGroups.StopIntakeCommand;
import org.firstinspires.ftc.teamcode.commandGroups.StopIntakeCommand;
import org.firstinspires.ftc.teamcode.commandGroups.slideCommands.SlideDownCommand;
import org.firstinspires.ftc.teamcode.subsystems.IntakeSubsytem;
import org.firstinspires.ftc.teamcode.subsystems.SlideSusbsytem;

public class SecondBranch extends ParallelCommandGroup {

    public SecondBranch(HardwareMap hardware, SlideSusbsytem slide, IntakeSubsytem intake, int tag) {
        addCommands(
                new ParkCommand(hardware, tag),
                new SlideDownCommand(slide),
                new StopIntakeCommand(intake)
        );
    }

}
