package vista;

import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import modelo.Level1;

public class Interfaz1 extends JFrame {

    public Interfaz1() {
        setTitle("Englishs Ways");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setResizable(false);

        add(new Level1());

        setVisible(true);
    }

    public void salir() {
        System.exit(0);
    }
}
