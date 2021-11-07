package org.firstinspires.ftc.teamcode.environment;

import java.util.ArrayList;

import org.firstinspires.ftc.teamcode.environment.NoActiveEntityException;
import org.firstinspires.ftc.teamcode.environment.Entity;
import org.firstinspires.ftc.teamcode.environment.EntityType;
import org.firstinspires.ftc.teamcode.environment.RobotEntity;

/** A wrapper for a list of entities. Provides a useful API for code abstraction, along
 * wth making the code easier for less advanced developers. */
public class EnvironmentMap {
    /** The entities that we know about, */
    ArrayList<Entity> entities = new ArrayList<Entity>();

    /** The millis since the unix epoch that this class was last updated. */
    long last_time_since_epoch;

    /** Constructor for the environment map. Takes no arguments, as these
     * should be loaded and unloaded dynamically at runtime. */
    public void EnvironmentMap() {
        this.last_time_since_epoch = System.currentTimeMillis();
    }

    public long getTimestampSinceLastUpdate() {
        return this.last_time_since_epoch;
    }

    /** Gets all the entities, regardless of type. */
    public ArrayList<Entity> getAllEntities() {
        return this.entities;
    }

    /** Gets all the entities that are not active (e.g us). */
    public ArrayList<Entity> getAllOtherEntities() {
        ArrayList<Entity> ret = new ArrayList<Entity>();

        for (Entity e : entities) {
            // We could technically just return from inside this conditional,
            // but this is more readable, and will just get optimised out anyways.
            if ((e.getType().equals(EntityType.ROBOT)) && ((RobotEntity)e).isActive()) {
                continue;
            }

            ret.add(e);
        }
        
        return ret;
    }

    /** Returns that entity that is active (e.g the entity that is "us").
     * A wrapper around get_entities_with_type, for readability. Throws
     * NoActiveEntityException if there is no active entity. This is unlikely,
     * but should still be handled. Will return the first element it finds,
     * but only one entity should be active at any given time, so this should
     * be fine. */
    public RobotEntity getActiveRobot() throws NoActiveEntityException {
        for (Entity e : entities) {
            if ((e.getType().equals(EntityType.ROBOT)) && ((RobotEntity)e).isActive()) {
                return (RobotEntity) e;
            }
        }

        throw new NoActiveEntityException();
    }

    /** Returns all the entities with a specific type. */
    public ArrayList<Entity> getEntitiesWithType(Entity type) {
        ArrayList<Entity> ret = new ArrayList();
        for (Entity e : entities) {
            if (e.getType().equals(type)) {
                ret.add(e);
            }
        }

        return ret;
    }

    /** Add an entity to track. */
    public void addEntity(Entity entity) {
        this.entities.add(entity);
    }

    /** Add multiple entities at a time. This shouldn't really ever be called,
     * but we could take a route that would use this. */
    public void addEntities(ArrayList<Entity> entities) {
        for (Entity entity : entities) {
            this.addEntity(entity);
        }
    }

    /** Sets all the enties; doesn't append. */
    public void setAllEntities(ArrayList<Entity> new_entities) {
        entities = new_entities;
    }
}

