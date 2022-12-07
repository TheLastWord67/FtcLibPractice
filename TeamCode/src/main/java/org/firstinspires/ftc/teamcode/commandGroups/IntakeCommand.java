package org.firstinspires.ftc.teamcode.commandGroups;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.IntakeSubsytem;

public class IntakeCommand extends CommandBase {

    private final IntakeSubsytem i_subsystem;

    public IntakeCommand(IntakeSubsytem intake) {
        i_subsystem = intake;
        addRequirements(i_subsystem);
    }

    @Override
    public void initialize() {
        i_subsystem.intake();
    }

    @Override
    public boolean isFinished() {
        return true;
    }

}
