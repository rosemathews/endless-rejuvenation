/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.*;
import frc.robot.Constants;
import frc.robot.Constants.ControlPanelArmConstants;
import frc.robot.commands.*;
import frc.robot.commands.controlpanelarm.*;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  //Subsystems
  private final DriveTrain drive = new DriveTrain();
  private final ControlPanelArm cpa = new ControlPanelArm();

  //Joysticks
  private final Joystick stick_left = Constants.ContainerConstants.LEFT_JOYSTICK;
  private final Joystick stick_right = Constants.ContainerConstants.RIGHT_JOYSTICK;
  private final JoystickButton butt_armExtend;
  private final JoystickButton butt_armRetract;
  private final JoystickButton butt_armAutoSpin;
  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    butt_armExtend = new JoystickButton(stick_right, ControlPanelArmConstants.ARM_FWD_BUTTON);
    butt_armRetract = new JoystickButton(stick_right, ControlPanelArmConstants.ARM_FWD_BUTTON);
    butt_armAutoSpin = new JoystickButton(stick_right, ControlPanelArmConstants.SPIN_AUTO_BUTTON);
    configureButtonBindings();
    /*
    drive.setDefaultCommand(new RunCommand(() -> 
      drive.tankDrive(
        -stick_left.getY(), 
        -stick_right.getY())
      ,drive));
    */
    drive.setDefaultCommand(new RunCommand(() -> 
      drive.arcadeDrive(
        stick_right.getY(), 
        stick_right.getX())
    ));
    cpa.setDefaultCommand(new ColorSpinManual(cpa));
  }
  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    butt_armExtend.whenPressed(new ArmExtend(cpa));
    butt_armRetract.whenPressed(new ArmRetract(cpa));
    butt_armAutoSpin.whenPressed(new ControlPanelPosCtrl(cpa));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return null;
  }
}
