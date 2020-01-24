/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import java.util.ArrayList;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ControlPanelArm;

public class ColorSpinAuto extends CommandBase {
  ArrayList<String> wheelOrder;
  String colorReading;
  ControlPanelArm arm;
  String colorToSpin;
  public ColorSpinAuto(ControlPanelArm a, String color) {
    addRequirements(a);
    arm = a;
    colorToSpin = color;
    wheelOrder = new ArrayList<String>(); //no use until PID
    wheelOrder.add("Yellow"); 
    wheelOrder.add("Red"); 
    wheelOrder.add("Green"); 
    wheelOrder.add("Blue");
    
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //todo: implement PID
    colorReading = arm.detectColor();
    arm.spin(1.0);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return colorReading.equals(colorToSpin);
  }
}
