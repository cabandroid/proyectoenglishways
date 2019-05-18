/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JTextField;
import vista.Interfaz1;

/**
 *
 * @author tibio
 */
public class NickName extends JFrame implements ActionListener {

    Score s;
    JLabel l1;
    JButton b1;
    JTextField jt1;
    //public String nickName;

    public NickName() {
        s = new Score();

        l1 = new JLabel();
        b1 = new JButton();
        jt1 = new JTextField();
        setLayout(null);
        this.setTitle("NickName");

        ImageIcon intro = new ImageIcon("nickname2.png");
        l1.setIcon(new ImageIcon(intro.getImage().getScaledInstance(890, 600, Image.SCALE_SMOOTH)));
        ImageIcon play = new ImageIcon("plat.png");
        b1.setIcon(new ImageIcon(play.getImage().getScaledInstance(170, 50, Image.SCALE_SMOOTH)));

        l1.setBounds(0, 0, 900, 560);
        b1.setBounds(527, 420, 167, 50);
        jt1.setBounds(527, 360, 210, 42);

        b1.setCursor(new Cursor(Cursor.HAND_CURSOR));

        add(jt1);
        add(b1);
        add(l1);

        b1.addActionListener(this);
        setBounds(230, 63, 900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String aux = jt1.getText();
        if (e.getSource() == b1) {
            s.setNickName(aux);
            s.file();
            System.out.println("" + aux);
            Interfaz1 v1 = new Interfaz1();
            this.setVisible(false);
            v1.setVisible(true);
        }
    }

}
