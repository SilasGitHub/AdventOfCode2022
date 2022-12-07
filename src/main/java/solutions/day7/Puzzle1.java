package solutions.day7;

import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import solutions.Puzzle;

public class Puzzle1 extends Puzzle {
    @Override
    protected void solve() throws IOException {
        Scanner scanner = new Scanner(reader);
        Set<Directory> dirs = new HashSet<>();
        Directory outermost = new Directory(null, "/");
        dirs.add(outermost);
        Directory current = outermost;
        while (scanner.hasNext()) {
            String next = scanner.next();
            if (next.equals("$")) {
                if (scanner.hasNext("cd")) {
                    scanner.next();
                    if (scanner.hasNext("/")) {
                        current = outermost;
                        scanner.next();
                    } else if (scanner.hasNext("..")) {
                        current = current.getParent();
                        scanner.next();
                    } else {
                        current = current.getByName(scanner.next());
                    }
                } else {
                    scanner.next();
                }
            } else if (next.equals("dir")) {
                Directory dir = new Directory(current, scanner.next());
                dirs.add(dir);
                current.getContent().add(dir);
            } else {
                current.getContent().add(new File(Long.parseLong(next), scanner.next()));
            }
        }
        System.out.println(dirs.stream().filter(dir -> dir.getSize() <= 100000).mapToLong(Directory::getSize).sum());
    }
}
