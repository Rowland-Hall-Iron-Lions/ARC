package org.firstinspires.ftc.teamcode.environment.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import org.firstinspires.ftc.teamcode.environment.RobotEntity;


class RobotEntityTest {
    RobotEntity entity;

    @BeforeEach
    void setUp() {
        entity = new RobotEntity();
        entity.setUp();
    }

    @Test                                               
    @DisplayName("Constructor output should be sane")
    void constructorSanity() {
        assertEquals(entity.getX(), 0, "X should be 0");
        assertEquals(entity.getY(), 0, "Y should be 0");
        assertEquals(entity.getPastX(), 0, "past x should be 0");
        assertEquals(entity.getPastY(), 0, "past y should be 0");
    }
}

