package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
public class Vision extends SubsystemBase {
    static NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
    static NetworkTableEntry tv = table.getEntry("tv");
  
    static NetworkTableEntry tx = table.getEntry("tx");
    static NetworkTableEntry ty = table.getEntry("ty");
    static NetworkTableEntry ta = table.getEntry("ta");

    public Vision() {

    }
    public void printYeet() {
        System.out.println("yeet");
    }
    public double getTX() {
        return tx.getDouble(0.0);
    }
    public double getTY() {
        return ty.getDouble(0.0);
    }
    public boolean getVisible() {
        return tv.getBoolean(false);
    }
    public double getArea() {
        return ta.getDouble(0.0);
    }

    @Override
    public void periodic() {
        // System.out.println(tx.getDouble(0.0));
    // This method will be called once per scheduler run
    }

}
