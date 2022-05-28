// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PneumaticHub;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.ctre.phoenix.led.*;
import com.ctre.phoenix.led.ColorFlowAnimation.Direction;
/**
 * This is a demo program showing the use of the DifferentialDrive class. Runs the motors with
 * arcade steering.
 */
public class Robot extends TimedRobot {
  
  private final WPI_TalonSRX R1 = new WPI_TalonSRX(4);
  private final WPI_TalonSRX R2 = new WPI_TalonSRX(2);
  
  MotorControllerGroup right = new MotorControllerGroup(R1, R2);

  private final WPI_TalonSRX L1 = new WPI_TalonSRX(1);
  private final WPI_TalonSRX L2 = new WPI_TalonSRX(3);

  MotorControllerGroup left = new MotorControllerGroup(L1, L2);

  private final DifferentialDrive m_robotDrive = new DifferentialDrive(left, right);
  private final Joystick stick = new Joystick(0);
  private final Joystick stick2 = new Joystick(1);

  // private final PneumaticHub p = new PneumaticHub(62);
  // private final DoubleSolenoid d = p.makeDoubleSolenoid (8,9);
  // private final DoubleSolenoid dSolenoid2 = p.makeDoubleSolenoid (10,11);

  private DoubleSolenoid.Value state = DoubleSolenoid.Value.kReverse;
  //private final Compressor compress = new Compressor(PneumaticsModuleType.REVPH);
  //private final Compressor phCompressor = new Compressor(1, PneumaticsModuleType.REVPH);

  // private final CANdle candle = new CANdle (0);
  private final RainbowAnimation r = new RainbowAnimation(1,1,140);
  private final FireAnimation f = new FireAnimation(1,1,8,.2,.4);
  private final RgbFadeAnimation fa = new RgbFadeAnimation (1,.7,8);
  private final StrobeAnimation s = new StrobeAnimation (100,200,8, 255, 1, 9);
  private final ColorFlowAnimation c = new ColorFlowAnimation(100,200,8, 255, 1, 8, Direction.Backward);
  Timer m_timer = new Timer();
  @Override
  public void robotInit() {
    // We need to invert one side of the drivetrain so that positive voltages
    // result in both sides moving forward. Depending on how your robot's
    // gearbox is constructed, you might have to invert the left side instead.
    //m_rightMotor.setInverted(true);
  
  
      right.setInverted(true);
    //candle.setLEDs (0,250,0);
  }

  
  @Override
  public void autonomousInit() {
      super.autonomousInit();
     // candle.setLEDs (0,0,0);
      m_timer.reset();
      m_timer.start();
  }
     @Override
     public void autonomousPeriodic() {
         super.autonomousPeriodic();
         /*candle.setLEDs (255,0,0);
         if(m_timer.get() < 15){
          candle.setLEDs (0,255,0);
         }
         else if(m_timer.get() < 30){
          candle.setLEDs (0,0,255);
         }
         else{
         // candle.setLEDs (0,255,255);*/
         // candle.animate(c);
         }
     
  @Override
  public void teleopPeriodic() {
    // candle.setLEDs(0, 255, 0);
    // Drive with arcade drive.
    // That means that the Y axis drives forward
    // and backward, and the X turns left and right.
    //compress.enableDigital();
    
    //compress.enableDigital();
   
    // p.reserveCompressor();
    if(stick2.getTriggerPressed()){
      // candle.setLEDs (255,204,0);
     if(state == DoubleSolenoid.Value.kReverse){
      state = DoubleSolenoid.Value.kForward;
      // d.set(state);
      // dSolenoid2.set(state);
     }
     else{
      state = DoubleSolenoid.Value.kReverse;
      // d.set(state);
      // dSolenoid2.set(state);
      
     }
    }
    else if(stick.getTrigger()){
      // candle.animate(r);
     // d.set(DoubleSolenoid.Value.kReverse);
    }
   
    else{//candle.setLEDs (100,100,200);
    }
    m_robotDrive.arcadeDrive(stick.getY(),stick2.getZ());

  

     //m_robotDrive.tankDrive(-stick2.getY(), stick.getY());
  }

  @Override
  public void disabledInit() {
      super.disabledInit();
      // candle.setLEDs(255,0,0);
  }
  @Override
  public void disabledExit() {
    super.disabledExit();
    // candle.setLEDs(0,255,0);
  }
}
