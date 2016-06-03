import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.io.File;

public class Intro extends JFrame {
    private int dialogheight;
    public Intro(){
        super("HYPE");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1920,1080);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        dialogheight=1080;
    }
    public void paint(Graphics g){
        super.paint(g);
        g.setColor(Color.BLACK);
        int rand=(int)(Math.random()*8);
            g.fillRect(0, 0, 1920, 1080);
        if(rand!=0){
            g.setColor(Color.WHITE);
            g.drawString("TETRIS RELOADED 2K16:...", 950, dialogheight);
            g.drawString("THE LEGEND CONTINUES!!!!!!!!!!!", 950, dialogheight + 50);
            g.drawString("LEVEL AND WORLD DESIGN: TANER \"MAD DOG\" JONS", 950, dialogheight + 100);
            g.drawString("JONA \"Juicy J\" CALVO: RESEARCH AND DEVELOPMENT", 950, dialogheight + 150);
            g.drawString("CINEMATOGRAPHY: CHRIS \"BIG PAGA\" MINGE", 950, dialogheight + 200);
            g.drawString("REDDIT OUTREACH COMMITTEE: ALL THREE MUSKETEERS", 950, dialogheight + 250);
            g.drawString("INTEL: RENNATANNERT", 950, dialogheight + 300);
            g.drawString("CMINGE: COMMANDER", 950, dialogheight + 350);
            g.drawString("INVESTOR: WARREN \"GATES\" MUSK (ZUCKERBURGER)", 950, dialogheight + 400);
            g.drawString("in", 950, dialogheight + 450);
            g.drawString("memory", 950, dialogheight + 500);
            g.drawString("of obama", 950, dialogheight + 550);
            g.drawString("IN WORDS OF OBAMA, \"i is president\" -obama", 950, dialogheight + 600);
            int change = (int) (Math.random() * 15) - 5;
            dialogheight -= change;
        }
    }
    public void playSound() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:/Users/chris/Music/Skyrim.wav").getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch(Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }
    }

}
