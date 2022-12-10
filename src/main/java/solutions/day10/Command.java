package solutions.day10;

public class Command {
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public enum Type {
        NOOP,
        ADDX
    }
    private int value;

    private Type type;

    public Command(String string) {
        String[] split = string.split(" ");
        switch(split[0]) {
            case "noop" -> type = Type.NOOP;
            case "addx" -> {
                type = Type.ADDX;
                value = Integer.parseInt(split[1]);
            }
        }
    }
}
