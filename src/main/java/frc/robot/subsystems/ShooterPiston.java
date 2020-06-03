/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ShooterConstants;

public class ShooterPiston extends SubsystemBase {
  /**
   * Creates a new ShooterPiston.
   */
  private final Compressor compressor = new Compressor(ShooterConstants.compressor);
  private final DoubleSolenoid shootersolenoid_A = new DoubleSolenoid(ShooterConstants.shooterselenoid_A_Pin1, ShooterConstants.shooterselenoid_A_Pin2);
  private final DoubleSolenoid shootersolenoid_B = new DoubleSolenoid(ShooterConstants.shooterselenoid_B_Pin1, ShooterConstants.shooterselenoid_B_Pin2);
  public ShooterPiston() {
    compressorDisable();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void compressorEnable(){
    compressor.setClosedLoopControl(true);
  }
  public void compressorDisable(){
    compressor.setClosedLoopControl(false);
  }
  public void shooterOpen(){
    shootersolenoid_A.set(Value.kForward);
    shootersolenoid_B.set(Value.kForward);
  }
  public void shooterClose(){
    shootersolenoid_A.set(Value.kReverse);
    shootersolenoid_B.set(Value.kReverse);
  }
  public void stopCylinder(){
    shootersolenoid_A.set(Value.kOff);
    shootersolenoid_B.set(Value.kOff);
  }
}
