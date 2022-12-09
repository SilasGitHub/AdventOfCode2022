package solutions.day9;

public class Move {
    public Move(Direction direction, int quantity) {
        this.direction = direction;
        this.quantity = quantity;
    }

    public Move(String input) {
        String[] split = input.split(" ");
        switch (split[0]) {
            case "U" -> this.direction = Direction.UP;
            case "R" -> this.direction = Direction.RIGHT;
            case "D" -> this.direction = Direction.DOWN;
            case "L" -> this.direction = Direction.LEFT;
        }
        this.quantity = Integer.parseInt(split[1]);
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public enum Direction {
        UP,
        RIGHT,
        DOWN,
        LEFT
    }
    private Direction direction;
    private int quantity;
}
