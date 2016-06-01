import java.awt.*;

public class Block {
    private Point[] points;
    private Point topLeft;
    public Block(){
        points = new Point[4];
        points[0]=new Point(0,0);
        points[1]=new Point(1,0);
        points[2]=new Point(1,1);
        points[3]=new Point(2,1);
        topLeft = new Point(4,0);
    }
    public Point getTopLeft(){
        return topLeft;
    }
    public void setTopLeft(int r, int c){
        topLeft.setLocation(c,r);
    }
    public Point[] getPoints(){
        return points;
    }
    public int Row(){
        return (int)topLeft.getY();
    }
    public int Column(){
        return (int)topLeft.getX();
    }
}
