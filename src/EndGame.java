import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class EndGame extends JFrame {
    private boolean quit;
    private boolean playAgain;
    public EndGame(String s) {
        quit=false;
        playAgain=false;
        JFrame frame = new JFrame("GAME OVER");
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        JLabel label = new JLabel(s);
        JButton quitButton = new JButton( new AbstractAction("Quit") {
            @Override
            public void actionPerformed( ActionEvent e ) {
                quit=true;
            }
        });
        quitButton.setText("QUIT");
        JButton replayButton = new JButton( new AbstractAction("Play again") {
            @Override
            public void actionPerformed( ActionEvent e ) {
                playAgain=true;
            }
        });
        replayButton.setText("PLAY AGAIN");
        panel.add(label);
        panel.add(replayButton);
        panel.add(quitButton);
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        frame.setSize(300, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
    public boolean getPlayAgain(){
        return playAgain;
    }
}
