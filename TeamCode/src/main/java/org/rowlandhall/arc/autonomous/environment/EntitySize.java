package org.rowlandhall.arc.autonomous.environment;

import org.rowlandhall.arc.logging.Logging;

/**
 * The sizes of all the entities we can detect. Measures in cm.
 */
class EntitySize {
    /**
     * Height of the image. 8.5" = 21.59 cm
     */
    final static double IMAGE_HEIGHT = 21.59;

    /**
     * Width of the image. 11" = 27.94 cm.
     */
    final static double IMAGE_WIDTH = 27.94;

    public static Pair getDimentionsFromType(EntityType type) {
        switch (type.getValue()) {
            case 2:
                Pair ret = new Pair(IMAGE_WIDTH, IMAGE_HEIGHT);

                return ret;
        }

        Logging.error("Invalid entity type in getDimentionsFromType(), returning null.");

        return null;
    }
}

