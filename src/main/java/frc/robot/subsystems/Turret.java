/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.Constants.TurretConstants;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Turret extends SubsystemBase {
  private SpeedController turretAngleL, turretAngleR, shooterL, shooterR, susan;
  private SpeedControllerGroup shooter;
  public Turret() {
    turretAngleL = new Talon(TurretConstants.TURRET_PWM_LEFT);
    turretAngleR = new Talon(TurretConstants.TURRET_PWM_RIGHT);
    shooterL = new CANSparkMax(TurretConstants.SHOOTER_CAN_LEFT, MotorType.kBrushless);
    shooterR = new CANSparkMax(TurretConstants.SHOOTER_CAN_RIGHT, MotorType.kBrushless);
    susan = new Talon(TurretConstants.SUSAN_PWM);
    shooter = new SpeedControllerGroup(shooterL, shooterR);
  }

  public void shoot(){
    shooter.set(1);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
