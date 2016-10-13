package org.firstinspires.ftc.teamcode;

import android.graphics.Color;

import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cGyro;
import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cRangeSensor;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

import java.util.Arrays;

@Autonomous(name="Autonomous OpMode", group="NewCode")
public class AutoOP extends LinearOpMode {
    DcMotor left1, right1;
    int MD = 1120;
    @Override
    public void runOpMode() throws InterruptedException {

        // get a reference to our compass

        left1 = hardwareMap.dcMotor.get("Motor_1"); // AL00XR4D.1
        right1 = hardwareMap.dcMotor.get("Motor_2");// AL00XR4D.2
        left1.setDirection(DcMotor.Direction.REVERSE);
        left1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        right1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);



        waitForStart();
        Drive_foward(2, 1.00);
        Drive_right(1,1.00);
        Drive_foward(2, 1.00);
        Drive_right(1,1.00);
        Drive_foward(2, 1.00);
        Drive_right(1,1.00);
        Drive_foward(2, 1.00);
        Drive_right(1,1.00);



    }
        public void Drive_foward (int distance, double power){
            left1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            right1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

            left1.setTargetPosition(distance*MD);
            right1.setTargetPosition(distance*MD);

            left1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            right1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            drive(power);

            while (right1.isBusy() && left1.isBusy()) {
            }
            drive(0);
        }

        public void drive(double power){
            left1.setPower(power);
            right1.setPower(power);

        }
    public void Drive_right (int distance, double power){
        left1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        right1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        left1.setTargetPosition(distance*MD);
        right1.setTargetPosition(distance*MD);

        left1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        right1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        drive(power);

        while (right1.isBusy() && left1.isBusy()) {
        }
        drive(0);
    }

    public void turnRight(double power){
        left1.setPower(power);
        right1.setPower(-power);

    }
    public void Drive_left (int distance, double power){
        left1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        right1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        left1.setTargetPosition(distance*MD);
        right1.setTargetPosition(distance*MD);

        left1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        right1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        drive(power);

        while (right1.isBusy() && left1.isBusy()) {
        }
        drive(0);
    }

    public void turnLeft(double power){
        left1.setPower(-power);
        right1.setPower(power);

    }

    //resets encoders
}