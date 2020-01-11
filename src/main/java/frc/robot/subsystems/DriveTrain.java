/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;


import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {
  
  private SpeedController sc_RightB, sc_RightF, sc_LeftB, sc_LeftF;
  
  private SpeedControllerGroup sc_RightGroup, sc_LeftGroup;

  private DifferentialDrive drive;

  /**
   * Creates a new DriveTrain.
   */
  public DriveTrain() {
    sc_RightB = new Talon(Constants.DRIVE_INTAKE_RIGHT_BACK);
    sc_RightF = new Talon(Constants.DRIVE_INTAKE_RIGHT_FRONT);
    sc_LeftB = new Talon(Constants.DRIVE_INTAKE_LEFT_BACK);
    sc_LeftF = new Talon(Constants.DRIVE_INTAKE_LEFT_FRONT);

    sc_LeftGroup = new SpeedControllerGroup(sc_LeftF, sc_LeftB);
    sc_RightGroup = new SpeedControllerGroup(sc_RightF, sc_RightB);

    drive = new DifferentialDrive(sc_LeftGroup, sc_RightGroup);

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
