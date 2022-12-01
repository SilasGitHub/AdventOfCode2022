package solutions.day1;

import solutions.Puzzle;

import java.io.*;

public class Puzzle1 extends Puzzle {

    @Override
    protected void solve() throws IOException {
        int max = 0;
        int current = 0;
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.equals("")) {
                if (current > max) {
                    max = current;
                }
                current = 0;
                continue;
            }
            current += Integer.parseInt(line);
        }
        System.out.println(max);
    }
}
