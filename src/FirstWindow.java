import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.JFrame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class FirstWindow extends JFrame {
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
        JPanel panel = new JPanel();
        panel.addKeyListener(new MyKeyListener());
        add(panel);


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
    public class MyKeyListener implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {


        }
        @Override
        public void keyPressed(KeyEvent e) {

            if (e.getKeyCode() == KeyEvent.VK_RIGHT ) {
                System.out.println("Right pressed.");
            }
            else if (e.getKeyCode() == KeyEvent.VK_LEFT ) {
                System.out.println("Left pressed.");
            }
            else if (e.getKeyCode() == KeyEvent.VK_UP ) {
                System.out.println("Up pressed.");
            }
            else if (e.getKeyCode() == KeyEvent.VK_DOWN ) {
                delayForDrop=100;
            }
            else{
                System.out.println("Key pressed: " + e.getKeyChar());
            }
        }
        @Override
        public void keyReleased(KeyEvent e) {

            if (e.getKeyCode() == KeyEvent.VK_RIGHT ) {
                System.out.println("Right released.");
            }
            else if (e.getKeyCode() == KeyEvent.VK_LEFT ) {
                System.out.println("Left released.");
            }
            else if (e.getKeyCode() == KeyEvent.VK_UP ) {
                System.out.println("Up released.");
            }
            else if (e.getKeyCode() == KeyEvent.VK_DOWN ) {
                System.out.println("Down released.");
            }
            else{
                System.out.println("Key released: " + e.getKeyChar());
            }
        }

    }




}

