/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.subsystems.DriveSubsytem;
import frc.robot.subsystems.HopperSubsytem;
import frc.robot.subsystems.ShooterPiston;
import frc.robot.subsystems.ShooterSubsytem;
import frc.robot.subsystems.intakeSubsytem;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;
import frc.robot.commands.*;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a "declarative" paradigm, very little robot logic should
 * actually be handled in the {@link Robot} periodic methods (other than the
 * scheduler calls). Instead, the structure of the robot (including subsystems,
 * commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  private final intakeSubsytem m_intake = new intakeSubsytem();
  private final HopperSubsytem m_hopper = new HopperSubsytem();
  // The robot's subsystems and commands are defined here...
  private final DriveSubsytem m_drive = new DriveSubsytem();
  public Joystick m_driverController = new Joystick(0);
  private final ShooterSubsytem m_shooter = new ShooterSubsytem();
  private final ShooterPiston m_shooteropen = new ShooterPiston();
  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    m_drive.setDefaultCommand(new JoystickDriveCommand(m_drive, () -> -m_driverController.getRawAxis(1),
        () -> m_driverController.getRawAxis(0)));
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    new JoystickButton(m_driverController, 3).whileHeld(new HopperCommand(m_hopper, 0.5));
    new JoystickButton(m_driverController, 4).whileHeld(new HopperCommand(m_hopper, -0.5));
    new JoystickButton(m_driverController, 5).whileHeld(new ShooterCommand(m_shooter, 0.8));
    new JoystickButton(m_driverController, 6).whileHeld(new ShooterCommand(m_shooter, -0.8));
    new JoystickButton(m_driverController, 7).whenPressed(new ShooterOpenCommand(m_shooteropen));
    new JoystickButton(m_driverController, 8).whenPressed(new ShooterCloseCommand(m_shooteropen));
    new JoystickButton(m_driverController, 9).whileHeld(new intakeCommand(m_intake, 0.8));
    new JoystickButton(m_driverController, 10).whileHeld(new intakeOpen(m_intake, 0.5));
    new JoystickButton(m_driverController, 11).whileHeld(new intakeClose(m_intake, -0.5));
    new POVButton(m_driverController, 0).whileHeld(new FieldOriantedTurnPID(m_drive, 0));
    new POVButton(m_driverController, 90).whileHeld(new FieldOriantedTurnPID(m_drive, 90)) ;
    new POVButton(m_driverController, 270).whileHeld(new FieldOriantedTurnPID(m_drive, 270)) ;
    new POVButton(m_driverController, 360).whileHeld(new FieldOriantedTurnPID(m_drive, 360));
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
}
