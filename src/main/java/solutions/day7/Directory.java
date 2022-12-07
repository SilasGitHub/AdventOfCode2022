package solutions.day7;

import java.util.HashSet;
import java.util.Set;

public class Directory extends File {
    private Directory parent;

    private Set<File> content = new HashSet<>();

    public Directory(Directory parent, String name) {
        this.parent = parent;
        this.name = name;
    }

    public Directory getParent() {
        return parent;
    }

    public void setParent(Directory parent) {
        this.parent = parent;
    }

    public Set<File> getContent() {
        return content;
    }

    public void setContent(Set<File> content) {
        this.content = content;
    }

    @Override
    public long getSize() {
        return content.stream().map(File::getSize).mapToLong(Long::longValue).sum();
    }

    public Directory getByName(String name) {
        return (Directory) content.stream().filter(f -> f.getName().equals(name)).findFirst().get();
    }
}
