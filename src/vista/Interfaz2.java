package vista;

import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import modelo.Level2;

public class Interfaz2 extends JFrame {

    public Interfaz2() {
        setTitle("Englishs Ways");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setResizable(false);

        add(new Level2());

        setVisible(true);
    }

}
