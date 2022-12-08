package solutions.day8;

public class Tree {
    private int height;
    private int x;
    private int y;
    private boolean isVisibleFromTop;
    private boolean isVisibleFromLeft;
    private boolean isVisibleFromRight;
    private boolean isVisibleFromBottom;

    public Tree(int height) {
        this.height = height;
    }

    public Tree(int height, int x, int y) {
        this.height = height;
        this.x = x;
        this.y = y;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean isVisibleFromTop() {
        return isVisibleFromTop;
    }

    public void setVisibleFromTop(boolean visibleFromTop) {
        isVisibleFromTop = visibleFromTop;
    }

    public boolean isVisibleFromLeft() {
        return isVisibleFromLeft;
    }

    public void setVisibleFromLeft(boolean visibleFromLeft) {
        isVisibleFromLeft = visibleFromLeft;
    }

    public boolean isVisibleFromRight() {
        return isVisibleFromRight;
    }

    public void setVisibleFromRight(boolean visibleFromRight) {
        isVisibleFromRight = visibleFromRight;
    }

    public boolean isVisibleFromBottom() {
        return isVisibleFromBottom;
    }

    public void setVisibleFromBottom(boolean visibleFromBottom) {
        isVisibleFromBottom = visibleFromBottom;
    }

    public boolean isVisible() {
        return isVisibleFromBottom || isVisibleFromLeft || isVisibleFromRight || isVisibleFromTop;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
