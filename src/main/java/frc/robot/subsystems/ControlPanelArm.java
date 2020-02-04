/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import frc.robot.Constants.ControlPanelArmConstants;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ControlPanelArmConstants;

import com.revrobotics.ColorSensorV3;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.revrobotics.ColorMatch;
import com.revrobotics.ColorMatchResult;

public class ControlPanelArm extends SubsystemBase {
  private final ColorSensorV3 colorSensor;
  private Color rgb;
  private ColorMatch cm;
  private DoubleSolenoid extender;
  private TalonSRX armMotor;
  
  public ControlPanelArm() {
    colorSensor = new ColorSensorV3(ControlPanelArmConstants.I2C_PORT);
    cm = new ColorMatch();
    cm.addColorMatch(ControlPanelArmConstants.BLUE); 
    cm.addColorMatch(ControlPanelArmConstants.GREEN);
    cm.addColorMatch(ControlPanelArmConstants.RED);
    cm.addColorMatch(ControlPanelArmConstants.YELLOW); 
    armMotor = new TalonSRX(ControlPanelArmConstants.ARM_MOTOR_CAN);
  }

  /**
   * Detects and matches the color out of the 4 possible.
   * @return the color detected, either 'B'(lue), 'G'(reen), 'R'(ed), 'Y'(ellow)
   */
  public char detectColor() { 
    ColorMatchResult matchedColorResult;
    Color matchedColor;
    double matchedConfidence;
    rgb = colorSensor.getColor();
    cm.setConfidenceThreshold(0.01);
    matchedColorResult = cm.matchColor(rgb);
    if (matchedColorResult != null) {
      matchedColor = matchedColorResult.color;
      matchedConfidence = matchedColorResult.confidence;
      if (matchedConfidence >= 0.9) {
        if (matchedColor.equals(ControlPanelArmConstants.BLUE))
          return 'B';

        if (matchedColor.equals(ControlPanelArmConstants.GREEN))
          return 'G';

        if (matchedColor.equals(ControlPanelArmConstants.RED))
          return 'R';

        if (matchedColor.equals(ControlPanelArmConstants.YELLOW) && matchedConfidence >= 0.95)
          return 'Y';

      }
      return '?';
    }
    return '?';
  }

  /**
   * Sets the armMotor to 0.35
   */
  public void spin(){
    armMotor.set(ControlMode.PercentOutput, 1.0);
  }

  /**
   * Stops the armMotor
   */
  public void stopSpin(){
    armMotor.set(ControlMode.PercentOutput, 0.0);
  }

  /**
   * Sets the value of the solenoid
   * @param v DoubleSolenoid value to set the extender to
   */
  public void setExtender(DoubleSolenoid.Value v){
    extender.set(v);
  }
  @Override
  public void periodic() {
    
  }
}
