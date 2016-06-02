import java.awt.*;

public class Block {
    private Point[] points;
    private Point topLeft;
    public Block(){
        //important that order of points has no points with shared x value but lower y come first. if you have 1,0 and 1,1 list 1,1 first
        points = new Point[4];
        points[0]=new Point(0,0);
        points[1]=new Point(1,1);
        points[2]=new Point(1,0);
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