package org.firstinspires.ftc.teamcode.commandGroups.roadrunnerCommands;

import com.arcrobotics.ftclib.command.ParallelCommandGroup;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.teamcode.commandGroups.slideCommands.SlideUpCommand;
import org.firstinspires.ftc.teamcode.subsystems.SlideSusbsytem;

public class FirstBranch extends ParallelCommandGroup {

    public FirstBranch(HardwareMap hardware, SlideSusbsytem slide) {
        addCommands(
                new TrajToDumpCommand(hardware),
                new SlideUpCommand(slide)
        );
    }

}
