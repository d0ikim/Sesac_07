package _05_class;

public class Rectangle {
    private int width;
    private int height;

    public Rectangle(int w) {
        this.width = w;
    }

    public int getWidth(){
        return this.width;
    }
    public int getHeight(){
        return this.height;
    }

    public void setWidth(int w){
        this.width = w;
    }
    public void setHeight(int h){
        this.height = h;
    }

    public int area(){
        return this.width*this.height;
    }
}
