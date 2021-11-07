public class RobotEntity implements Entity {
    EntityType type;
    boolean active;
    int x;
    
    public boolean isActive() {
        return active;
    }

    public EntityType getType() {
        return type;
    }
}

