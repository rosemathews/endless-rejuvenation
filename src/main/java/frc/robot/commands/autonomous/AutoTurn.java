/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.autonomous;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class AutoTurn extends CommandBase {
  private DriveTrain drive;
  private double turnDistance;
  private boolean clockwise;
  public AutoTurn(double degrees, DriveTrain d) {
    addRequirements(d);
    drive = d;
    turnDistance = degrees * 0.0163; //feet per degree
    clockwise = turnDistance > 0;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (clockwise) {
      drive.tankDrive(1,-1);
    } else {
      drive.tankDrive(-1,1);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return Math.abs(drive.getEncLeftDistance()) > turnDistance;
  }
}
