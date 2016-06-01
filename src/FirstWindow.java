import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FirstWindow extends JFrame {
    private static final long serialVersionUID = 1L;
    private boolean[][] isFilled;
    public FirstWindow(){
        super("xD");
        setSize(500,940);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        isFilled = new boolean[][] {{false,false,false,false,false,false,false,false,false,false},{false,false,false,false,false,false,false,false,false,false},{false,false,false,false,false,false,false,false,false,false},{false,false,false,false,false,false,false,false,false,false},{false,false,false,false,false,false,false,false,false,false},{false,false,false,false,false,false,false,false,false,false},{false,false,false,false,false,false,false,false,false,false},{false,false,false,false,false,false,false,false,false,false},{false,false,false,false,false,false,false,false,false,false},{false,false,false,false,false,false,false,false,false,false},{false,false,false,false,false,false,false,false,false,false},{false,false,false,false,false,false,false,false,false,false},{false,false,false,false,false,false,false,false,false,false},{false,false,false,false,false,false,false,false,false,false},{false,false,false,false,false,false,false,false,false,false},{false,false,false,false,false,false,false,false,false,false},{false,false,false,false,false,false,false,false,false,false},{false,false,false,false,false,false,false,false,false,false},{false,false,false,false,false,false,false,false,false,false},{false,false,false,false,false,false,false,false,false,false},{false,false,false,false,false,false,false,false,false,false},{false,false,false,false,false,false,false,false,false,false},};
        //this is the board and its 22,10 rows, columns. The first two rows are not displayed
    }
    public void paint(Graphics g){

        g.fillRect(0,0,500,940);
        g.setColor(Color.WHITE);
        for(int i = 0; i<10;i++){
            for(int j=0; j<20;j++){
                g.drawRect((i+1)*40,(j+2)*40,40,40);
            }
        }

        boolean landed = false;
        //while(true) {
            Block b = new Block();
            while (!landed){
                for (int i = 0; i < b.getPoints().length; i++) {
                    if (isFilled[(int)b.getPoints()[i].getY() + (int)b.getTopLeft().getY() + 1][(int)b.getPoints()[i].getX() + (int)b.getTopLeft().getX()]) {
                        landed = true;
                        break;
                    }
                }
            if (landed) {
                //implement landing later
            }
            b.setTopLeft(b.Row() + 1, b.Column());

            for (int i = 0; i < b.getPoints().length; i++) {
                try {
                    Thread.sleep(250);                 //1000 milliseconds is one second.
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
                if (b.getPoints()[i].getY() + b.Row() > 2) {
                    g.setColor(Color.BLACK);
                    g.fillRect(((int) b.getPoints()[i].getX() + b.Column()) * 40 + 1, ((int) b.getPoints()[i].getY() + b.Row() * 40) + 41, 39, 39);
                }
                g.setColor(Color.BLUE);
                g.fillRect(((int) b.getPoints()[i].getX() + b.Column() * 40) + 41, ((int) b.getPoints()[i].getY() + b.Row() * 40) + 81, 39, 39);
            }
            try {
                Thread.sleep(1000);                 //1000 milliseconds is one second.
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
        //}
    }

}
