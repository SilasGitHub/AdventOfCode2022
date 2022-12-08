package solutions.day8;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import solutions.Puzzle;

public class Puzzle2 extends Puzzle {
    @Override
    protected void solve() throws IOException {
        List<String> lines = reader.lines().toList();
        int length = lines.size();
        int width = lines.get(0).toCharArray().length;
        Tree[][] forest = new Tree[length][width];
        for (int i = 0; i < lines.size(); i++) {
            char[] chars = lines.get(i).toCharArray();
            for (int j = 0; j < chars.length; j++) {
                forest[i][j] = new Tree(Character.getNumericValue(chars[j]), j, i);
            }
        }
        System.out.println(Arrays.stream(forest).flatMap(Arrays::stream).toList().stream().mapToInt(tree -> getScenicScore(forest, tree)).max().getAsInt());
    }

    public int getScenicScore(Tree[][] forest, Tree tree) {
        int x = tree.getX();
        int y = tree.getY();
        int ownHeight = forest[y][x].getHeight();
        int left = 0;
        int right = 0;
        int top = 0;
        int bottom = 0;
        for (int i = x - 1; i >= 0; i--) {
            if (forest[y][i].getHeight() < ownHeight) left++;
            else {
                left++;
                break;
            }
        }
        for (int i = x + 1; i < forest[0].length; i++) {
            if (forest[y][i].getHeight() < ownHeight) right++;
            else {
                right++;
                break;
            }
        }
        for (int i = y - 1; i >= 0; i--) {
            if (forest[i][x].getHeight() < ownHeight) top++;
            else {
                top++;
                break;
            }
        }
        for (int i = y + 1; i < forest.length; i++) {
            if (forest[i][x].getHeight() < ownHeight) bottom++;
            else {
                bottom++;
                break;
            }
        }
        return left * right * top * bottom;
    }

}
