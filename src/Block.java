import java.awt.*;
public class Block {
    private Point[] points;
    private Point topLeft;
    public Block() {
        //important that order of points has no points with shared x value but lower y come first. if you have 1,0 and 1,1 list 1,1 first
        points = new Point[4];
        generateBlock();
        topLeft = new Point(4, 0,Color.RED);
    }
    public Block(Point[] pp){//hehefunny name
        points=pp;
        topLeft = new Point(4, 0,Color.RED);
    }
    public Block(Block b){
        points=b.getPoints();
        topLeft = new Point(4, 0,Color.RED);
        topLeft.setLocation(b.Column(),b.Row());
    }
    public Point getTopLeft() {
        return topLeft;
    }
    public void setTopLeft(int r, int c) {
        topLeft.setLocation(c, r);
    }
    public Point[] getPoints() {
        return points;
    }
    public int Row() {
        return topLeft.getY();
    }
    public int Column() {
        return topLeft.getX();
    }
    public void generateBlock() {
        int num = (int) (Math.random() * 7);
        switch (num) {
            case 0:
                Color c=Color.RED;
                points[0] = new Point(0, 1,c);
                points[1] = new Point(1, 1,c);
                points[2] = new Point(2, 1,c);
                points[3] = new Point(3, 1,c);
                break;
            case 1:
                Color d=Color.ORANGE;
                points[0] = new Point(0, 1,d);
                points[1] = new Point(1, 1,d);
                points[2] = new Point(1, 0,d);
                points[3] = new Point(2, 0,d);
                break;
            case 2:
                Color e=Color.YELLOW;
                points[0] = new Point(0, 1,e);
                points[1] = new Point(1, 1,e);
                points[2] = new Point(1, 0,e);
                points[3] = new Point(0, 0,e);
                break;
            case 3:
                Color f=Color.GREEN;
                points[0] = new Point(2, 0,f);
                points[1] = new Point(2, 1,f);
                points[2] = new Point(1, 1,f);
                points[3] = new Point(0, 1,f);
                break;
            case 4:
                Color g=Color.BLUE;
                points[0] = new Point(2, 1,g);
                points[1] = new Point(2, 0,g);
                points[2] = new Point(1, 0,g);
                points[3] = new Point(0, 0,g);
                break;
            case 5:
                Color h=Color.CYAN;
                points[0] = new Point(0, 0,h);
                points[1] = new Point(1, 1,h);
                points[2] = new Point(1, 0,h);
                points[3] = new Point(2, 1,h);
                break;
            case 6:
                Color i=Color.MAGENTA;
                points[0] = new Point(0, 0,i);
                points[1] = new Point(1, 1,i);
                points[2] = new Point(1, 0,i);
                points[3] = new Point(2, 0,i);
                break;
        }
    }
    public Point[] rotate(){
        Point[] newpoints = new Point[4];
        //if(points[0].getColor()==Color.RED){
            for(int i=0; i<4;i++){
                newpoints[i]=new Point(-(points[i].getY()-points[2].getY()),points[i].getX()-points[2].getX(),points[0].getColor());
            }
        //}
        /*if(points[0].getColor()==Color.ORANGE){
            for(int i=0; i<points.length;i++){
                newpoints[i]=new Point(-(points[i].getY()-points[2].getY()),points[i].getX()-points[2].getX(),Color.ORANGE);
            }
        }
        if(points[0].getColor()==Color.GREEN){
            for(int i=0; i<points.length;i++){
                newpoints[i]=new Point(-(points[i].getY()-points[2].getY()),points[i].getX()-points[2].getX(),Color.GREEN);
            }
        }
        if(points[0].getColor()==Color.BLUE){
            for(int i=0; i<points.length;i++){
                newpoints[i]=new Point(-(points[i].getY()-points[2].getY()),points[i].getX()-points[2].getX(),Color.BLUE);
            }
        }
        if(points[0].getColor()==Color.CYAN){
            for(int i=0; i<points.length;i++){
                newpoints[i]=new Point(-(points[i].getY()-points[2].getY()),points[i].getX()-points[2].getX(),Color.CYAN);
            }
        }
        if(points[0].getColor()==Color.MAGENTA){
            for(int i=0; i<points.length;i++){
                newpoints[i]=new Point(-(points[i].getY()-points[2].getY()),points[i].getX()-points[2].getX(),Color.MAGENTA);
            }
        }*/
        return newpoints;
    }
    public Point[] rotateCounter(){
        Point[] newpoints = new Point[4];
        for(int i=0; i<4;i++){
            newpoints[i]=new Point((points[i].getY()-points[2].getY()),-(points[i].getX()-points[2].getX()),points[0].getColor());
        }
        return newpoints;
    }
    public void setPoints(Point[] newpoints){
        points=newpoints;
    }
}