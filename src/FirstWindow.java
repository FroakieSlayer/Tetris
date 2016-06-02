import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class FirstWindow extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    private boolean[][] isFilled;
    private int delayForDrop;
    public FirstWindow(){
        super("xD");
        setSize(500,940);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        isFilled = new boolean[][] {{false,false,false,false,false,false,false,false,false,false},{false,false,false,false,false,false,false,false,false,false},{false,false,false,false,false,false,false,false,false,false},{false,false,false,false,false,false,false,false,false,false},{false,false,false,false,false,false,false,false,false,false},{false,false,false,false,false,false,false,false,false,false},{false,false,false,false,false,false,false,false,false,false},{false,false,false,false,false,false,false,false,false,false},{false,false,false,false,false,false,false,false,false,false},{false,false,false,false,false,false,false,false,false,false},{false,false,false,false,false,false,false,false,false,false},{false,false,false,false,false,false,false,false,false,false},{false,false,false,false,false,false,false,false,false,false},{false,false,false,false,false,false,false,false,false,false},{false,false,false,false,false,false,false,false,false,false},{false,false,false,false,false,false,false,false,false,false},{false,false,false,false,false,false,false,false,false,false},{false,false,false,false,false,false,false,false,false,false},{false,false,false,false,false,false,false,false,false,false},{false,false,false,false,false,false,false,false,false,false},{false,false,false,false,false,false,false,false,false,false},{false,false,false,false,false,false,false,false,false,false},};
        //this is the board and its 22,10 rows, columns. The first two rows are not displayed
        delayForDrop=1000;


    }

    public void paint(Graphics g){
        //note to self cords for top left square are 40 80 (41 81 for the non border part)
        g.fillRect(0,0,500,940);
        g.setColor(Color.WHITE);

        for(int i = 0; i<10;i++){
            for(int j=0; j<20;j++){
                g.drawRect((i+1)*40,(j+2)*40,40,40);
            }
        }


        while(true) {
            boolean landed = false;
            Block b = new Block();
            while (!landed){
                for (int i = 0; i < b.getPoints().length; i++) {
                    if ((int)b.getPoints()[i].getY() + (int)b.getTopLeft().getY()==21 || isFilled[(int)b.getPoints()[i].getY() + (int)b.getTopLeft().getY()][(int)b.getPoints()[i].getX() + (int)b.getTopLeft().getX()]) {
                        landed = true;
                        break;
                    }
                }
                if (landed) {
                    for(int i=0;i<b.getPoints().length;i++) {
                        isFilled[(int) b.getPoints()[i].getY() + b.Row()-1][(int) b.getPoints()[i].getX() + b.Column()]=true;
                        g.setColor(Color.GREEN);
                        g.fillRect(((int) b.getPoints()[i].getX() + b.Column()) * 40 + 41, ((int) b.getPoints()[i].getY() + b.Row()) * 40 + 1, 39, 39);
                        g.setColor(Color.BLACK);
                        g.fillRect(((int) b.getPoints()[i].getX() + b.Column()) * 40 + 41, ((int) b.getPoints()[i].getY() + b.Row() - 1) * 40 + 1, 39, 39);
                    }
                }


                for (int i = 0; i < b.getPoints().length; i++) {

                    if (b.getPoints()[i].getY() + b.Row() > 1) {
                        g.setColor(Color.BLUE);
                        g.fillRect(((int) b.getPoints()[i].getX() + b.Column()) * 40 + 41, ((int) b.getPoints()[i].getY() + b.Row()) * 40 + 1, 39, 39);
                    }
                    if (b.getPoints()[i].getY() + b.Row() > 2) {
                        g.setColor(Color.BLACK);
                        g.fillRect(((int) b.getPoints()[i].getX() + b.Column()) * 40 + 41, ((int) b.getPoints()[i].getY() + b.Row()-1) * 40 + 1, 39, 39);
                    }
                }

                try {
                    Thread.sleep(delayForDrop);                 //1000 milliseconds is one second.
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
                b.setTopLeft(b.Row() + 1, b.Column());

            }
        }
    }
    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        /*if (key == KeyEvent.VK_LEFT) {

        }

        if (key == KeyEvent.VK_RIGHT) {

        }

        if (key == KeyEvent.VK_UP) {

        }*/

        if (key == KeyEvent.VK_DOWN) {
            delayForDrop=100;
        }
    }
    private class TAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            keyPressed(e);
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }


}