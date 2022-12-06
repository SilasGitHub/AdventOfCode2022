package solutions.day6;

import solutions.Puzzle;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;

public class Puzzle2 extends Puzzle {
    @Override
    protected void solve() throws IOException {
        String line = reader.readLine();
        Deque<Character> chars = new ArrayDeque<>();
        for (int i = 0; i < line.toCharArray().length; i++) {
            chars.push(line.toCharArray()[i]);
            if (chars.size() == 14) {
                if (new HashSet<>(chars).size() == 14) {
                    System.out.println(i+1);
                    break;
                }
                chars.pollLast();
            }
        }
    }
}
