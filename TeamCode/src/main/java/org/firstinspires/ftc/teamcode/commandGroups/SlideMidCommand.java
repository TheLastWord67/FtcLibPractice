package org.firstinspires.ftc.teamcode.commandGroups;

import com.arcrobotics.ftclib.command.CommandBase;
import org.firstinspires.ftc.teamcode.subsystems.SlideSusbsytem;

public class SlideMidCommand extends CommandBase {

    private final SlideSusbsytem s_subsystem;

    public SlideMidCommand(SlideSusbsytem slide) {
        s_subsystem = slide;
        addRequirements(s_subsystem);
    }

    @Override
    public void execute() {
        s_subsystem.run_to_med();
        s_subsystem.updatePID();
    }

}
