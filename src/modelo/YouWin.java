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

public class YouWin extends JFrame implements ActionListener {

    JLabel l1;
    JButton b1, b2;
    int sw1 = 0;

    public YouWin() {
        l1 = new JLabel();
        b1 = new JButton();
        b2 = new JButton();
        setLayout(null);
        this.setTitle("NickName");

        ImageIcon intro = new ImageIcon("finished.png");
        l1.setIcon(new ImageIcon(intro.getImage().getScaledInstance(900, 600, Image.SCALE_SMOOTH)));
        ImageIcon play = new ImageIcon("retry.png");
        b1.setIcon(new ImageIcon(play.getImage().getScaledInstance(200, 80, Image.SCALE_SMOOTH)));

        ImageIcon lobby = new ImageIcon("exit2.png");
        b2.setIcon(new ImageIcon(lobby.getImage().getScaledInstance(200, 80, Image.SCALE_SMOOTH)));

        l1.setBounds(0, 0, 900, 560);
        b1.setBounds(285, 400, 200, 80);
        b2.setBounds(520, 400, 200, 80);

        b1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(b2);
        add(b1);
        add(l1);

        b1.addActionListener(this);
        b2.addActionListener(this);
        setSize(900, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            System.out.println("Opcion 1 ejecutada con exito");
            Interfaz1 i1 = new Interfaz1();
            this.dispose();

        }
        if (e.getSource() == b2) {
            System.out.println("Opcion 1 ejecutada con exito");
            System.exit(0);

        }
    }

}
