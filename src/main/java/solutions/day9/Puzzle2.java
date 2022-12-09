package solutions.day9;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import solutions.Puzzle;

public class Puzzle2 extends Puzzle {
    @Override
    protected void solve() throws IOException {
        Set<Coordinate> history = new HashSet<>();
        List<Coordinate> rope = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            rope.add(new Coordinate(0, 0));
        }
        history.add(new Coordinate(rope.get(9).getX(), rope.get(9).getY()));
        String line;
        while ((line = reader.readLine()) != null) {
            history.addAll(makeMove(new Move(line), rope));
        }
         System.out.println(history.size());
    }

    public Set<Coordinate> makeMove(Move move, List<Coordinate> rope) {
        Set<Coordinate> history = new HashSet<>();
        for (int i = move.getQuantity(); i > 0; i--) {
            switch (move.getDirection()) {
                case UP -> {
                    rope.get(0).setY(rope.get(0).getY() + 1);
                    for (int j = 0; j < 9; j++) {
                        if (!makeMove(rope.get(j), rope.get(j+1))) {
                            break;
                        }
                    }
                }
                case RIGHT -> {
                    rope.get(0).setX(rope.get(0).getX() + 1);
                    for (int j = 0; j < 9; j++) {
                        if (!makeMove(rope.get(j), rope.get(j+1))) {
                            break;
                        }
                    }
                }
                case DOWN -> {
                    rope.get(0).setY(rope.get(0).getY() - 1);
                    for (int j = 0; j < 9; j++) {
                        if (!makeMove(rope.get(j), rope.get(j+1))) {
                            break;
                        }
                    }
                }
                case LEFT -> {
                    rope.get(0).setX(rope.get(0).getX() - 1);
                    for (int j = 0; j < 9; j++) {
                        if (!makeMove(rope.get(j), rope.get(j+1))) {
                            break;
                        }
                    }
                }
            }
            history.add(new Coordinate(rope.get(9).getX(), rope.get(9).getY()));
        }
        return history;
    }

    public boolean needsMove(Coordinate head, Coordinate tail) {
        return (Math.abs(head.getX()-tail.getX()) > 1 || Math.abs(head.getY() - tail.getY()) > 1);
    }

    public boolean makeMove(Coordinate head, Coordinate tail) {
        if (!needsMove(head, tail)) return false;
        if (Math.abs(head.getX() - tail.getX()) > 1 && Math.abs(head.getY() - tail.getY()) > 1) {
            if (head.getX() < tail.getX()) {
                tail.setX(tail.getX() - 1);
            } else {
                tail.setX(tail.getX() + 1);
            }
            if (head.getY() < tail.getY()) {
                tail.setY(tail.getY() - 1);
            } else {
                tail.setY(tail.getY() + 1);
            }
        } else if (Math.abs(head.getX() - tail.getX()) > 1) {
            tail.setY(head.getY());
            if (head.getX() < tail.getX()) tail.setX(tail.getX() - 1);
            else tail.setX(tail.getX() + 1);
        } else {
            tail.setX(head.getX());
            if (head.getY() < tail.getY()) tail.setY(tail.getY() - 1);
            else tail.setY(tail.getY() + 1);
        }
        return true;
    }
}
