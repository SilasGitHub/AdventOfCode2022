package solutions.day3;

import solutions.Puzzle;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.stream.Collectors;
import java.util.Set;

public class Puzzle1 extends Puzzle {
    @Override
    protected void solve() throws IOException {
        long sum = 0;
        String line;
        while ((line = reader.readLine()) != null) {
            Set<Character> firstHalf = line.substring(0, line.length()/2).chars().mapToObj(e -> (char) e).collect(Collectors.toSet());
            Set<Character> secondHalf = line.substring(line.length()/2).chars().mapToObj(e -> (char) e).collect(Collectors.toSet());
            firstHalf.retainAll(secondHalf);
            sum += firstHalf.stream().mapToLong(c -> {
                if (Character.isLowerCase(c)) return c - 96;
                else return c - 38;
            }).sum();
        }
        System.out.println(sum);
    }
}
