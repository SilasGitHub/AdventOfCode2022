package solutions.day2;

import solutions.Puzzle;

import java.io.IOException;

public class Puzzle1 extends Puzzle {
    @Override
    protected void solve() throws IOException {
        String line;
        long score = 0;
        while ((line = reader.readLine()) != null) {
            switch (line) {
                case "A X" -> score += 4;
                case "A Y" -> score += 8;
                case "A Z" -> score += 3;

                case "B X" -> score += 1;
                case "B Y" -> score += 5;
                case "B Z" -> score += 9;

                case "C X" -> score += 7;
                case "C Y" -> score += 2;
                case "C Z" -> score += 6;
            }
        }
        System.out.println(score);
    }
}
