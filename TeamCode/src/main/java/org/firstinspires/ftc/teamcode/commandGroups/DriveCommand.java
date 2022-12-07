package org.firstinspires.ftc.teamcode.commandGroups;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import org.firstinspires.ftc.teamcode.subsystems.DriveSubsystem;

import java.util.function.DoubleSupplier;

public class DriveCommand extends CommandBase {

    private DriveSubsystem d_subsystem;
    GamepadEx gamepadEx;

    public DriveCommand (DriveSubsystem driveSubsystem, GamepadEx gamepad1) {
        d_subsystem = driveSubsystem;
        gamepadEx = gamepad1;
        addRequirements(d_subsystem);
    }

    @Override
    public void execute() {
        d_subsystem.driveFC(gamepadEx);
    }
}
