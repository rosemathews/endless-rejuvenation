/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.Constants.IntakeConstants;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {

  private SpeedController dropper;
  private SpeedController roller;
  private DigitalInput bottomSwitch;
  private DigitalInput ballSwitch;
  private DigitalInput topSwitch;
  private int ballsLoaded;
  /**
   * Creates a new Intake.
   */
  public Intake() {
    dropper = new Talon(IntakeConstants.ROLLER_PWM);
    roller = new Talon(IntakeConstants.DROPPER_PWM);
    bottomSwitch = new DigitalInput(IntakeConstants.BOTTOM_CHANNEL);
    ballSwitch = new DigitalInput(IntakeConstants.BALL_CHANNEL);
    topSwitch = new DigitalInput(IntakeConstants.TOP_CHANNEL);

    ballsLoaded = 0;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
