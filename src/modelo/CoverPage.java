package modelo;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author cenef
 */
public class CoverPage extends JFrame implements ActionListener {
    
    JLabel l1;
    JButton b1, b2, b3;
    int sw1 = 0;
    
    public CoverPage() {
        l1 = new JLabel();
        b1 = new JButton();
        b2 = new JButton("Scores");
        b3 = new JButton("Salir");
        setLayout(null);
        this.setTitle("Englishs Ways");
        
        ImageIcon background = new ImageIcon("intro3.png");
        l1.setIcon(new ImageIcon(background.getImage().getScaledInstance(900, 600, Image.SCALE_SMOOTH)));
        ImageIcon play = new ImageIcon("plat.png");
        b1.setIcon(new ImageIcon(play.getImage().getScaledInstance(170, 50, Image.SCALE_SMOOTH)));
        ImageIcon scores = new ImageIcon("scores.png");
        b2.setIcon(new ImageIcon(scores.getImage().getScaledInstance(180, 50, Image.SCALE_SMOOTH)));
        ImageIcon exit = new ImageIcon("exit.png");
        b3.setIcon(new ImageIcon(exit.getImage().getScaledInstance(180, 50, Image.SCALE_SMOOTH)));
        
        l1.setBounds(0, 0, 900, 560);
        b1.setBounds(580, 320, 167, 50);
        b2.setBounds(580, 385, 167, 50);
        b3.setBounds(580, 453, 167, 50);

        //Cursor 
        b1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b3.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        add(b1);
        add(b2);
        add(b3);
        add(l1);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        setBounds(230, 62, 900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //1setDefaultCloseOperation();
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == b1) {
            NickName n1 = new NickName();
            this.setVisible(false);
            n1.setVisible(true);
            
        }
        if (e.getSource() == b2) {
            
            ShowScores sc = new ShowScores();
            this.setVisible(false);
            sc.setVisible(true);
        }
        if (e.getSource() == b3) {
            System.exit(0);
        }
        
    }
    
}
