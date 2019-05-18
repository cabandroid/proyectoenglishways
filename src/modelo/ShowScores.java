package modelo;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import java.io.*;

/**
 *
 * @author cenef
 */
public class ShowScores extends JFrame implements ActionListener {

    JLabel l1;
    JButton b11, b12;
    JTextArea jt1;
    int sw1 = 0;
    public String nickName;

    public ShowScores() {
        l1 = new JLabel();
        b11 = new JButton();
        b12 = new JButton();
        jt1 = new JTextArea();
        setLayout(null);
        this.setTitle("Instructions");

        ImageIcon intro = new ImageIcon("showScores.png");
        l1.setIcon(new ImageIcon(intro.getImage().getScaledInstance(900, 600, Image.SCALE_SMOOTH)));
        ImageIcon play = new ImageIcon("return.png");
        b11.setIcon(new ImageIcon(play.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
        ImageIcon boton = new ImageIcon("showScores2.png");
        b12.setIcon(new ImageIcon(boton.getImage().getScaledInstance(200, 70, Image.SCALE_DEFAULT)));

        l1.setBounds(0, 0, 900, 600);
        b11.setBounds(0, 0, 100, 100);
        b11.setBorderPainted(false);
        b12.setBounds(100, 100, 200, 70);
        jt1.setBounds(370, 100, 250, 380);

        b11.setCursor(new Cursor(Cursor.HAND_CURSOR));

        add(jt1);
        add(b11);
        add(b12);
        add(l1);

        b11.addActionListener(this);
        b12.addActionListener(this);
        setBounds(230, 63, 900, 620);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void ReadScoreAndNickNames() {
        File archivo;
        FileReader fr = null;
        try {
            archivo = new File("src\\file\\Score.txt");
            String linea = "";
            fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            System.out.println(br.readLine());
            while (linea != null) {
                linea = br.readLine();
                if (linea == null) {
                    break;
                }
                System.out.println(linea);

                jt1.append("*" + linea + "\n");
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == b11) {
            System.out.println("Opcion 1 ejecutada con exito");
            CoverPage c1 = new CoverPage();
            dispose();
        }
        if (e.getSource() == b12) {
            ReadScoreAndNickNames();
        }
    }

}
