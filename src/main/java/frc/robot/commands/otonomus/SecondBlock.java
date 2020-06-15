/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.otonomus;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.SneakyTrajectory;
import frc.robot.commands.ShooterCommand;
import frc.robot.commands.intakeClose;
import frc.robot.subsystems.DriveSubsytem;
import frc.robot.subsystems.HopperSubsytem;
import frc.robot.subsystems.ShooterPiston;
import frc.robot.subsystems.ShooterSubsytem;
import frc.robot.subsystems.intakeSubsytem;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class SecondBlock extends SequentialCommandGroup {
  /**
   * Creates a new SecondBlock.
   */
  public SecondBlock(SneakyTrajectory s_trajectory, DriveSubsytem m_drive, HopperSubsytem m_hopper,
      intakeSubsytem m_intake, ShooterSubsytem m_shooter, ShooterPiston m_sShooterPiston) {
    // Add your commands in the super() call, e.g.
    // super(new FooCommand(), new BarCommand());
    super(s_trajectory.getRamsete(s_trajectory.SecondBlck_0).andThen(new intakeClose(m_intake, 0.5).raceWith(s_trajectory.getRamsete(s_trajectory.SecondBlock_1)), new ShooterCommand(m_shooter, 1)));
  }
}
