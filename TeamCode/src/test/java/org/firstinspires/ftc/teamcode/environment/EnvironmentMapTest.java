package org.firstinspires.ftc.teamcode.environment.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import org.firstinspires.ftc.teamcode.environment.EnvironmentMap;
import org.firstinspires.ftc.teamcode.environment.GenericEntity;
import org.firstinspires.ftc.teamcode.environment.RobotEntity;
import org.firstinspires.ftc.teamcode.environment.Entity;

import java.util.ArrayList;

class EnvironmentMapTest {
    EnvironmentMap env_map = new EnvironmentMap();

    @BeforeEach
    void setUp() {
        this.env_map = new EnvironmentMap();
    }

    @Test
    @DisplayName("Single entity adding")
    void addSingleEntity() {
        this.env_map.addEntity(new GenericEntity());

        assertEquals(this.env_map.getAllEntities().size(), 1);
    }

    @Test
    @DisplayName("Multiple entities adding")
    void addEntities() {
        ArrayList<Entity> entities = new ArrayList<Entity>() {{
            add(new GenericEntity());
            add(new GenericEntity());
            add(new GenericEntity());
        }};
        
        this.env_map.addEntities(entities);

        assertEquals(this.env_map.getAllEntities().size(), 3);
    }

    @Test
    @DisplayName("Get non-active entities")
    void nonActiveEntities() {
        RobotEntity active = new RobotEntity(true);

        ArrayList<Entity> entities = new ArrayList<Entity>() {{
            add(new GenericEntity());
            add(new GenericEntity());
            add(active);
        }};

        this.env_map.addEntities(entities);

        assertEquals(this.env_map.getAllOtherEntities().size(), 2);
    }

    @Test
    @DisplayName("Overwrite all entities")
    void overwriteAllEnties() {
        ArrayList<Entity> entities = new ArrayList<Entity>() {{
            add(new GenericEntity());
            add(new GenericEntity());
            add(new GenericEntity());
            add(new GenericEntity());
        }};

        this.env_map.setAllEntities(entities);

        assertEquals(this.env_map.getAllEntities().size(), 4);

        entities = new ArrayList<Entity>() {{
            add(new GenericEntity());
            add(new GenericEntity());
        }};

        this.env_map.setAllEntities(entities);

        assertEquals(this.env_map.getAllEntities().size(), 2);
    }

    @Test
    @DisplayName("Get active robot")
    void activeRobot() {
        RobotEntity active = new RobotEntity(true);

        ArrayList<Entity> entities = new ArrayList<Entity>() {{
            add(new GenericEntity());
            add(new GenericEntity());
            add(active);
        }};

        this.env_map.setAllEntities(entities);

        try {
            this.env_map.getActiveRobot();
        } catch (Exception e) {
            assertEquals(0, 1);
        }

        entities = new ArrayList<Entity>();

        this.env_map.setAllEntities(entities);
        
        try {
            this.env_map.getActiveRobot();
            assertEquals(0, 1);
        } catch (Exception e) {
            // Do nothing
        }
    }
}

