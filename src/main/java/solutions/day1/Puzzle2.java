package solutions.day1;

import solutions.Puzzle;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Puzzle2 extends Puzzle {
    @Override
    protected void solve() throws IOException {
        Set<Integer> highest = new HashSet<>();
        int current = 0;
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.equals("")) {
                if (highest.size() < 3) {
                    highest.add(current);
                } else if (current > Collections.min(highest)) {
                    highest.remove(Collections.min(highest));
                    highest.add(current);
                }
                current = 0;
                continue;
            }
            current += Integer.parseInt(line);
        }
        System.out.println(highest.stream().mapToInt(Integer::intValue).sum());
    }
}
