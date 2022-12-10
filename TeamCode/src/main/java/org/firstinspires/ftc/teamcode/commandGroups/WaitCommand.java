package org.firstinspires.ftc.teamcode.commandGroups;

import com.arcrobotics.ftclib.command.CommandBase;
import com.qualcomm.robotcore.util.ElapsedTime;

public class WaitCommand extends CommandBase {

    ElapsedTime waitTimer = new ElapsedTime();

    double waitTime;

    public WaitCommand(double seconds) {
        waitTime = seconds;
    }

    @Override
    public void initialize() {
        waitTimer.reset();
        //reset timer for wait loop
    }

    @Override
    public void execute() {
        while (waitTimer.seconds() < waitTime) {
            //do nothing lol
        }
    }

    @Override
    public boolean isFinished() {
        return true;
    }

}
