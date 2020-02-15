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

import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Turret extends SubsystemBase {
  private SpeedController shooterL, shooterR;
  private SpeedControllerGroup shooter;
  private DigitalOutput turret;
  private Encoder enc_turret;
  public Turret() {
    turret = new DigitalOutput(TurretConstants.TURRET_CHANNEL);
    turret.enablePWM(0.375);
    turret.setPWMRate(250);
    shooterL = new CANSparkMax(TurretConstants.SHOOTER_CAN_LEFT, MotorType.kBrushless);
    shooterR = new CANSparkMax(TurretConstants.SHOOTER_CAN_RIGHT, MotorType.kBrushless);
    shooter = new SpeedControllerGroup(shooterL, shooterR);
    enc_turret = new Encoder(TurretConstants.ENCODER_LEFT_CHANNEL, TurretConstants.ENCODER_RIGHT_CHANNEL);
  }

  public void shoot() {
    shooter.set(1);
  }

 public int angle() {
   turret.updateDutyCycle((0.25*0.5+1.5)/4);;
   return enc_turret.get();
 }
  
  public void stop(){
    shooter.set(0);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
