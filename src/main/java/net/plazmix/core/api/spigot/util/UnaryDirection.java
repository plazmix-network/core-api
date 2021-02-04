package net.plazmix.core.api.spigot.util;

public enum UnaryDirection {

    NORTH(Direction.NORTH), WEST(Direction.WEST), SOUTH(Direction.SOUTH), EAST(Direction.EAST), UP(Direction.UP),
    DOWN(Direction.DOWN);

    private final Direction valued;

    UnaryDirection(Direction valuedDirection) {
        this.valued = valuedDirection;
    }

    public Direction getValuedDirection() {
        return valued;
    }
}
