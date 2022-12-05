package solutions.day5;

import solutions.Puzzle;

import java.io.IOException;
import java.util.*;

public class Puzzle1 extends Puzzle {
    @Override
    protected void solve() throws IOException {
        String line;
        Map<Integer, Deque<Character>> stacks = new HashMap<>();
        while (!Character.isDigit((line = reader.readLine()).charAt(1))) {
            for (int i = 0; i < line.toCharArray().length; i++) {
                if (Character.isLetter(line.charAt(i))) {
                    Deque<Character> stack = stacks.getOrDefault(((i+3)/4),new ArrayDeque<>());
                    stack.add(line.charAt(i));
                    stacks.put(((i+3)/4), stack);
                }
            }
        }
        reader.readLine();
        Scanner scan = new Scanner(reader);
        while (scan.hasNext()) {
            scan.next();
            int quantity = scan.nextInt();
            scan.next();
            int source = scan.nextInt();
            scan.next();
            int target = scan.nextInt();
            while (quantity > 0) {
                stacks.get(target).push(stacks.get(source).poll());
                quantity--;
            }
        }
        for (int i = 1; i <= stacks.size(); i++) {
            System.out.print(stacks.get(i).peek());
        }
    }
}

