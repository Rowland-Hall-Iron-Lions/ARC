package org.firstinspires.ftc.teamcode;

import static com.qualcomm.robotcore.hardware.DcMotor.RunMode.RUN_TO_POSITION;
import static com.qualcomm.robotcore.hardware.DcMotor.RunMode.RUN_WITHOUT_ENCODER;
import static com.qualcomm.robotcore.hardware.DcMotor.RunMode.STOP_AND_RESET_ENCODER;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DistanceSensor;

@Autonomous
public class Auto_BlueWarehouse extends LinearOpMode {
    DcMotorEx frontL, frontR, backL, backR, duckWheel, arm = null;
    DcMotor extender;
    DistanceSensor dSensor;
    CRServo intakeL, intakeR = null;

    boolean readingDuck = true;
    final double oneCmInPPR = 7.9;
    final double armVelocity = 20000;

    public void drive(double directionInDegrees, double distanceInCm, double wheelVelocity){
//      384.5(PPR) = ~50cm = ~20in
//      7.9(PPR) = 1cm
//        4.27(PPR) = 1 Degree
        final double oneDegreeInPPR = 4.27;
        double pprForward = distanceInCm * oneCmInPPR;
        double pprTurn = directionInDegrees * oneDegreeInPPR;


        if(directionInDegrees != 0) {
            if (directionInDegrees < 0) {
                frontL.setTargetPosition(-(int) pprTurn + frontL.getCurrentPosition());
                frontR.setTargetPosition((int) pprTurn + frontR.getCurrentPosition());
                backL.setTargetPosition(-(int) pprTurn + backL.getCurrentPosition());
                backR.setTargetPosition((int) pprTurn + backR.getCurrentPosition());

            } else if (directionInDegrees > 0) {
                frontL.setTargetPosition((int) pprTurn + frontL.getCurrentPosition());
                frontR.setTargetPosition(-(int) pprTurn + frontR.getCurrentPosition());
                backL.setTargetPosition((int) pprTurn + backL.getCurrentPosition());
                backR.setTargetPosition(-(int) pprTurn + backR.getCurrentPosition());
            }

            frontL.setMode(RUN_TO_POSITION);
            frontR.setMode(RUN_TO_POSITION);
            backL.setMode(RUN_TO_POSITION);
            backR.setMode(RUN_TO_POSITION);

            frontL.setVelocity(wheelVelocity);
            frontR.setVelocity(wheelVelocity);
            backR.setVelocity(wheelVelocity);
            backL.setVelocity(wheelVelocity);

            while (frontL.isBusy() || frontR.isBusy() || backL.isBusy() || backR.isBusy()) {
                telemetry.addData("Status", "Waiting for Motors to Finish Turning");
                telemetry.addData("Motors", "frontL Position: %d, %d", frontL.getCurrentPosition(), frontL.getTargetPosition());
                telemetry.addData("Motors", "frontR Position: %d, %d", frontR.getCurrentPosition(), frontR.getTargetPosition());
                telemetry.addData("Motors", "backL Position: %d, %d", backL.getCurrentPosition(), backL.getTargetPosition());
                telemetry.addData("Motors", "backR Position: %d, %d", backR.getCurrentPosition(), backR.getTargetPosition());
                telemetry.update();
            }
        }

        if(distanceInCm != 0) {
            frontL.setTargetPosition((int) pprForward + frontL.getCurrentPosition());
            frontR.setTargetPosition((int) pprForward + frontR.getCurrentPosition());
            backL.setTargetPosition((int) pprForward + backL.getCurrentPosition());
            backR.setTargetPosition((int) pprForward + backR.getCurrentPosition());

            frontL.setMode(RUN_TO_POSITION);
            frontR.setMode(RUN_TO_POSITION);
            backL.setMode(RUN_TO_POSITION);
            backR.setMode(RUN_TO_POSITION);

            frontL.setVelocity(wheelVelocity);
            frontR.setVelocity(wheelVelocity);
            backR.setVelocity(wheelVelocity);
            backL.setVelocity(wheelVelocity);

            while (frontL.isBusy() || frontR.isBusy() || backL.isBusy() || backR.isBusy()) {
                telemetry.addData("Status", "Waiting for Motors to Finish Moving");
                telemetry.addData("Motors", "frontL Position: %d, %d", frontL.getCurrentPosition(), frontL.getTargetPosition());
                telemetry.addData("Motors", "frontR Position: %d, %d", frontR.getCurrentPosition(), frontR.getTargetPosition());
                telemetry.addData("Motors", "backL Position: %d, %d", backL.getCurrentPosition(), backL.getTargetPosition());
                telemetry.addData("Motors", "backR Position: %d, %d", backR.getCurrentPosition(), backR.getTargetPosition());
                telemetry.update();
            }
        }
    }

    public void armTopLayer(){
        double extenderPower = 0.5;

        arm.setTargetPosition(-9000);
        arm.setMode(RUN_TO_POSITION);
        arm.setVelocity(armVelocity);
        while (arm.isBusy()) {
            telemetry.addData("Status", "Waiting for Motors to Finish Turning");
            telemetry.addData("Motors", "Arm Position: %d, %d", arm.getCurrentPosition(), arm.getTargetPosition());
            telemetry.update();
        }

        extender.setPower(extenderPower);
        sleep(1200);
        extender.setPower(0);

        intakeR.setPower(1);
        intakeL.setPower(1);
    }

    public void armReset(){
        sleep(1200);
        intakeR.setPower(0);
        intakeL.setPower(0);
        extender.setPower(-0.6);
        sleep(500);
        extender.setPower(-0.2);
        sleep(500);
        extender.setPower(0);
        arm.setTargetPosition(0);
        arm.setMode(RUN_TO_POSITION);
        arm.setVelocity(armVelocity);
        while (arm.isBusy()) {
            telemetry.addData("Status", "Waiting for Motors to Finish Turning");
            telemetry.addData("Motors", "Arm Position: %d, %d", arm.getCurrentPosition(), arm.getTargetPosition());
            telemetry.update();
        }
    }

    public void driveAndArm(double wCounts, double wheelRPower, double wheelLPower, double aCounts){
        int wheelCounts = 0;
        int armCounts = 0;
        int armPower = 1;

        frontL.setMode(STOP_AND_RESET_ENCODER);
        frontR.setMode(STOP_AND_RESET_ENCODER);
        backL.setMode(STOP_AND_RESET_ENCODER);
        backR.setMode(STOP_AND_RESET_ENCODER);
        arm.setMode(STOP_AND_RESET_ENCODER);

        frontL.setMode(RUN_WITHOUT_ENCODER);
        frontR.setMode(RUN_WITHOUT_ENCODER);
        backL.setMode(RUN_WITHOUT_ENCODER);
        backR.setMode(RUN_WITHOUT_ENCODER);
        arm.setMode(RUN_WITHOUT_ENCODER);

        while((Math.abs(wheelCounts) < wCounts)||( Math.abs(armCounts) < aCounts)){
            wheelCounts = frontL.getCurrentPosition();
            armCounts = arm.getCurrentPosition();

            if(Math.abs(wheelCounts) < wCounts){
                frontL.setPower(wheelLPower);
                backL.setPower(wheelLPower);
                frontR.setPower(wheelRPower);
                backR.setPower(wheelRPower);

            }
            else {
                frontL.setPower(0);
                backL.setPower(0);
                frontR.setPower(0);
                backR.setPower(0);
            }

            if(Math.abs(armCounts) < aCounts){
                arm.setPower(-1);

            }
            else {
                arm.setPower(0);
            }
        }

        frontL.setPower(0);
        backL.setPower(0);
        frontR.setPower(0);
        backR.setPower(0);
        arm.setPower(0);
    }
//
//    public void armMiddleLayer(){
//        arm.setTargetPosition(-12000);
//        arm.setMode(RUN_TO_POSITION);
//        arm.setVelocity(armVelocity);
//        while (arm.isBusy()) {
//            telemetry.addData("Status", "Waiting for Motors to Finish Turning");
//            telemetry.addData("Motors", "Arm Position: %d, %d", arm.getCurrentPosition(), arm.getTargetPosition());
//            telemetry.update();
//        }
//    }
//
//    public void armBottomLayer(){
//        arm.setTargetPosition(-7486);
//        arm.setMode(RUN_TO_POSITION);
//        arm.setVelocity(armVelocity);
//        while (arm.isBusy()) {
//            telemetry.addData("Status", "Waiting for Motors to Finish Turning");
//            telemetry.addData("Motors", "Arm Position: %d, %d", arm.getCurrentPosition(), arm.getTargetPosition());
//            telemetry.update();
//        }
//    }

//    public void findDuck(){
//
//        double cmToDucky = 0.0;
//        final double distanceToShippingHubPPR = 5.0;
//
//        while(readingDuck){
//            drive(2, 0);
//            if(dSensor.getDistance(DistanceUnit.INCH) <= 40){
//                cmToDucky = frontL.getCurrentPosition() / oneCmInPPR;
//                readingDuck = false;
//            }
//        }
//    }

    @Override
    public void runOpMode() throws InterruptedException {
        telemetry.addData("Status", "Initializing");
        telemetry.update();

        duckWheel = hardwareMap.get(DcMotorEx.class, "duckWheel");
        frontL  = hardwareMap.get(DcMotorEx.class, "leftFront");
        frontR = hardwareMap.get(DcMotorEx.class, "rightFront");
        backL  = hardwareMap.get(DcMotorEx.class, "leftRear");
        backR = hardwareMap.get(DcMotorEx.class, "rightRear");
        extender = hardwareMap.get(DcMotor.class, "extender");
        arm = hardwareMap.get(DcMotorEx.class, "arm");
        intakeL = hardwareMap.get(CRServo.class, "intakeL");
        intakeR = hardwareMap.get(CRServo.class, "intakeR");
//        dSensor = hardwareMap.get(DistanceSensor.class, "dSensor");

        // Reset Encoder
        frontL.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        frontR.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        backL.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        backR.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        arm.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        extender.setMode(RUN_WITHOUT_ENCODER);

        frontL.setDirection(DcMotorEx.Direction.FORWARD);
        backL.setDirection(DcMotorEx.Direction.FORWARD);
        frontR.setDirection(DcMotorEx.Direction.REVERSE);
        backR.setDirection(DcMotorEx.Direction.REVERSE);
        extender.setDirection(DcMotorEx.Direction.REVERSE);
        arm.setDirection(DcMotorEx.Direction.FORWARD);
        intakeL.setDirection(CRServo.Direction.REVERSE);
        intakeR.setDirection(CRServo.Direction.FORWARD);

        waitForStart();

//        drive(0, 66, 500);
//        drive(280, 0, 500);
//        drive(0, 30, 500);
//        armTopLayer();
//        armReset();
//        sleep(500);
//        drive(0, -25, 500);
//        drive(250, 0, 500);
//        sleep(500);
//        drive(0, 175, 1200);

        driveAndArm(100, 5, 5, 9000);
    }
}

