package org.firstinspires.ftc.teamcode.commandGroups;

import com.arcrobotics.ftclib.command.CommandBase;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.subsystems.IntakeSubsytem;

public class OuttakeCommand extends CommandBase {

    private final IntakeSubsytem i_subsystem;

    public OuttakeCommand(IntakeSubsytem it) {
        i_subsystem = it;
        addRequirements(i_subsystem);
    }

    @Override
    public void initialize() {
        i_subsystem.out();
    }

    @Override
    public boolean isFinished() {
        return true;
    }

}
