package solutions.day9;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import solutions.Puzzle;

public class Puzzle1 extends Puzzle {
    @Override
    protected void solve() throws IOException {
        Set<Coordinate> history = new HashSet<>();
        Coordinate head = new Coordinate(0, 0);
        Coordinate tail = new Coordinate(0, 0);
        history.add(tail);
        String line;
        while ((line = reader.readLine()) != null) {
            history.addAll(makeMove(new Move(line), head, tail));
        }
        System.out.println(history.size());
    }

    public Set<Coordinate> makeMove(Move move, Coordinate head, Coordinate tail) {
        Set<Coordinate> history = new HashSet<>();
        for (int i = move.getQuantity(); i > 0; i--) {
            switch (move.getDirection()) {
                case UP -> {
                    head.setY(head.getY() + 1);
                    if (needsMove(head, tail)) {
                        tail.setX(head.getX());
                        tail.setY(tail.getY() + 1);
                    }
                }
                case RIGHT -> {
                    head.setX(head.getX() + 1);
                    if (needsMove(head, tail)) {
                        tail.setY(head.getY());
                        tail.setX(tail.getX() + 1);
                    }
                }
                case DOWN -> {
                    head.setY(head.getY() - 1);
                    if (needsMove(head, tail)) {
                        tail.setX(head.getX());
                        tail.setY(tail.getY() - 1);
                    }
                }
                case LEFT -> {
                    head.setX(head.getX() - 1);
                    if (needsMove(head, tail)) {
                        tail.setY(head.getY());
                        tail.setX(tail.getX() - 1);
                    }
                }
            }
            history.add(new Coordinate(tail.getX(), tail.getY()));
        }
        return history;
    }

    public boolean needsMove(Coordinate head, Coordinate tail) {
        return (Math.abs(head.getX()-tail.getX()) > 1 || Math.abs(head.getY() - tail.getY()) > 1);
    }
}
