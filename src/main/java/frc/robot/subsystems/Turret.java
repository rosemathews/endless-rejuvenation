/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.Constants.TurretConstants;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Turret extends SubsystemBase {
  private SpeedController sc_TurretAngle, sc_ShooterL, sc_ShooterR, sc_Susan;
  private Encoder enc_Turret;
  public Turret() {
    sc_TurretAngle = new Talon(TurretConstants.TURRET_PWM);
    sc_ShooterL = new Talon(TurretConstants.SHOOTER_PWM_LEFT);
    sc_ShooterR = new Talon(TurretConstants.SHOOTER_PWM_RIGHT);
    sc_Susan = new Talon(TurretConstants.SUSAN_PWM);
    enc_Turret = new Encoder(TurretConstants.ENCODER_3_DIO1, TurretConstants.ENCODER_3_DIO2, false);
  }
  public void fire() {
    sc_ShooterL.set(1.0);
    sc_ShooterR.set(-1.0);
  }
  public void angleTurret() {
    //get dist from limelight
    double distance = 1.0;
    //formula to convert to angle (gravity not considered)
    double angle = Math.tanh(8.1875/distance);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
