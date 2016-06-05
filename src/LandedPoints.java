import java.awt.*;

public class LandedPoints {
    private int landed;
    private Color color;
    public LandedPoints(int l, Color c){
        landed=l;
        color=c;
    }
    public int getLanded(){
        return landed;
    }
    public Color getColor(){
        return color;
    }
}
