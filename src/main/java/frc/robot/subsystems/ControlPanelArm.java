/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;
import com.revrobotics.ColorMatch;
import com.revrobotics.ColorMatchResult;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.ColorSensorV3;

public class ControlPanelArm extends SubsystemBase {
  private final I2C.Port i2cPort;
  private final ColorSensorV3 colorSensor;
  private Color rgb;
  private ColorMatch cm;
  private Color readBlue;
  private Color readGreen;
  private Color readRed;
  private Color readYellow;
  //todo: declare spinner motor
  public ControlPanelArm() {
    i2cPort = I2C.Port.kOnboard;
    colorSensor = new ColorSensorV3(i2cPort);
    //todo: init spinner motor
    cm = new ColorMatch();
    readBlue = new Color(0.2,0.5,0.3);
    readGreen = new Color(0.25,0.6,0.2);
    readRed = new Color(0.6,0.3,0.05);
    readYellow = new Color(0.42,0.5,0.05);
    cm.addColorMatch(readBlue); //blue as read by raw sensor
    cm.addColorMatch(readGreen); //green as read by raw sensor
    cm.addColorMatch(readRed); //red as read by raw sensor
    cm.addColorMatch(readYellow); //yellow as read by raw sensor
  }
  public String detectColor() { 
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
        if (matchedColor.equals(readBlue))
          return "Blue";
        if (matchedColor.equals(readGreen))
          return "Green";
        if (matchedColor.equals(readRed))
          return "Red";
        if (matchedColor.equals(readYellow) && matchedConfidence >= 0.95)
          return "Yellow";
      }
      return "No Color, Confidence: " + matchedConfidence;
    }
    return "No Match";
  }
  //todo: motor control methods
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
