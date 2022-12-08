// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.StartEndCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Pneumatics;
import frc.robot.subsystems.lifter;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer 
{
  // The robot's subsystems and commands are defined here...
   public Drivetrain m_drive = new Drivetrain();

   public Pneumatics m_sol = new Pneumatics(); 
   public lifter  m_lifter = new lifter();

   public Joystick leftStick = new Joystick(0);
   public Joystick rightStick = new Joystick(1); 
   public Joystick gamepad = new Joystick(2);




  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() 
  {
    // Configure the button bindings
    configureButtonBindings();

    m_drive.setDefaultCommand
    (
      new RunCommand
      (
        () -> m_drive.tankDrive(-leftStick.getY(), rightStick.getY()) 
      )
    ); 
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() 
  {
    //drivetrain
    //sol 
    new JoystickButton(rightStick, 1)
    .whenPressed(new StartEndCommand(() -> m_sol.toggle(), () -> m_sol.toggle(), m_sol));
    //lift motors
    new JoystickButton(gamepad, 3)//rightStick, 2)
    .whenHeld(new StartEndCommand(() -> m_lifter.climb_Up(.5), () -> m_lifter.climb_Up(0), m_lifter));

    new JoystickButton(gamepad, 6)
    .whenPressed(new InstantCommand(() -> m_lifter.toggleInvert()));
    //new JoystickButton(gamepad, 0)//leftStick, 2)//diff button ? 
    //.whenPressed(new StartEndCommand(() -> m_lifter.climb_Down(.5), () -> m_lifter.climb_Down(0), m_lifter));

    


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  //public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    //return m_autoCommand;
  //}
  }
}
