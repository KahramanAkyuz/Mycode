/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.HopperConstants;

public class HopperSubsytem extends SubsystemBase {
  /**
   * Creates a new HopperSubsytem.
   */
  private final VictorSP hopperMotor_A = new VictorSP(HopperConstants.hopperMotor_A);
  private final VictorSP hopperMotor_B = new VictorSP(HopperConstants.hopperMotor_B);
  public HopperSubsytem() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void runHopper(double speed){
    hopperMotor_A.set(speed);
    hopperMotor_B.set(speed);
  }
  public void stopHopper(){
    hopperMotor_A.set(0);
    hopperMotor_B.set(0);
  }
}
