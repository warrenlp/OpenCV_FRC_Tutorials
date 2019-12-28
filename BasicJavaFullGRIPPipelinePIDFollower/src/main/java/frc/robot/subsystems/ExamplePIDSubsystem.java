/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;

/**
 * Add your docs here.
 */
public class ExamplePIDSubsystem extends PIDSubsystem {
  
  private static final int CAMERA_WIDTH = 160;
  private static final double P_CONST = 1/(CAMERA_WIDTH * 0.5); // Half of the camera frame width gives full speed to the motors.
  private static final double I_CONST = 0;
  private static final double D_CONST = 0;
  // private int m_output = 0;

  public ExamplePIDSubsystem() {
    // Intert a subsystem name and PID values here
    super("ExamplePIDSubsystem", P_CONST, I_CONST, D_CONST);
    // Use these to get going:
    setSetpoint(CAMERA_WIDTH * 0.5); // Sets the PID controller to target the middle of the frame.
    enable(); // Enables the PID controller. We want it running all of the time in this example.
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  @Override
  protected double returnPIDInput() {
    // Return your input value for the PID loop
    // e.g. a sensor, like a potentiometer:
    // yourPot.getAverageVoltage() / kYourMaxVoltage;

    // Change the default value to the set point which is the point at which the motors are told to do nothing.
    double x_val = CAMERA_WIDTH * 0.5;
    if (Robot.xEntry != null) {
      x_val = Robot.xEntry.getDouble(x_val);
    }

    return x_val;
  }

  @Override
  protected void usePIDOutput(double output) {
    // Use output to drive your system, like a motor
    // e.g. yourMotor.set(output);
    SmartDashboard.putNumber("Output to motors", output);
    System.out.println(output);
  }
}
