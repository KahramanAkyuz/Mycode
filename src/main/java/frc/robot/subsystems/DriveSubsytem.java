/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.EncoderType;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.kinematics.DifferentialDriveWheelSpeeds;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;

public class DriveSubsytem extends SubsystemBase {
  /**
   * Creates a new DriveSubsytem.
   */
  
  private final CANSparkMax LeftMotor = new CANSparkMax(DriveConstants.LeftMotor, MotorType.kBrushless);
  private final CANSparkMax RightMotor = new CANSparkMax(DriveConstants.RightMotor, MotorType.kBrushless);
  private final CANEncoder Encoder_A = LeftMotor.getEncoder(EncoderType.kQuadrature, 4096);
  private final CANEncoder Encoder_B = RightMotor.getEncoder(EncoderType.kQuadrature, 4096);
  private final DifferentialDrive m_drive = new DifferentialDrive(LeftMotor, RightMotor);
  

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void arcadeDrive(double fwd, double rot){
    m_drive.arcadeDrive(fwd , rot , true);
  }
  public double gettotalDistance(){
    return (Encoder_B.getPosition() + Encoder_A.getPosition()) / 2;
  }
  public DifferentialDriveWheelSpeeds getWheelSpeeds(){
    return new DifferentialDriveWheelSpeeds(Encoder_A.getVelocity(), Encoder_B.getVelocity());
  }
  public void tankDriveVolts(double leftVolts, double rightVolts) {
    LeftMotor.setVoltage(leftVolts);
    RightMotor.setVoltage(-rightVolts);
    m_drive.feed();
  }
}
