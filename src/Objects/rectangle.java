package Objects;

public class rectangle extends Objects {
    private int y;
    private int x;
    private int length;
    private int width;
    public rectangle(int x, int y, int length, int width) {
        super(x, y);
        this.length = length;
        this.width = width;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public int getWidth(){
        return width;
    }
    public int getLength(){
        return length;
    }
    public int getBound(){
        return x + width;
    }
    public int getYbound(){
        return y + length;
    }
}
