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
import frc.robot.commands.ShooterOpenCommand;
import frc.robot.subsystems.DriveSubsytem;
import frc.robot.subsystems.HopperSubsytem;
import frc.robot.subsystems.ShooterPiston;
import frc.robot.subsystems.ShooterSubsytem;
import frc.robot.subsystems.intakeSubsytem;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class FirstBlock extends SequentialCommandGroup {
  /**
   * Creates a new FirstBlock.
   */
  public FirstBlock(DriveSubsytem m_drive, HopperSubsytem m_hopper, intakeSubsytem m_intake,
      ShooterPiston m_shooterpiston, ShooterSubsytem m_shooter, SneakyTrajectory s_trajectory) {
    // Add your commands in the super() call, e.g.
    // super(new FooCommand(), new BarCommand());
    super(s_trajectory.getRamsete(s_trajectory.FirstBlock_0).andThen(s_trajectory.getRamsete(s_trajectory.FirstBlock_1))
        .raceWith(new ShooterOpenCommand(m_shooterpiston)).andThen(new ShooterCommand(m_shooter, 1)));
  }
}
