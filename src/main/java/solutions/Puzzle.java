package solutions;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.net.URISyntaxException;

public abstract class Puzzle {

    protected static BufferedReader reader;

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, IOException, URISyntaxException {
        Puzzle puzzle = (Puzzle) Puzzle.class.getClassLoader().loadClass("solutions.day" + args[0] + ".Puzzle"+args[1]).getDeclaredConstructor().newInstance();
        if (args.length > 2) {
            puzzle.initalize("test-input.txt");
        } else {
            puzzle.initalize("input.txt");
        }
        puzzle.solve();
    }

    protected void initalize(String file) throws IOException, URISyntaxException {
        File f = new File(this.getClass().getResource(file).toURI().getPath());
        reader = new BufferedReader(new FileReader(f));
    }

    protected abstract void solve() throws IOException;

}
