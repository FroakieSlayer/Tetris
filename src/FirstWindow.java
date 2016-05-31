import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FirstWindow extends JFrame implements ActionListener {
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

        while(true){
            Block b = new Block();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e){

    }
}
