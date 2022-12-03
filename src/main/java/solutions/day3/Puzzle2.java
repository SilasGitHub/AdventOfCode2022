package solutions.day3;

import solutions.Puzzle;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Puzzle2 extends Puzzle {
    @Override
    protected void solve() throws IOException {
        long sum = 0;
        int i = 1;
        String line;
        Set<Character> group = new HashSet<>();
        while ((line = reader.readLine()) != null) {
            Set<Character> toAdd = line.chars().mapToObj(e -> (char) e).collect(Collectors.toSet());
            if (i % 3 == 0) {
                group.retainAll(toAdd);
                sum += group.stream().mapToLong(c -> {
                    if (Character.isLowerCase(c)) return c - 96;
                    else return c - 38;
                }).sum();
                group = new HashSet<>();
            } else {
                if (group.isEmpty()) {
                    group.addAll(toAdd);
                } else {
                    group.retainAll(toAdd);
                }
            }
            i++;
        }
        System.out.println(sum);
    }
}
