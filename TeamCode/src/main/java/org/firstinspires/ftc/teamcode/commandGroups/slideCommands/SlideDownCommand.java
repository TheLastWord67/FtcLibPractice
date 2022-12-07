package org.firstinspires.ftc.teamcode.commandGroups.slideCommands;

import com.arcrobotics.ftclib.command.CommandBase;
import org.firstinspires.ftc.teamcode.subsystems.SlideSusbsytem;

public class SlideDownCommand extends CommandBase {

    private final SlideSusbsytem s_subsystem;

    public SlideDownCommand(SlideSusbsytem slide) {
        s_subsystem = slide;
        addRequirements(s_subsystem);
    }

    @Override
    public void initialize() {
        s_subsystem.lower();
    }

    @Override
    public void execute() {
        s_subsystem.updatePID();
    }

    @Override
    public boolean isFinished() {
        return Math.abs(s_subsystem.getTarget() - s_subsystem.getCurrentPosition()) <= 10;
    }

}
