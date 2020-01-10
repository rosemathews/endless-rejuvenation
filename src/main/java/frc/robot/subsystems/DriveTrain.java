/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase {
  
  private SpeedController m_RightB, m_RightF, m_LeftB, m_LeftF;
  
  private SpeedControllerGroup m_RightGroup, m_LeftGroup;

  private DifferentialDrive drive;

  /**
   * Creates a new DriveTrain.
   */
  public DriveTrain() {
    m_RightB = new Talon(0);
    m_RightF = new Talon(1);
    m_LeftB = new Talon(2);
    m_LeftF = new Talon(3);

    m_LeftGroup = new SpeedControllerGroup(m_LeftF, m_LeftB);
    m_RightGroup = new SpeedControllerGroup(m_RightF, m_RightB);

    drive = new DifferentialDrive(m_LeftGroup, m_RightGroup);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void tankDrive(double input_Left, double input_Right){
    drive.tankDrive(input_Left, input_Right);
  }

  public void arcadeDrive(double input_y, double input_x){
    drive.arcadeDrive(input_y, input_x);
  }
}
