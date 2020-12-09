package enviroment;

import java.util.HashMap;
import java.util.Map;

public enum Direction implements IDirection {

    NORTH("N", 0, 1) {
        @Override
        public Direction rotateLeft() {
            return WEST;
        }

        @Override
        public Direction rotateRight() {
            return EAST;
        }
    },

    SOUTH("S", 0, -1) {
        @Override
        public Direction rotateLeft() {
            return EAST;
        }

        @Override
        public Direction rotateRight() {
            return WEST;
        }
    },

    WEST("W", -1, 0) {
        @Override
        public Direction rotateLeft() {
            return SOUTH;
        }


        @Override
        public Direction rotateRight() {
            return NORTH;
        }
    },

    EAST("E", 1, 0) {
        @Override
        public Direction rotateLeft() {
            return NORTH;
        }

        @Override
        public Direction rotateRight() {
            return SOUTH;
        }
    };

    private final String direction;
    private final int convertedStepX;
    private final int convertedStepY;

    Direction(String direction, int convertedStepX, int convertedStepY) {
        this.direction = direction;
        this.convertedStepX = convertedStepX;
        this.convertedStepY = convertedStepY;
    }

    private static final Map<String, Direction> directionMap = new HashMap<>();

    static {
        for (Direction d : Direction.values()) {
            directionMap.put(d.toString(), d);
        }
    }

    public static Direction get(String name) {
        return directionMap.get(name);
    }

    public int getConvertedStepX() {
        return convertedStepX;
    }

    public int getConvertedStepY() {
        return convertedStepY;
    }

    @Override
    public String toString() {
        return direction;
    }
}
