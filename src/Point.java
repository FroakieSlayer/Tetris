import java.awt.*;
public class Point {
    private int x,y;
    private Color c;
    public Point(int xx, int yy, Color d){
        x=xx;
        y=yy;
        c=d;
    }
    public void setLocation(int xx, int yy){
        x=xx;
        y=yy;
    }
    public int getY(){
        return y;
    }
    public int getX(){
        return x;
    }
    public Color getColor(){
        return c;
    }
    public void setY(int yy){
        y=yy;
    }
}
