import javax.swing.*;
import java.awt.*;

public class FirstWindow extends JFrame {
    private static final long serialVersionUID = 1L;
    public FirstWindow(){
        super("xD");
        setSize(600,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
    public void paint(Graphics g){
        g.setColor(Color.GRAY);
        g.fillRect(0,0,600,600);

    }
}
