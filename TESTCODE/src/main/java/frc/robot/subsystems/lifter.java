// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class lifter extends SubsystemBase {
  /** Creates a new lifter. */
  private CANSparkMax liftL;
  private CANSparkMax liftR;

  private Spark UP; 
  private boolean inverted = false; 

  private MotorControllerGroup pull;

  public lifter() 
  {
    //liftL = new CANSparkMax(Constants.LEFTLIFT, MotorType.kBrushless);
    //liftR = new CANSparkMax(Constants.RIGHTLIFT, MotorType.kBrushless); 
  
    //pull = new MotorControllerGroup(liftL, liftR);

    UP = new Spark(Constants.SPARKUP);
  }


  public void climb_Up(double speed)
  {
    //this.pull.set(speed);
    this.UP.set(speed);
  }

  public void climb_Down(double speed)
  {
    //this.pull.set(speed); 
    this.UP.set(speed);
  }    

  public void toggleInvert()
  {
    if(!inverted)
    {
      UP.setInverted(true);
      inverted = true;
    }
    else 
    {
      UP.setInverted(false);
      inverted = false; 
    }
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
