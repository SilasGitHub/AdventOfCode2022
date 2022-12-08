package solutions.day8;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import solutions.Puzzle;

public class Puzzle1 extends Puzzle {
    @Override
    protected void solve() throws IOException {
        List<String> lines = reader.lines().toList();
        int length = lines.size();
        int width = lines.get(0).toCharArray().length;
        Tree[][] forest = new Tree[length][width];
        for (int i = 0; i < lines.size(); i++) {
            char[] chars = lines.get(i).toCharArray();
            for (int j = 0; j < chars.length; j++) {
                forest[i][j] = new Tree(Character.getNumericValue(chars[j]));
            }
        }

        for (int i = 0; i < length; i++) {
            int current = -1;
            for (int j = 0; j < width; j++) {
                if (forest[i][j].getHeight() > current) {
                    current = forest[i][j].getHeight();
                    forest[i][j].setVisibleFromLeft(true);
                }
            }
            current = -1;
            for (int j = width - 1; j >= 0; j--) {
                if (forest[i][j].getHeight() > current) {
                    current = forest[i][j].getHeight();
                    forest[i][j].setVisibleFromRight(true);
                }
            }
        }
        for (int i = 0; i < width; i++) {
            int current = -1;
            for (int j = 0; j < length; j++) {
                if (forest[j][i].getHeight() > current) {
                    current = forest[j][i].getHeight();
                    forest[j][i].setVisibleFromTop(true);
                }
            }
            current = -1;
            for (int j = length - 1; j >= 0; j--) {
                if (forest[j][i].getHeight() > current) {
                    current = forest[j][i].getHeight();
                    forest[j][i].setVisibleFromBottom(true);
                }
            }
        }
        System.out.println(Arrays.stream(forest).flatMap(Arrays::stream).toList().stream().filter(Tree::isVisible).count());
    }
}
