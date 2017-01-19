// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc1089.X4RobotBuilder2016;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Solenoid;

import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

    public static DoubleSolenoid shooterLowElevator;
    public static DoubleSolenoid shooterHighElevator;
    public static Solenoid shooterShooter;
    public static AnalogGyro driveTrainGyro;
    public static CANTalon driveTrainLeftBack;
    public static CANTalon driveTrainRightBack;
    public static CANTalon driveTrainLeftFront;
    public static CANTalon driveTrainRightFront;
    public static RobotDrive driveTrainRobotDrive;
    public static CANTalon intakeRoller;
    public static DoubleSolenoid intakeDoorElevator;

    public static void init() {
        shooterLowElevator = new DoubleSolenoid(6, 4, 3);
        LiveWindow.addActuator("Shooter", "LowElevator", shooterLowElevator);
        
        shooterHighElevator = new DoubleSolenoid(6, 0, 1);
        LiveWindow.addActuator("Shooter", "HighElevator", shooterHighElevator);
        
        shooterShooter = new Solenoid(6, 7);
        LiveWindow.addActuator("Shooter", "Shooter", shooterShooter);
        
        driveTrainGyro = new AnalogGyro(0);
        LiveWindow.addSensor("DriveTrain", "Gyro", driveTrainGyro);
        driveTrainGyro.setSensitivity(0.007);
        driveTrainLeftBack = new CANTalon(3);
        LiveWindow.addActuator("DriveTrain", "LeftBack", driveTrainLeftBack);
        
        driveTrainRightBack = new CANTalon(1);
        LiveWindow.addActuator("DriveTrain", "RightBack", driveTrainRightBack);
        
        driveTrainLeftFront = new CANTalon(4);
        LiveWindow.addActuator("DriveTrain", "LeftFront", driveTrainLeftFront);
        
        driveTrainRightFront = new CANTalon(2);
        LiveWindow.addActuator("DriveTrain", "RightFront", driveTrainRightFront);
        
        driveTrainRobotDrive = new RobotDrive(driveTrainLeftFront, driveTrainRightFront);
        
        driveTrainRobotDrive.setSafetyEnabled(true);
        driveTrainRobotDrive.setExpiration(0.1);
        driveTrainRobotDrive.setSensitivity(0.5);
        driveTrainRobotDrive.setMaxOutput(1.0);
        driveTrainRobotDrive.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
        intakeRoller = new CANTalon(7);
        LiveWindow.addActuator("Intake", "Roller", intakeRoller);
        
        intakeDoorElevator = new DoubleSolenoid(6, 5, 6);
        LiveWindow.addActuator("IntakeDoor", "Elevator", intakeDoorElevator);
        

        // Set the Gyro to return angle for the PID value (pidGet)
        driveTrainGyro.setPIDSourceType(PIDSourceType.kDisplacement);
    }
}
