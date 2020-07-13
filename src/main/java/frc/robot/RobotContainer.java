/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import java.util.List;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.controller.RamseteController;
import edu.wpi.first.wpilibj.controller.SimpleMotorFeedforward;
import edu.wpi.first.wpilibj.geometry.Pose2d;
import edu.wpi.first.wpilibj.geometry.Rotation2d;
import edu.wpi.first.wpilibj.geometry.Translation2d;
import edu.wpi.first.wpilibj.trajectory.Trajectory;
import edu.wpi.first.wpilibj.trajectory.TrajectoryConfig;
import edu.wpi.first.wpilibj.trajectory.TrajectoryGenerator;
import edu.wpi.first.wpilibj.trajectory.constraint.DifferentialDriveVoltageConstraint;
import frc.robot.subsystems.DriveSubsytem;
import frc.robot.subsystems.HopperSubsytem;
import frc.robot.subsystems.ShooterPiston;
import frc.robot.subsystems.ShooterSubsytem;
import frc.robot.subsystems.VisionLED;
import frc.robot.subsystems.intakeSubsytem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RamseteCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;
import frc.robot.Constants.DriveConstants;
import frc.robot.commands.*;
import frc.robot.commands.otonomus.FirstBlock;
import frc.robot.commands.otonomus.SecondBlock;

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
  private final ShooterPiston m_shooterPiston = new ShooterPiston();
  private final SneakyTrajectory s_trajectory = new SneakyTrajectory(m_drive);
  private final VisionLED m_visionLed = new VisionLED();
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
    new JoystickButton(m_driverController, 7).whenPressed(new ShooterOpenCommand(m_shooterPiston));
    new JoystickButton(m_driverController, 8).whenPressed(new ShooterCloseCommand(m_shooterPiston));
    new JoystickButton(m_driverController, 9).whileHeld(new intakeCommand(m_intake, 0.8));
    new JoystickButton(m_driverController, 10).whileHeld(new intakeOpen(m_intake, 0.5));
    new JoystickButton(m_driverController, 11).whileHeld(new intakeClose(m_intake, -0.5));
    new POVButton(m_driverController, 0).whileHeld(new FieldOriantedTurnPID(m_drive, 0));
    new POVButton(m_driverController, 90).whileHeld(new FieldOriantedTurnPID(m_drive, 90)) ;
    new POVButton(m_driverController, 270).whileHeld(new FieldOriantedTurnPID(m_drive, 270)) ;
    new POVButton(m_driverController, 360).whileHeld(new FieldOriantedTurnPID(m_drive, 360));
    new JoystickButton(m_driverController, 12).whileHeld(new CloseLED(m_visionLed));
  }
  public Command trajectoryCommand(){
  var autoVoltageConstraint =
  new DifferentialDriveVoltageConstraint(
      new SimpleMotorFeedforward(DriveConstants.ksVolts,
                                 DriveConstants.kvVoltSecondsPerMeter,
                                 DriveConstants.kaVoltSecondsSquaredPerMeter),
      Constants.kDriveKinematics,
      10);
      TrajectoryConfig config =
new TrajectoryConfig(DriveConstants.kMaxSpeedMetersPerSecond,
DriveConstants.kMaxAccelerationMetersPerSecondSquared)
// Add kinematics to ensure max speed is actually obeyed
.setKinematics(Constants.kDriveKinematics)
// Apply the voltage constraint
.addConstraint(autoVoltageConstraint);

TrajectoryConfig configReversed =
new TrajectoryConfig(DriveConstants.kMaxSpeedMetersPerSecond,
DriveConstants.kMaxAccelerationMetersPerSecondSquared)
// Add kinematics to ensure max speed is actually obeyed
.setKinematics(Constants.kDriveKinematics)
// Apply the voltage constraint
.addConstraint(autoVoltageConstraint);
configReversed.setReversed(true);
Trajectory exampleTrajectory = TrajectoryGenerator.generateTrajectory(
  // Start at the origin facing the +X direction
  new Pose2d(0, 0, new Rotation2d(0)),
  // Pass through these two interior waypoints, making an 's' curve path
  List.of(
      new Translation2d(1, -1),
      new Translation2d(2, 0)
  ),
  // End 3 meters straight ahead of where we started, facing forward
  new Pose2d(3, -1, new Rotation2d(0)),
  // Pass config
  config
);

  RamseteCommand ramseteCommand = new RamseteCommand(
  exampleTrajectory,
  m_drive::getPose,
  new RamseteController(DriveConstants.kRamseteB, DriveConstants.kRamseteZeta),
  new SimpleMotorFeedforward(DriveConstants.ksVolts,
                             DriveConstants.kvVoltSecondsPerMeter,
                             DriveConstants.kaVoltSecondsSquaredPerMeter),
  Constants.kDriveKinematics,
  m_drive::getWheelSpeeds,
  new PIDController(DriveConstants.kPDriveVel, 0, 0),
  new PIDController(DriveConstants.kPDriveVel, 0, 0),
  // RamseteCommand passes volts to the callback
  m_drive::tankDriveVolts,
  m_drive
);
  
return ramseteCommand.andThen(() -> m_drive.tankDriveVolts(0, 0));
  }

   /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
   public Command getAutonomousCommand(Integer auto){
    switch(auto){
      case 1:
      return new FirstBlock(m_drive, m_hopper, m_intake, m_shooterPiston, m_shooter, s_trajectory);
      case 2:
      return new SecondBlock(s_trajectory, m_drive, m_hopper, m_intake, m_shooter, m_shooterPiston);

      default:
      return null;
    }
    
  }
}

