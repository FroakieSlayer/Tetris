import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;

public class Test extends JComponent {
    public static void main(String [] args){
        Intro intro = new Intro();
        intro.setVisible(true);
        intro.playSound();
        for(int i = 0; i<500; i++){
            intro.repaint();
            try {
                Thread.sleep(150);                 //1000 milliseconds is one second.
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
        intro.dispatchEvent(new WindowEvent(intro, WindowEvent.WINDOW_CLOSING));
        FirstWindow fw = new FirstWindow();
        fw.setVisible(true);
        fw.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch(e.getKeyCode()) {
                    case KeyEvent.VK_S:
                        fw.setDelay(100);
                        break;
                    case KeyEvent.VK_DOWN:
                        fw.setDelay(100);
                        break;
                    case KeyEvent.VK_A:
                        if(fw.canMoveLeft()) {
                            fw.moveLeft();
                            fw.repaint();
                        }
                        break;
                    case KeyEvent.VK_LEFT:
                        if(fw.canMoveLeft()) {
                            fw.moveLeft();
                            fw.repaint();
                        }
                        break;
                    case KeyEvent.VK_D:
                        if(fw.canMoveRight()) {
                            fw.moveRight();
                            fw.repaint();
                        }
                        break;
                    case KeyEvent.VK_RIGHT:
                        if(fw.canMoveRight()) {
                            fw.moveRight();
                            fw.repaint();
                        }
                        break;
                    case KeyEvent.VK_W:
                        if(fw.canRotate()){
                            fw.rotate();
                            fw.repaint();
                        }
                        break;
                    case KeyEvent.VK_UP:
                        if(fw.canRotate()){
                            fw.rotate();
                            fw.repaint();
                        }
                        break;
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {
                switch(e.getKeyCode()) {
                    case KeyEvent.VK_S:
                        fw.revertDelay();
                        break;
                    case KeyEvent.VK_DOWN:
                        fw.revertDelay();
                        break;
                }
            }
        });
        fw.playSound();
        while(!fw.getGameOver()){
            try {
                Thread.sleep(fw.getDelay());                 //1000 milliseconds is one second.
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            for (int i = 0; i < fw.getBlock().getPoints().length; i++) {
                if (fw.getBlock().getPoints()[i].getY() + fw.getBlock().getTopLeft().getY()==21 || fw.getFilled()[fw.getBlock().getPoints()[i].getY() + fw.getBlock().getTopLeft().getY()+1][fw.getBlock().getPoints()[i].getX() + fw.getBlock().getTopLeft().getX()]>0) {
                    fw.landBlock();
                    fw.generateBlock();
                    break;
                }
            }
            fw.repaint();
            fw.moveDown();
            if(fw.checkIfClear(21)){
                fw.beginClearing();
            }
        }
        fw.repaint();
        fw.dispatchEvent(new WindowEvent(fw, WindowEvent.WINDOW_CLOSING));
    }
}