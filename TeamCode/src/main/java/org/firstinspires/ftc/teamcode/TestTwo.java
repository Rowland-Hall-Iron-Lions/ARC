package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

@TeleOp
public class TestTwo extends LinearOpMode {
    public static double encoderMethod(double distance){
//      384.5(PPM) = ~50cm = ~20in
//      7.9(PPM) = 1cm
        double ppm = distance * 7.9;

        return ppm;
    }

    @Override
    public void runOpMode() throws InterruptedException {
        telemetry.addData("Status", "Initializing");
        telemetry.update();

        DcMotor duckWheel = hardwareMap.get(DcMotor.class, "duckWheel");
        DcMotorEx frontL  = hardwareMap.get(DcMotorEx.class, "leftFront");
        DcMotorEx frontR = hardwareMap.get(DcMotorEx.class, "rightFront");
        DcMotorEx backL  = hardwareMap.get(DcMotorEx.class, "leftRear");
        DcMotorEx backR = hardwareMap.get(DcMotorEx.class, "rightRear");
//      DcMotor intakeL = hardwareMap.get(CRServo.class, "intakeL");
//      DcMotor intakeR = hardwareMap.get(CRServo.class, "intakeR");
        DcMotorEx extender = hardwareMap.get(DcMotorEx.class, "extender");
        DcMotorEx arm = hardwareMap.get(DcMotorEx.class, "arm");

        // Reset Encoder
        frontL.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        frontR.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        backL.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        backR.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);


        /* Sets the motors to run using encoders. */

        /* Most robots need the motor on one side to be reversed to drive forward.
         * Reverse the motor that runs backwards when connected directly to the battery. */
        frontL.setDirection(DcMotorEx.Direction.FORWARD);
        backL.setDirection(DcMotorEx.Direction.FORWARD);
        frontR.setDirection(DcMotorEx.Direction.REVERSE);
        backR.setDirection(DcMotorEx.Direction.REVERSE);
//      intakeL.setDirection(CRServo.Direction.REVERSE);
//      CRServo intakeR.setDirection(CRServo.Direction.FORWARD);
//      DcMotor duckWheel.setDirection(DcMotorSimple.Direction.REVERSE);
//      Full revolution 384.5(PPR) = ~50cm = ~20in

        int power = 100;
        double distance = 0.0;


        waitForStart();
        while(!gamepad1.left_bumper) {
            while (!gamepad1.right_bumper) {
                sleep(100);
                if (gamepad1.a) {
                    power += 10;

                }
                if (gamepad1.b) {
                    power -= 10;

                }
                if (gamepad1.x) {
                    distance += 50;

                }
                if (gamepad1.y) {
                    distance -= 50;

                }
                telemetry.addData("Target Position: ", distance);
                telemetry.addData("Power: ", power);
                telemetry.update();
            }
//      Run While the Autonomous Mode is Active


//      Update telemetry status to show that it is running
        telemetry.addData("Status", "Running");
        telemetry.update();

        frontL.setTargetPosition((int) encoderMethod(distance));
        frontR.setTargetPosition((int) encoderMethod(distance));
        backL.setTargetPosition((int) encoderMethod(distance));
        backR.setTargetPosition((int) encoderMethod(distance));

        frontL.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        frontR.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        backL.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        backR.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);

        frontL.setVelocity(power);
        frontR.setVelocity(power);
        backL.setVelocity(power);
        backR.setVelocity(power);



        while (frontL.isBusy() || frontR.isBusy() || backL.isBusy() || backR.isBusy()) {
            telemetry.addData("Status", "Waiting for Motors");
            telemetry.addData("Motors", "frontL Position: %d", frontL.getCurrentPosition());
            telemetry.addData("Motors", "frontR Position: %d", frontR.getCurrentPosition());
            telemetry.addData("Motors", "backL Position: %d", backL.getCurrentPosition());
            telemetry.addData("Motors", "backR Position: %d", backR.getCurrentPosition());
            telemetry.update();
        }
//      Stop the Autonomous Mode after we finish parking
        }
    }
}
