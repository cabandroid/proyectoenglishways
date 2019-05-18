
package vista;

import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import modelo.Level1;


public class Interfaz extends JFrame{
    public Interfaz(){
        setTitle("Ejemplo Juego");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800,600);
        setLocationRelativeTo(null);
        setResizable(false);
        
        add(new Level1());
        
        
        
        setVisible(true);
    }
}
