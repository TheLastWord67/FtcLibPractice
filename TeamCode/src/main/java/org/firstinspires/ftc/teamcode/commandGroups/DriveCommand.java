package org.firstinspires.ftc.teamcode.commandGroups;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import org.firstinspires.ftc.teamcode.subsystems.DriveSubsystem;

import java.util.function.DoubleSupplier;

public class DriveCommand extends CommandBase {

    private final DriveSubsystem d_subsystem;

    public DriveCommand (DriveSubsystem driveSubsystem) {
        d_subsystem = driveSubsystem;
        addRequirements(d_subsystem);
    }

    @Override
    public void execute() {
        d_subsystem.driveFC();
        //I am hot
    }
}
