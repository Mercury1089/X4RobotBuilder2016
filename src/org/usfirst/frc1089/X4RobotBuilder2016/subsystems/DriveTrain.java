// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc1089.X4RobotBuilder2016.subsystems;

import org.usfirst.frc1089.X4RobotBuilder2016.RobotMap;
import org.usfirst.frc1089.X4RobotBuilder2016.commands.*;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 *
 */
public class DriveTrain extends PIDSubsystem {

    private final AnalogGyro gyro = RobotMap.driveTrainGyro;
    private final CANTalon leftBack = RobotMap.driveTrainLeftBack;
    private final CANTalon rightBack = RobotMap.driveTrainRightBack;
    private final CANTalon leftFront = RobotMap.driveTrainLeftFront;
    private final CANTalon rightFront = RobotMap.driveTrainRightFront;
    private final RobotDrive robotDrive = RobotMap.driveTrainRobotDrive;

    // Initialize your subsystem here
    public DriveTrain() {
        super("DriveTrain", 0.1, 0.0, 0.0);
        setAbsoluteTolerance(0.2);
        getPIDController().setContinuous(true);
        LiveWindow.addActuator("DriveTrain", "PIDSubsystem Controller", getPIDController());
        getPIDController().setInputRange(0.0, 360.0);

        // Enable brake mode on all Talons
		leftFront.enableBrakeMode(true);
		rightFront.enableBrakeMode(true);
		leftBack.enableBrakeMode(true);
		rightBack.enableBrakeMode(true);
		leftFront.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		rightFront.setFeedbackDevice(FeedbackDevice.QuadEncoder);
		// Configure back talons as followers.
		leftBack.changeControlMode(CANTalon.TalonControlMode.Follower);
		rightBack.changeControlMode(CANTalon.TalonControlMode.Follower);
		leftBack.set(leftFront.getDeviceID());
		rightBack.set(rightFront.getDeviceID());
    }

    public void initDefaultCommand() {
        setDefaultCommand(new DriveWithJoysticks());
    }

    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
        return gyro.pidGet();
    }

    protected void usePIDOutput(double output) {
    	// Removed the autogenerated code comments.
    	leftFront.pidWrite(output);
    	rightFront.pidWrite(output);
    }
    
    public void tankDrive(Joystick leftStick, Joystick rightStick) {
    	robotDrive.tankDrive(leftStick, rightStick);
    }
    
    public void stop() {
    	robotDrive.tankDrive(0, 0);
    }
}
