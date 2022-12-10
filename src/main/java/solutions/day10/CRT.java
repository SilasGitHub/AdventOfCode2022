package solutions.day10;

public class CRT {
    private CPU cpu;
    private StringBuilder solution = new StringBuilder();
    private int position = 0;
    public CRT(CPU cpu) {
        this.cpu = cpu;
    }
    public String draw() {
        for (int i = 0; i < 240; i++) {
            if (cpu.getValueAtCycle(i+1) == (i%40) ||
                cpu.getValueAtCycle(i+1) == ((i%40) + 1) ||
                cpu.getValueAtCycle(i+1) == ((i%40) - 1))
                solution.append("#");
            else solution.append(".");
            if ((i+1) % 40 == 0) solution.append("\n");
        }
        return solution.toString();
    }
}
