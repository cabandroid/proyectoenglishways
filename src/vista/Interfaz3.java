package vista;

import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import modelo.Level3;

public class Interfaz3 extends JFrame {

    public Interfaz3() {
        setTitle("Englishs Ways");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setResizable(false);

        add(new Level3());

        setVisible(true);
    }

}
