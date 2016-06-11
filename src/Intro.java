import sun.applet.Main;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.io.File;

public class Intro extends JFrame {
    private int dialogheight;
    private boolean introDone;
    public Intro(){
        super("HYPE");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1920,1080);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        dialogheight=1080+450;
        introDone=false;
    }
    public void paint(Graphics g){
        super.paint(g);
        g.setColor(Color.BLACK);
        int rand=(int)(Math.random()*8);
            g.fillRect(0, 0, 1920, 1080);
            int r=(int)(Math.random()*10);
        if(rand!=0){
            g.setColor(Color.WHITE);
            g.setFont(new Font("Comic Sans MS", Font.PLAIN, 60));
            g.drawString("TOP KEK GAME STUDIOS SOFTWORKS PRESENTS.....", 300-r, dialogheight-400);
            g.drawString("TETRIS RELOADED 2K16:...", 300-r, dialogheight-200);
            g.setFont(new Font("Comic Sans MS", Font.PLAIN, 100));
            g.drawString("THE LEGEND CONTINUES!!!!!!!!!!!", 200-r, dialogheight + 50);
            g.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
            g.drawString("LEVEL AND WORLD DESIGN: TANER \"MAD DOG\" JONS", 950-r, dialogheight + 100);
            g.drawString("JONA \"Juicy J\" CALVO: RESEARCH AND DEVELOPMENT", 950-r, dialogheight + 150);
            g.drawString("CINEMATOGRAPHY: CHRIS \"BIG PAGA\" MINGE", 950-r, dialogheight + 200);
            g.drawString("REDDIT OUTREACH COMMITTEE: ALL THREE MUSKETEERS", 950-r, dialogheight + 250);
            g.drawString("INTEL: RENNATANNERT", 950-r, dialogheight + 300);
            g.drawString("CMINGE: COMMANDER", 950-r, dialogheight + 350);
            g.drawString("INVESTOR: WARREN \"GATES\" MUSK (ZUCKERBURGER)", 950-r, dialogheight + 400);
            g.drawString("in", 950-r, dialogheight + 450);
            g.drawString("memory", 950-r, dialogheight + 500);
            g.drawString("of obama", 950-r, dialogheight + 550);
            g.drawString("IN WORDS OF OBAMA, \"i is president\" -obama", 950-r, dialogheight + 600);
            int change = (int) (Math.random() * 15) - 5;
            dialogheight -= change;
        }
    }
    public static synchronized void playSound(final String url) {
        /*new Thread(new Runnable() {
            // The wrapper thread is unnecessary, unless it blocks on the
            // Clip finishing; see comments.
            public void run() {
                try {
                    Clip clip = AudioSystem.getClip();
                    AudioInputStream inputStream = AudioSystem.getAudioInputStream(
                            Main.class.getResourceAsStream(url));
                    clip.open(inputStream);
                    clip.start();
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
            }
        }).start();*/
        new AePlayWave("Skyrim.wav").start();
    }
    public boolean getIntroDone(){
        return introDone;
    }
    public void endIntro(){
        introDone=true;
    }
}
