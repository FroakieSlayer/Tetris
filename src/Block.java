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
    private Point getTopLeft(){
        return topLeft;
    }
    private void setTopLeft(Point p){
        topLeft.setLocation(p);
    }
    private Point[] getPoints(){
        return points;
    }
}
