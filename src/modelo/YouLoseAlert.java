package modelo;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import vista.Interfaz1;

/**
 *
 * @author tibio
 */
public class YouLoseAlert extends JFrame implements ActionListener {

    JLabel l1;
    JButton b1, b2;
    int sw1 = 0;

    public YouLoseAlert() {
        l1 = new JLabel();
        b1 = new JButton();
        b2 = new JButton();
        setLayout(null);
        this.setTitle("NickName");

        ImageIcon intro = new ImageIcon("loseControl.png");
        l1.setIcon(new ImageIcon(intro.getImage().getScaledInstance(600, 300, Image.SCALE_SMOOTH)));
        ImageIcon play = new ImageIcon("replay.png");
        b1.setIcon(new ImageIcon(play.getImage().getScaledInstance(170, 50, Image.SCALE_SMOOTH)));

        ImageIcon lobby = new ImageIcon("lobby.png");
        b2.setIcon(new ImageIcon(lobby.getImage().getScaledInstance(170, 50, Image.SCALE_SMOOTH)));

        l1.setBounds(0, 0, 600, 300);
        b1.setBounds(150, 160, 155, 40);
        b2.setBounds(325, 160, 155, 40);

        b1.setCursor(new Cursor(Cursor.HAND_CURSOR));

        add(b2);
        add(b1);
        add(l1);

        b1.addActionListener(this);
        b2.addActionListener(this);
        setBounds(400, 250, 600, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            System.out.println("Opcion 1 ejecutada con exito");
            //NickName v1 = new NickName();
            Interfaz1 in1 = new Interfaz1();
            l1.setVisible(false);
            this.dispose();
        }
        if (e.getSource() == b2) {
            System.out.println("Opcion 1 ejecutada con exito");
            CoverPage v1 = new CoverPage();
            this.dispose();

        }
    }

}
