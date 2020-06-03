/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.IntakeConstants;

public class intakeSubsytem extends SubsystemBase {
  /**
   * Creates a new intakeSubsytem.
   */
  private final VictorSP intakeMotor = new VictorSP(IntakeConstants.intakeMotor);
  private final VictorSP intakeOpenMotor = new VictorSP(IntakeConstants.intakeOpenMotor);
  private final DigitalInput OpenLimitSwitch = new DigitalInput(IntakeConstants.OpenLimitSwitch);
  private final DigitalInput CloseLimitSwitch = new DigitalInput(IntakeConstants.CloseLimitSwitch);
  public intakeSubsytem() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public boolean getOpenSwitch(){
    return OpenLimitSwitch.get();
  }
  public boolean getCloseSwitch(){
    return CloseLimitSwitch.get();
  }
  public void runIntake(double speed){
    intakeMotor.set(speed);
  }
  public void stopIntake(){
    intakeMotor.set(0);
    }
  public void openIntake(double speed){
    intakeOpenMotor.set(speed);
  }
  public void closeIntake(double speed){
    intakeOpenMotor.set(speed);
  }
  public void stopIntake2(){
    intakeOpenMotor.set(0);
  }
}
