/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.Constants.DriveConstants;
import frc.robot.subsystems.DriveSubsytem;

public class FieldOriantedTurnPID extends PIDCommand {
  /**
   * Creates a new FieldOriantedTurnPID.
   */
  public FieldOriantedTurnPID(DriveSubsytem m_drive, double targetDistance) {
    super(
      new PIDController(DriveConstants.driveP, DriveConstants.driveI, DriveConstants.driveD),
      () -> m_drive.gettotalDistance(),
      targetDistance,
      output -> {
       m_drive.arcadeDrive(output, 0);

      });
      addRequirements(m_drive);
      getController().setTolerance(DriveConstants.distenceaccuary);
    // Use addRequirements() here to declare subsystem dependencies. 
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}