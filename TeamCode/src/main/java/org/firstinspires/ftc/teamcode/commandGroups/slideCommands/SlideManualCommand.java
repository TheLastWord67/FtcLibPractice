package org.firstinspires.ftc.teamcode.commandGroups.slideCommands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import org.firstinspires.ftc.teamcode.subsystems.SlideSusbsytem;

public class SlideManualCommand extends CommandBase {

    private final SlideSusbsytem s_subsystem;

    public SlideManualCommand(SlideSusbsytem slideSusbsytem) {
        s_subsystem = slideSusbsytem;
        addRequirements(s_subsystem);
    }

    @Override
    public void execute() {
        s_subsystem.manual();
    }

}
