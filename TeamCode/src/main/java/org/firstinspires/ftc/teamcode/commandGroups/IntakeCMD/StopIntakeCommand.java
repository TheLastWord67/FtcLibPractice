package org.firstinspires.ftc.teamcode.commandGroups.IntakeCMD;

import com.arcrobotics.ftclib.command.CommandBase;
import org.firstinspires.ftc.teamcode.subsystems.IntakeSubsytem;

public class StopIntakeCommand extends CommandBase {

    private final IntakeSubsytem i_subsystem;

    public StopIntakeCommand(IntakeSubsytem intake) {
        i_subsystem = intake;
    }

    @Override
    public void initialize() {
        i_subsystem.nuetral();
    }

    @Override
    public boolean isFinished() {
        return true;
    }

}
