package _05_class;

public class Rectangle {
    int width;
    int height;

    public Rectangle(int w, int h) {
        this.width = w;
        this.height = h;
    }

    public int area(){
        return this.width*this.height;
    }
}
