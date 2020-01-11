/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Vision;

/**
 * An example command.  You can replace me with your own command.
 */
public class PivotCommand extends CommandBase {
  DriveTrain dr;
  Vision vision;
  double P = 1.8;
  double I = 0.0;
  double D = 0.0;
  double integral, previous_error, setpoint = 0.0;
  double rcw = 0.0;

  public PivotCommand(Vision v,DriveTrain drive) {
    this.dr = drive;
    this.vision = v;
  }
  // private double convert(double percent) {

  // }%
  // Called just before this Command runs the first time
  @Override
  public void initialize() {
  }
  void TurnAtSpeed(double speed) {
    dr.tankDrive(-speed, speed);
  }
  void PID() {
    double error = setpoint - vision.getTX();
    this.integral += (error*0.2);
    double derivative = (error - this.previous_error) / 0.2;
    this.rcw = P*error + I*this.integral + D*derivative;
  }
  // Called repeatedly when this Command is scheduled to run
  @Override
  public void execute() {
    try {
      if (vision.getTX() != 0.0) {
        // PID();
        // Robot.drive.arcadeDrive(-rcw/32.0, 0.0);
        if (vision.getTX() > 2.0) {
          if (vision.getTX() > 1.0) {
            TurnAtSpeed(0.6);
          }else {
            TurnAtSpeed(0.3);
          }
        }else if (vision.getTX() < -2.0) {
          if (vision.getTX() < -1.0) {
            TurnAtSpeed(-0.6);
          }else {
            TurnAtSpeed(-0.3);
          }
        }
      }
    } catch (NullPointerException e) {
      System.out.println("Caught Exception");
    }
    

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  public boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  public void end(boolean interrupted) {
      System.out.print("");
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  
}
