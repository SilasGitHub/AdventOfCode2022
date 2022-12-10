package solutions.day10;

import java.io.IOException;
import solutions.Puzzle;

public class Puzzle2 extends Puzzle {
    @Override
    protected void solve() throws IOException {
        String line;
        CPU cpu = new CPU();
        while ((line = reader.readLine()) != null) {
            cpu.addCommand(new Command(line));
        }
        cpu.run();
        System.out.println(new CRT(cpu).draw());
    }
}
