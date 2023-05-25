package Objects;

import Main.GamePanel;

public class Goal {
    private final int Xcoordinate;
    private final int Ycoordinate;
    public Goal(){
        this.Xcoordinate = (int) (Math.random() * 576);
        this.Ycoordinate = (int) (Math.random() * 576);
    }
    public int getXcoordinate(){
        return Xcoordinate;
    }
    public int getYcoordinate(){
        return Ycoordinate;
    }
}
