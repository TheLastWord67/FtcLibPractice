package org.firstinspires.ftc.teamcode.opModes;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.commandGroups.DriveCommand;
import org.firstinspires.ftc.teamcode.commandGroups.SlideManualCommand;
import org.firstinspires.ftc.teamcode.subsystems.DriveSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.SlideSusbsytem;

@TeleOp (name = "Command Teleop: No modifiers", group = "Command Based")
public class CommandsOpMode extends CommandOpMode {

    public DriveSubsystem d_subsystem;
    public SlideSusbsytem s_subsystem;
    public DriveCommand d_command;
    public SlideManualCommand s_manual;

    GamepadEx driver = new GamepadEx(gamepad1);
    GamepadEx operator = new GamepadEx(gamepad2);

    @Override
    public void initialize() {
        d_subsystem = new DriveSubsystem(hardwareMap, driver);
        s_subsystem = new SlideSusbsytem(hardwareMap, operator);

        d_command = new DriveCommand(d_subsystem);
        s_manual = new SlideManualCommand(s_subsystem);

        schedule(d_command, s_manual);
    }
}
