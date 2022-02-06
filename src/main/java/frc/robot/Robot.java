// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.AnalogPotentiometer;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This is a demo program showing the use of the DifferentialDrive class. Runs the motors with
 * arcade steering.
 */
public class Robot extends TimedRobot {
  
  private final WPI_TalonSRX R1 = new WPI_TalonSRX(1);
  private final WPI_TalonSRX R2 = new WPI_TalonSRX(2);
  
  MotorControllerGroup right = new MotorControllerGroup(R1, R2);

  private final WPI_TalonSRX L1 = new WPI_TalonSRX(3);
  private final WPI_TalonSRX L2 = new WPI_TalonSRX(4);

  MotorControllerGroup left = new MotorControllerGroup(L1, L2);

  private final DifferentialDrive m_robotDrive = new DifferentialDrive(left, right);
  private final Joystick stick = new Joystick(1);
  private final Joystick stick2 = new Joystick(2);

  @Override
  public void robotInit() {
    // We need to invert one side of the drivetrain so that positive voltages
    // result in both sides moving forward. Depending on how your robot's
    // gearbox is constructed, you might have to invert the left side instead.
    //m_rightMotor.setInverted(true);
    right.setInverted(true);
  }

  @Override
  public void teleopPeriodic() {
    // Drive with arcade drive.
    // That means that the Y axis drives forward
    // and backward, and the X turns left and right.
    
  //  m_robotDrive.arcadeDrive(stick2.getZ(), -stick.getY());
     m_robotDrive.tankDrive(-stick2.getY(), stick.getY());
  }
}
