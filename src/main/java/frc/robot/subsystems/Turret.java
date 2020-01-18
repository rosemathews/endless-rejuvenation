/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.Constants.TurretConstants;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Turret extends SubsystemBase {
  private SpeedController sc_TurretAngleL, sc_TurretAngleR, sc_ShooterL, sc_ShooterR, sc_Susan;
  private SpeedControllerGroup scg_Shooter;
  public Turret() {
    sc_TurretAngleL = new Talon(TurretConstants.TURRET_PWM_LEFT);
    sc_TurretAngleR = new Talon(TurretConstants.TURRET_PWM_RIGHT);
    sc_ShooterL = new Talon(TurretConstants.SHOOTER_PWM_LEFT);
    sc_ShooterR = new Talon(TurretConstants.SHOOTER_PWM_RIGHT);
    sc_Susan = new Talon(TurretConstants.SUSAN_PWM);
    scg_Shooter = new SpeedControllerGroup(sc_ShooterL, sc_ShooterR);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
