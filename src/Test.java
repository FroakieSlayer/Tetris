import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;

public class Test extends JComponent {
    public static void main(String [] args) {
        Intro intro = new Intro();
        intro.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_ESCAPE:
                        intro.endIntro();
                        break;
                }
            }
        });
        intro.setVisible(true);
        //intro.playSound();
        for (int i = 0; i < 750; i++) {
            if (intro.getIntroDone())
                break;
            intro.repaint();
            try {
                Thread.sleep(150);                 //1000 milliseconds is one second.
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
        intro.setVisible(false);
        FirstWindow fw = new FirstWindow();
        fw.setVisible(true);
        fw.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_S:
                        try {
                            Thread.sleep(20);                 //1000 milliseconds is one second.
                        } catch (InterruptedException ex) {
                            Thread.currentThread().interrupt();
                        }
                        fw.setDelay(100);
                        fw.repaint();
                        break;
                    case KeyEvent.VK_DOWN:
                        try {
                            Thread.sleep(12);                 //1000 milliseconds is one second.
                        } catch (InterruptedException ex) {
                            Thread.currentThread().interrupt();
                        }
                        fw.setDelay(100);
                        fw.repaint();
                        break;
                    case KeyEvent.VK_A:
                        if (fw.canMoveLeft()) {
                            try {
                                Thread.sleep(12);                 //1000 milliseconds is one second.
                            } catch (InterruptedException ex) {
                                Thread.currentThread().interrupt();
                            }
                            fw.moveLeft();
                            fw.repaint();
                        }
                        break;
                    case KeyEvent.VK_LEFT:
                        if (fw.canMoveLeft()) {
                            try {
                                Thread.sleep(12);                 //1000 milliseconds is one second.
                            } catch (InterruptedException ex) {
                                Thread.currentThread().interrupt();
                            }
                            fw.moveLeft();
                            fw.repaint();
                        }
                        break;
                    case KeyEvent.VK_D:
                        if (fw.canMoveRight()) {
                            try {
                                Thread.sleep(12);                 //1000 milliseconds is one second.
                            } catch (InterruptedException ex) {
                                Thread.currentThread().interrupt();
                            }
                            fw.moveRight();
                            fw.repaint();
                        }
                        break;
                    case KeyEvent.VK_RIGHT:
                        if (fw.canMoveRight()) {
                            try {
                                Thread.sleep(12);                 //1000 milliseconds is one second.
                            } catch (InterruptedException ex) {
                                Thread.currentThread().interrupt();
                            }
                            fw.moveRight();
                            fw.repaint();
                        }
                        break;
                    case KeyEvent.VK_W:
                        if (fw.canRotate()) {
                            try {
                                Thread.sleep(12);                 //1000 milliseconds is one second.
                            } catch (InterruptedException ex) {
                                Thread.currentThread().interrupt();
                            }
                            fw.rotate();
                            fw.repaint();
                        }
                        break;
                    case KeyEvent.VK_UP:
                        if (fw.canRotate()) {
                            try {
                                Thread.sleep(12);                 //1000 milliseconds is one second.
                            } catch (InterruptedException ex) {
                                Thread.currentThread().interrupt();
                            }
                            fw.rotate();
                            fw.repaint();
                        }
                        break;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_S:
                        fw.revertDelay();
                        fw.repaint();
                        break;
                    case KeyEvent.VK_DOWN:
                        fw.revertDelay();
                        fw.repaint();
                        break;
                }
            }
        });
        //fw.playSound();
        int x=0;
        while (x<1) {
            while (!fw.getGameOver()) {
                try {
                    Thread.sleep(fw.getDelay());                 //1000 milliseconds is one second.
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
                for (int i = 0; i < fw.getBlock().getPoints().length; i++) {
                    if (fw.getBlock().getPoints()[i].getY() + fw.getBlock().getTopLeft().getY() == 21 || fw.getFilled()[fw.getBlock().getPoints()[i].getY() + fw.getBlock().getTopLeft().getY() + 1][fw.getBlock().getPoints()[i].getX() + fw.getBlock().getTopLeft().getX()].getLanded() > 0) {
                        fw.landBlock();
                        fw.generateBlock();
                        break;
                    }
                }
                fw.repaint();
                fw.moveDown();
                boolean b = true;
                while (b) {
                    b = false;
                    for (int p = 21; p >= 0; p--) {
                        if (fw.checkIfClear(p)) {
                            fw.beginClearing(21);
                            b = true;
                        }
                    }
                }
            }
            fw.repaint();
            fw.setVisible(false);
            EndGame end = new EndGame("FINAL LEVEL: "+fw.getLevel());
            boolean playAgain;
            int z=0;
            for(int i=0;i<10000;i+=10) {
                try {
                    Thread.sleep(10);                 //1000 milliseconds is one second.
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
                if(z>0){
                    break;
                }
            }
            playAgain=end.getPlayAgain();
            if(playAgain) {
                fw.setVisible(true);
                continue;
            }
            else
                fw.dispose();
        }

    }
}