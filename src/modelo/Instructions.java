package modelo;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Instructions extends JFrame implements ActionListener {

    JLabel l1;
    JButton b11;
    int sw1 = 0;
    public String nickName;

    public Instructions() {
        l1 = new JLabel();
        b11 = new JButton();
        setLayout(null);
        this.setTitle("Instructions");

        ImageIcon intro = new ImageIcon("instructionss.png");
        l1.setIcon(new ImageIcon(intro.getImage().getScaledInstance(600, 300, Image.SCALE_SMOOTH)));
        ImageIcon play = new ImageIcon("return.png");
        b11.setIcon(new ImageIcon(play.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH)));

        l1.setBounds(0, 0, 600, 300);
        b11.setBounds(0, 0, 80, 80);
        b11.setBorderPainted(false);

        b11.setCursor(new Cursor(Cursor.HAND_CURSOR));

        add(b11);
        add(l1);

        b11.addActionListener(this);
        setBounds(230, 63, 600, 330);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == b11) {
            System.out.println("Opcion 1 ejecutada con exito");
            dispose();

        }

    }

}
