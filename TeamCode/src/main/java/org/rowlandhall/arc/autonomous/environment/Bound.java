package org.rowlandhall.arc.autonomous.environment;

import org.rowlandhall.arc.logging.Logging;

class Bound {
    /**
     * Gets the factor that the detection should be multiplied by.
     * @param type The type that we are trying to get the factor of.
     * @param x The x coordinate of the upper left.
     * @param y The y coordinate of the upper left.
     * @param w The x coordinate of the lower right.
     * @param h The y coordinate of the lower right.
     */
    public static Pair map(EntityType type, double x, double y, double w, double h) {
        double actual_width = w - x;
        double actual_height = h - y;
        Pair target = EntitySize.getDimentionsFromType(type);

        double width_factor = target.getX() / actual_width;
        double height_factor = target.getY() / actual_height;

        // TODO: Change logging level based on mismatch amount?
        if (width_factor != height_factor) {
            Logging.debug("Non-fatal mismatch of factoring values (w: " +
                    width_factor + ", h: " + height_factor +")");
        }

        Pair ret = new Pair(width_factor, height_factor);
        return ret;
    }
}

