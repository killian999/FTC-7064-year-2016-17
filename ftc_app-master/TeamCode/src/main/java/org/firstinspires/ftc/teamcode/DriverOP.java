package org.firstinspires.ftc.teamcode;

/**
 * Created by killi on 10/11/2016.
 */

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;


@TeleOp(name="DriverOP", group="OneTap")
public class DriverOP extends OpMode{
    DcMotor motorRight;
    DcMotor motorLeft;


    @Override
    public void init()
    {
        motorRight = hardwareMap.dcMotor.get("motor_2");
        motorLeft = hardwareMap.dcMotor.get("motor_1");
        motorLeft.setDirection(DcMotor.Direction.REVERSE);
    }
    @Override
    public void loop()
    {
        float Primary = -gamepad1.left_stick_y;
        float Secondary = -gamepad1.left_stick_x;
        Secondary = Range.clip(Secondary, -1, 1);
        Primary = Range.clip(Primary, -1, 1);
        Secondary = (float)scaleInput(Secondary);
        Primary = (float)scaleInput(Primary);

        //Forwards
        if((gamepad1.left_stick_y>0 && gamepad1.left_stick_x>0)&&gamepad1.left_stick_y>gamepad1.left_stick_x)
        {
            Secondary = Primary-Secondary;
            while((gamepad1.left_stick_y>0 && gamepad1.left_stick_x<0)&&gamepad1.left_stick_y>gamepad1.left_stick_x)
            {
                motorRight.setPower(Primary);
                motorLeft.setPower(Secondary);
            }
        }
        if((gamepad1.left_stick_y>0 && gamepad1.left_stick_x<0)&&gamepad1.left_stick_y>gamepad1.left_stick_x)
        {
            Secondary = Primary+Secondary;
            while((gamepad1.left_stick_y>0 && gamepad1.left_stick_x<0)&&gamepad1.left_stick_y>gamepad1.left_stick_x)
            {
                motorRight.setPower(Secondary);
                motorLeft.setPower(Primary);
            }
        }

        //Backwards
        if((gamepad1.left_stick_y<0 && gamepad1.left_stick_x>0)&&gamepad1.left_stick_y>gamepad1.left_stick_x)
        {
            Secondary = Primary+Secondary;
            while((gamepad1.left_stick_y<0 && gamepad1.left_stick_x>0)&&gamepad1.left_stick_y>gamepad1.left_stick_x)
            {
                motorRight.setPower(Primary);
                motorLeft.setPower(Secondary);
            }
        }
        if((gamepad1.left_stick_y<0 && gamepad1.left_stick_x<0)&&gamepad1.left_stick_y>gamepad1.left_stick_x)
        {
            Secondary = Primary-Secondary;
            while((gamepad1.left_stick_y<0 && gamepad1.left_stick_x<0)&&gamepad1.left_stick_y>gamepad1.left_stick_x)
            {
                motorRight.setPower(Secondary);
                motorLeft.setPower(Primary);
            }
        }

        //Turning
        if((gamepad1.left_stick_y>0 && gamepad1.left_stick_x>0)&&gamepad1.left_stick_y<gamepad1.left_stick_x)
        {
            Primary = Secondary-Primary;
            while((gamepad1.left_stick_y>0 && gamepad1.left_stick_x>0)&&gamepad1.left_stick_y<gamepad1.left_stick_x)
            {
                motorRight.setPower(Secondary);
                motorLeft.setPower(-Primary);
            }
        }
        if((gamepad1.left_stick_y>0 && gamepad1.left_stick_x<0)&&gamepad1.left_stick_y<gamepad1.left_stick_x)
        {
            Primary = Secondary+Primary;
            while((gamepad1.left_stick_y>0 && gamepad1.left_stick_x<0)&&gamepad1.left_stick_y<gamepad1.left_stick_x)
            {
                motorRight.setPower(-Primary);
                motorLeft.setPower(Secondary);
            }
        }
        if((gamepad1.left_stick_y<0 && gamepad1.left_stick_x>0)&&gamepad1.left_stick_y<gamepad1.left_stick_x)
        {
            Primary = Secondary+Primary;
            while((gamepad1.left_stick_y>0 && gamepad1.left_stick_x>0)&&gamepad1.left_stick_y<gamepad1.left_stick_x)
            {
                motorRight.setPower(Secondary);
                motorLeft.setPower(-Primary);
            }
        }
        if((gamepad1.left_stick_y<0 && gamepad1.left_stick_x<0)&&gamepad1.left_stick_y<gamepad1.left_stick_x)
        {
            Primary = Secondary-Primary;
            while((gamepad1.left_stick_y<0 && gamepad1.left_stick_x<0)&&gamepad1.left_stick_y<gamepad1.left_stick_x)
            {
                motorRight.setPower(-Primary);
                motorLeft.setPower(Secondary);
            }
        }

        motorRight.setPower(0);
        motorLeft.setPower(0);

    }
    @Override
    public void stop()
    {

    }
    double scaleInput(double dVal)  {
        double[] scaleArray = { 0.0, 0.05, 0.09, 0.10, 0.12, 0.15, 0.18, 0.24,
                0.30, 0.36, 0.43, 0.50, 0.60, 0.72, 0.85, 1.00, 1.00 };

        // get the corresponding index for the scaleInput array.
        int index = (int) (dVal * 16.0);

        // index should be positive.
        if (index < 0) {
            index = -index;
        }

        // index cannot exceed size of array minus 1.
        if (index > 16) {
            index = 16;
        }

        // get value from the array.
        double dScale = 0.0;
        if (dVal < 0) {
            dScale = -scaleArray[index];
        } else {
            dScale = scaleArray[index];
        }

        // return scaled value.
        return dScale;
    }
}
