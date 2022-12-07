package org.firstinspires.ftc.teamcode.commandGroups;

import com.arcrobotics.ftclib.command.CommandBase;
import org.firstinspires.ftc.teamcode.subsystems.SlideSusbsytem;

public class SlideDownCommand extends CommandBase {

    private final SlideSusbsytem s_subsystem;

    public SlideDownCommand(SlideSusbsytem slide) {
        s_subsystem = slide;
        addRequirements(s_subsystem);
    }

    @Override
    public void execute() {
        s_subsystem.lower();
        s_subsystem.updatePID();
    }

}
