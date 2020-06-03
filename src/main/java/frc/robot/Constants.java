/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public final class IntakeConstants{
        public static final int intakeMotor = 0;
        public static final int intakeOpenMotor = 1;
        public static final int OpenLimitSwitch = 8;
        public static final int CloseLimitSwitch = 9;
    }
    public final class HopperConstants{
        public static final int hopperMotor_A = 2;
        public static final int hopperMotor_B = 3;
    }
    public final class DriveConstants{
        public static final int LeftMotor = 4;
        public static final int RightMotor = 5;
        public static final double driveP = 1.0;
        public static final double driveI = 0.0;
        public static final double distenceaccuary = 3.0;
        public static final double driveD = 0.0;
    }
    public final class ShooterConstants{
        public static final int compressor = 0;
        public static final int shooterselenoid_A_Pin1 = 0;
        public static final int shooterselenoid_A_Pin2 = 1;
        public static final int shooterselenoid_B_Pin1 = 2;
        public static final int shooterselenoid_B_Pin2 = 3;
        public static final int shootermotor = 6;
    }
}
