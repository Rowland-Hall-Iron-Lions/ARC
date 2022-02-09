package org.firstinspires.ftc.teamcode;


import static com.qualcomm.robotcore.hardware.DcMotor.RunMode.RUN_WITHOUT_ENCODER;
import static com.qualcomm.robotcore.hardware.DcMotor.RunMode.STOP_AND_RESET_ENCODER;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous
public class TestTwo extends LinearOpMode {
    public void driveAndArm(double wCounts, double wheelRPower, double wheelLPower, double aCounts){
        int wheelCounts = 0;
        int armCounts = 0;
        int armPower = 20000;

        robot.frontL.setMode(STOP_AND_RESET_ENCODER);
        robot.frontR.setMode(STOP_AND_RESET_ENCODER);
        robot.backL.setMode(STOP_AND_RESET_ENCODER);
        robot.backR.setMode(STOP_AND_RESET_ENCODER);
        robot.arm.setMode(STOP_AND_RESET_ENCODER);

        robot.frontL.setMode(RUN_WITHOUT_ENCODER);
        robot.frontR.setMode(RUN_WITHOUT_ENCODER);
        robot.backL.setMode(RUN_WITHOUT_ENCODER);
        robot.backR.setMode(RUN_WITHOUT_ENCODER);
        robot.arm.setMode(RUN_WITHOUT_ENCODER);

        while((Math.abs(wheelCounts) < wCounts)||( Math.abs(armCounts) < aCounts)){
            wheelCounts = robot.frontL.getCurrentPosition();
            armCounts = robot.arm.getCurrentPosition();

            if(Math.abs(wheelCounts) < wCounts){
                robot.frontL.setPower(wheelLPower);
                robot.backL.setPower(wheelLPower);
                robot.frontR.setPower(wheelRPower);
                robot.backR.setPower(wheelRPower);

            }
            else {
                robot.frontL.setPower(0);
                robot.backL.setPower(0);
                robot.frontR.setPower(0);
                robot.backR.setPower(0);
            }

            if(Math.abs(armCounts) < aCounts){
                robot.arm.setPower(armPower);

            }
            else {
                robot.arm.setPower(0);
            }
        }

        robot.frontL.setPower(0);
        robot.backL.setPower(0);
        robot.frontR.setPower(0);
        robot.backR.setPower(0);
        robot.arm.setPower(0);
    }
    HWC robot = new HWC(hardwareMap, telemetry);

    @Override
    public void runOpMode() throws InterruptedException {
        waitForStart();
        driveAndArm(100, 5, 5, -9000);


    }


}
