/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.kinematics.DifferentialDriveKinematics;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean constants. This class should not be used for any other
 * purpose. All constants should be declared globally (i.e. public static). Do
 * not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the constants are needed, to reduce verbosity.
 */
public final class Constants {
    public final class IntakeConstants{
        public static final int intakeMotor = 0;
        public static final int intakeOpenMotor = 1;
        public static final int OpenLimitSwitch = 8;
        public static final int CloseLimitSwitch = 9;
    }
    public final class VisionLEDConstants{
        public static final int kLEDRelayPort = 1;
        public static final int kStatusLEDPort = 0;
        public static final int kStatusLEDLength = 0;
    }
    public final class HopperConstants{
        public static final int hopperMotor_A = 2;
        public static final int hopperMotor_B = 3;
    }
    public final class DriveConstants{
        public static final int LeftMotor = 4;
        public static final int RightMotor = 5;
        public static final double distenceaccuary = 3.0;
        public static final double ksVolts = 0.22;
        public static final double kPDriveVel = 8.5;
        
        public static final double kvVoltSecondsPerMeter = 1.98;
        public static final double kRamseteB = 2;
        public static final double kRamseteZeta = 0.7;
        public static final double kaVoltSecondsSquaredPerMeter = 0.2;
        public static final double kMaxSpeedMetersPerSecond = 3;
        public static final double kMaxAccelerationMetersPerSecondSquared = 3;
        public static final double accuary = 2.0;
        public static final double turnP = 1.0;
        public static final double trunI = 0.0;
        public static final double trunD = 0.0;

     
     public static final double driveP = 1.0;
     public static final double driveI = 0.0;
     public static final double driveD = 0.0;
     }
    public final class ShooterConstants{
        public static final int compressor = 0;
        public static final int shooterselenoid_A_Pin1 = 0;
        public static final int shooterselenoid_A_Pin2 = 1;
        public static final int shooterselenoid_B_Pin1 = 2;
        public static final int shooterselenoid_B_Pin2 = 3;
        public static final int shootermotor = 6;
        public static final double kS = 0.656;
        public static final double kV = 0.00202;
        public static final double kA = 0.000494;
        public static final double kShootP = 0.006;
        public static final double kShootI = 0.000;
        public static final double kShootD = 0.000;
    }
        public static final double kTrackwidthMeters = 0.69;
        public static final DifferentialDriveKinematics kDriveKinematics =
         new DifferentialDriveKinematics(kTrackwidthMeters);
}
