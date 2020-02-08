/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.controlpanelarm;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ControlPanelArm;

public class ControlPanelRotCtrl extends CommandBase {
  /**
   * Creates a new ControlPanelStageOne.
   */
  private ControlPanelArm arm;
  private char initialColor;
  public ControlPanelRotCtrl(ControlPanelArm cpa) {
    addRequirements(cpa);
    arm = cpa;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    initialColor = arm.detectColor();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    int halfRotations = 0;
    while(halfRotations < 7){
      halfRotations += initialColor == arm.detectColor() ? 1 : 0;
      arm.spinUntilNextColor();
    }
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    arm.stopSpin();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
