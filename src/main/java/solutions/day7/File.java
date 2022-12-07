package solutions.day7;

public class File {
    long size = 0;

    String name;

    public File(long size, String name) {
        this.size = size;
        this.name = name;
    }

    public File() {
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
