package solutions.day10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CPU {
    private int value = 1;
    private int cycle = 1;
    private Map<Integer, Integer> valueAtCycle= new HashMap<>();
    private List<Command> commandList = new ArrayList<>();

    public void addCommand(Command command) {
        this.commandList.add(command);
    }

    public void run() {
        for (int i = 0; i < commandList.size(); i++) {
            valueAtCycle.put(cycle, value);
            switch (commandList.get(i).getType()) {
                case NOOP -> cycle++;
                case ADDX -> {
                    cycle++;
                    valueAtCycle.put(cycle, value);
                    value += commandList.get(i).getValue();
                    cycle++;
                }
            }
        }
    }

    public int getValueAtCycle(Integer cycle) {
        return valueAtCycle.get(cycle);
    }

}
