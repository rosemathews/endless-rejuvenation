/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.controlpanelarm;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ControlPanelArm;
import edu.wpi.first.wpilibj.DriverStation;

public class ControlPanelPosCtrl extends CommandBase {
  
  private ControlPanelArm arm;
  private char desiredColor;
  /**
   * Creates a new ControlPanelPositionControl.
   */
  public ControlPanelPosCtrl(ControlPanelArm cpa) {
    addRequirements(cpa);
    arm = cpa;
    desiredColor = '?';
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    String gameData = DriverStation.getInstance().getGameSpecificMessage();
    if(gameData.length() > 0){
      desiredColor = gameData.charAt(0);
    }
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(desiredColor == '?'){
      return;
    }
    boolean colorReached = false;
    while(colorReached == false){
      if(arm.detectColor() == desiredColor){
        colorReached = true;
        arm.stopSpin();
      }
      else{
        arm.spin();
      }
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
