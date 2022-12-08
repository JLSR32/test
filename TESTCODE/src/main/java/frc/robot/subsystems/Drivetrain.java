// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class Drivetrain extends SubsystemBase {
  /** Creates a new Drivetrain. */
  private CANSparkMax frontL;
  private CANSparkMax frontR;
  private CANSparkMax backL;
  private CANSparkMax backR;

  private MotorControllerGroup left,right;

  private DifferentialDrive drivetrain; 

  public Drivetrain() 
  {
    frontL = new CANSparkMax(Constants.FRONTL, MotorType.kBrushless); 
    frontR = new CANSparkMax(Constants.FRONTR, MotorType.kBrushless);
    backL = new CANSparkMax(Constants.BACKL, MotorType.kBrushless); 
    backR = new CANSparkMax(Constants.BACKR, MotorType.kBrushless); 

    left = new MotorControllerGroup(frontL, backL);
    right = new MotorControllerGroup(frontR, backR); 

    drivetrain = new DifferentialDrive(left,right);
  }

  @Override
  public void periodic() 
  {
    // This method will be called once per scheduler run
  }

  public void tankDrive(double leftSpeed, double rightSpeed)
  {
    drivetrain.tankDrive(leftSpeed,rightSpeed); 
  }


}
