package solutions.day2;

import solutions.Puzzle;

import java.io.IOException;

public class Puzzle2 extends Puzzle {
    @Override
    protected void solve() throws IOException {
        final Long[] score = {0L};
        reader.lines().forEach(line -> {
            switch (line) {
                case "A X" -> score[0] += 3;
                case "A Y" -> score[0] += 4;
                case "A Z" -> score[0] += 8;

                case "B X" -> score[0] += 1;
                case "B Y" -> score[0] += 5;
                case "B Z" -> score[0] += 9;

                case "C X" -> score[0] += 2;
                case "C Y" -> score[0] += 6;
                case "C Z" -> score[0] += 7;
            }
        });
        System.out.println(score[0]);
    }
}
