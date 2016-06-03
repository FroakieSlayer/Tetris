import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
public class FirstWindow extends JFrame {
    private static final long serialVersionUID = 1L;
    private int[][] isFilled;
    private int delayForDrop;
    private int permDelay;
    private Block test;
    private Block b;
    private Block nextBlock;
    private int level = 1;
    private ArrayList<Point> landedPoints;
    private boolean gameOver;
    public FirstWindow(){
        super("Tetris 2K16 Reloaded: The Legend Continues");
        setSize(700,940);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        isFilled = new int[22][10];
        for(int i = 0; i<22; i++){
            for(int j=0;j<10;j++){
                isFilled[i][j]=-1;
            }
        }
        //this is the board and its 22,10 rows, columns. The first two rows are not displayed
        delayForDrop=750;
        permDelay=750;
        b=new Block();
        nextBlock=new Block();
        landedPoints=new ArrayList<Point>();
    }
    public void paint(Graphics g) {

        super.paint(g);
        if(gameOver){
            g.setColor(Color.WHITE);
            g.drawString("GAME OVER",200,200);
            try {
                Thread.sleep(5000);                 //1000 milliseconds is one second.
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }

        }
        if(!gameOver) {
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, 500, 940);
            g.setColor(Color.WHITE);

            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 20; j++) {
                    g.drawRect((i + 1) * 40, (j + 2) * 40, 40, 40);
                }
            }
            for (int i = 0; i < b.getPoints().length; i++) {
                if (b.getPoints()[i].getY() + b.Row() > 1) {
                    g.setColor(b.getPoints()[i].getColor());
                    g.fillRect((b.getPoints()[i].getX() + b.Column()) * 40 + 41, (b.getPoints()[i].getY() + b.Row()) * 40 + 1, 39, 39);
                }
            }

            for (int i = 0; i < landedPoints.size(); i++) {
                g.setColor(landedPoints.get(i).getColor());
                g.fillRect(landedPoints.get(i).getX() * 40 + 41, landedPoints.get(i).getY() * 40 + 1, 39, 39);
            }
            for (int i = 0; i < nextBlock.getPoints().length; i++) {
                g.setColor(nextBlock.getPoints()[i].getColor());
                g.fillRect(nextBlock.getPoints()[i].getX() * 40 + 541, nextBlock.getPoints()[i].getY() * 40 + 81, 39, 39);
            }
            g.setColor(Color.BLACK);
            g.drawString("LEVEL: "+level,581,281);
        }
    }
    public void setDelay(int d){
        delayForDrop=d;
    }
    public void revertDelay(){
        delayForDrop=permDelay;
    }
    public int getDelay(){
        return delayForDrop;
    }
    public Block getBlock(){
        return b;
    }
    public int[][] getFilled(){
        return isFilled;
    }
    public void generateBlock(){
        b=nextBlock;
        nextBlock=new Block();
    }
    public void landBlock(){
        for (int i = 0; i < b.getPoints().length; i++) {
            if(b.getPoints()[i].getY()+b.Row()<2)
                gameOver=true;
            landedPoints.add(new Point(b.getPoints()[i].getX()+b.Column(),b.getPoints()[i].getY()+b.Row(),b.getPoints()[i].getColor()));
            isFilled[b.getPoints()[i].getY() + b.Row()][b.getPoints()[i].getX() + b.Column()]=1;
        }
    }
    public void moveRight(){
        b.setTopLeft(b.Row(), b.Column()+1);
    }
    public void moveLeft(){
        b.setTopLeft(b.Row(), b.Column()-1);
    }
    public void moveDown(){
        b.setTopLeft(b.Row() + 1, b.Column());
    }
    public void rotate(){
        b.setPoints(test.getPoints());
    }
    public boolean canMoveRight(){
        for(int i=0; i<b.getPoints().length;i++){
            if(b.getPoints()[i].getX()+b.Column()>8 || isFilled[b.getPoints()[i].getY()+b.Row()][b.getPoints()[i].getX()+b.Column()+1]==1)
                return false;
        }
        return true;
    }
    public boolean canMoveLeft(){
        for(int i=0; i<b.getPoints().length;i++){
            if(b.getPoints()[i].getX()+b.Column()<1 || isFilled[b.getPoints()[i].getY()+b.Row()][b.getPoints()[i].getX()+b.Column()-1]==1)
                return false;
        }
        return true;
    }
    public boolean canRotate(){
        if(b.getPoints()[1].getColor()==Color.YELLOW)
            return false;
        test = new Block(b.rotate());
        for(int i=0;i<test.getPoints().length;i++){
            if(test.getPoints()[i].getX()+b.Column()>9 || test.getPoints()[i].getX()+b.Column()<0 || test.getPoints()[i].getY()+b.Row()>21 || test.getPoints()[i].getY()+b.Row()<2){
                return false;
            }
            if(isFilled[test.getPoints()[i].getY()+b.Row()][test.getPoints()[i].getX()+b.Column()]>0){
                return false;
            }
        }
        return true;
    }
    public boolean checkIfClear(int y){
        for(int i=0;i<10;i++){
            if(isFilled[y][i]==-1){
                return false;
            }
        }
        return true;
    }
    public void beginClearing(){
        int y = 21;
        while(checkIfClear(y)){
            for(int i=0; i<landedPoints.size();i++){
                if(landedPoints.get(i).getY()==y){
                    landedPoints.remove(i);
                    i--;
                }
            }
            for(int i=0;i<10;i++){
                isFilled[y][i]=-1;
            }
            y--;
        }
        int drop = 21-y;
        for(int i=20;i>=0;i--){
            for(int j=0;j<10;j++){
                if(isFilled[i][j]==1) {
                    isFilled[i + drop][j] = 1;
                    isFilled[i][j]=-1;
                }
            }
        }
        for(int i=0;i<landedPoints.size();i++){
            landedPoints.get(i).setY(landedPoints.get(i).getY()+drop);
        }
        delayForDrop-=50;
        level+=drop;
    }
    public void playSound() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("C:/Users/chris/Music/Song.wav").getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch(Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }
    }
    public boolean getGameOver(){
        return gameOver;
    }
}
