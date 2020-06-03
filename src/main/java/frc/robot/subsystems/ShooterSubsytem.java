/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ShooterConstants;

public class ShooterSubsytem extends SubsystemBase {
  /**
   * Creates a new ShooterSubsytem.
   */
  private final CANSparkMax shooterMotor = new CANSparkMax(ShooterConstants.shootermotor,  MotorType.kBrushless);
  public ShooterSubsytem() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void runShooter(double speed)
  {
    shooterMotor.set(speed);
  }
  public void stopShooter()
  {
    shooterMotor.set(0);
  }
}
