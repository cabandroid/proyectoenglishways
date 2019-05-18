package modelo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Level3 extends JPanel implements Runnable, KeyListener, ILimits, ActionListener {

    Score s = new Score();

    private Image player;
    private Image background;
    private Image menu;
    private Thread hilo;
    private int x, y, dx, dy;
    private final int RETARDO = 7;
    private boolean canJump;
    private Clip clip, clip2;
    private String routeMusic = "/sound/";
    private int cont = 0;
    JLabel n1;
    JLabel n2;
    JLabel n3;
    JLabel n4;
    JLabel n5;
    JLabel n6;
    JLabel n7;
    JLabel n8;
    JLabel n9;
    JLabel d1;
    JLabel d2;
    JLabel e1;
    JLabel e2;
    JMenuBar mb1;
    JMenu m1;
    JMenuItem mi1, mi2;

    public Level3() {

        background = new ImageIcon(this.getClass().getResource("/img/Level3.png")).getImage().getScaledInstance(800, 600, Image.SCALE_AREA_AVERAGING);
        setLayout(null);
        setBackground(Color.WHITE);
        setDoubleBuffered(false);
        player = new ImageIcon(this.getClass().getResource("/img/KingEs2.gif")).getImage();
        menu = new ImageIcon(this.getClass().getResource("/img/menu.png")).getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT);
        x = 40;
        y = 440;
        ImageIcon mute = new ImageIcon("mute.png");
        ImageIcon inst = new ImageIcon("inst.png");
        n1 = new JLabel();
        n2 = new JLabel();
        n3 = new JLabel();
        n4 = new JLabel();
        n5 = new JLabel();
        n6 = new JLabel();
        n7 = new JLabel();
        n8 = new JLabel();
        n9 = new JLabel();
        //Door
        d1 = new JLabel();
        d2 = new JLabel();
        //Stairs
        e1 = new JLabel();
        e2 = new JLabel();
        //menu
        mb1 = new JMenuBar();
        mb1.setBackground(new Color(0, 0, 0, 0));
        add(mb1).setBounds(5, 5, 60, 60);

        m1 = new JMenu("opcion");
        m1.setBackground(new Color(0, 0, 0, 0));
        mb1.add(m1);
        mi1 = new JMenuItem();
        mi1.setIcon(new ImageIcon(mute.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT)));
        mi1.setBackground(new Color(0, 0, 0, 0));
        m1.add(mi1);
        mi1.addActionListener(this);
        mi2 = new JMenuItem();
        mi2.setIcon(new ImageIcon(inst.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT)));
        mi2.setBackground(new Color(0, 0, 0, 0));
        m1.add(mi2);
        mi2.addActionListener(this);

        n1.setBounds(new Rectangle(50, 470, 170, 60));
        n2.setBounds(new Rectangle(260, 360, 50, 60));
        n3.setBounds(new Rectangle(0, 250, 180, 50));
        n4.setBounds(new Rectangle(240, 140, 100, 50));
        n5.setBounds(new Rectangle(460, 140, 50, 50));
        n6.setBounds(new Rectangle(640, 410, 140, 50));
        n7.setBounds(new Rectangle(680, 90, 100, 50));

        //Door
        d1.setBounds(new Rectangle(740, 40, 50, 50));
        d2.setBounds(new Rectangle(640, 360, 50, 50));
        //Stairs       
        e1.setBounds(new Rectangle(700, 190, 35, 380));

        add(n1);
        add(n2);
        add(n3);
        add(n4);
        add(n5);
        add(n6);
        add(n7);
        add(n8);
        add(d1);
        add(d2);
        add(e1);
        add(e2);

        addKeyListener(this);
        setFocusable(true);
    }

    @Override
    public void run() {
        music("3");
        while (true) {
            death("uh");
            gravity(n1, n2, n3, n4, n5, n6, n7, n8, e1, n9);
            repaint();
            move(dx, dy);
            try {
                Thread.sleep(RETARDO);
                canJump = false;
            } catch (InterruptedException err) {
                System.out.println(err);
            }
        }
    }
    int key;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_A:
            case KeyEvent.VK_LEFT:
                if (x > 0) {
                    dx = -1;
                    panelLimitsLeft(n1);
                    panelLimitsLeft(n2);
                    panelLimitsLeft(n3);
                    panelLimitsLeft(n4);
                    panelLimitsLeft(n5);
                    panelLimitsLeft(n6);
                }
                player = new ImageIcon(this.getClass().getResource("/img/King2.gif")).getImage();

                break;
            case KeyEvent.VK_D:
            case KeyEvent.VK_RIGHT:
                if (x < 800) {
                    dx = 1;
                    panelLimitsRight(n1);
                    panelLimitsRight(n2);
                    panelLimitsRight(n3);
                    panelLimitsRight(n4);
                    panelLimitsRight(n5);
                    panelLimitsRight(n6);
                }
                player = new ImageIcon(this.getClass().getResource("/img/King.gif")).getImage();
                break;
            case KeyEvent.VK_W:
            case KeyEvent.VK_UP:
                if (y > 0 + 5) {
                    panelLimitsUpStairs(e1);
                    panelLimitsUpStairs(e2);
                }
                break;
            case KeyEvent.VK_S:
            case KeyEvent.VK_DOWN:
                if (y < 500) {
                    panelLimitsDownStairs(e1);
                    panelLimitsDownStairs(e2);
                }
                break;
            case KeyEvent.VK_SPACE:
                canJump = true;
                jump(5);
                break;
            case KeyEvent.VK_ENTER:
                addScore(d1, d2);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_A:
            case KeyEvent.VK_LEFT:
                dx = 0;
                player = new ImageIcon(this.getClass().getResource("/img/KingEs1.gif")).getImage();
                break;
            case KeyEvent.VK_D:
            case KeyEvent.VK_RIGHT:
                dx = 0;
                player = new ImageIcon(this.getClass().getResource("/img/KingEs2.gif")).getImage();
                break;
            case KeyEvent.VK_W:
            case KeyEvent.VK_UP:

                break;
            case KeyEvent.VK_S:
            case KeyEvent.VK_DOWN:

                break;
            case KeyEvent.VK_SPACE:
                jump(0);
                break;
        }
    }

    @Override
    public void addNotify() {
        super.addNotify();
        hilo = new Thread(this);
        hilo.start();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(background, 0, 0, null);
        g2.drawImage(player, x, y, null);
        g2.drawImage(menu, 0, 0, null);

        g2.setFont(new Font("verdana", Font.CENTER_BASELINE, 20));
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.drawString("SCORE: " + s.getScore(), 600, 550);

        //pregunta
        g2.setFont(new Font("verdana", Font.CENTER_BASELINE, 15));
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.drawString("What is \"Does\" used for?", 300, 20);
        //respuestas
        g2.setColor(Color.getHSBColor(195, 100, 111));

        g2.drawString("Third person.", 680, 50);

        g2.drawString("First person.", 610, 370);
    }

    public void gravity(JLabel p1, JLabel p2, JLabel p3, JLabel p4, JLabel p5, JLabel p6, JLabel p7, JLabel p8, JLabel e1, JLabel p9) {
        if ((x >= e1.getX() - (e1.getWidth() / 3)) && (x <= e1.getX() + (e1.getWidth())) && (y <= e1.getY() + e1.getHeight()) && (y >= e1.getY() - (e1.getHeight() / 3))) {
            y += 0;
        } else if ((x >= p9.getX() - (p9.getWidth() / 7)) && (x <= p9.getX() + (p9.getWidth())) && (y >= p9.getY() - (p9.getHeight() / 2)) && (y <= p9.getY() + p9.getHeight())) {
            y += 0;
        } else if ((x >= p8.getX() - (p8.getWidth() / 7)) && (x <= p8.getX() + (p8.getWidth())) && (y >= p8.getY() - (p8.getHeight() / 2)) && (y <= p8.getY() + p8.getHeight())) {
            y += 0;
        } else if ((x >= p7.getX() - (p7.getWidth() / 7)) && (x <= p7.getX() + (p7.getWidth())) && (y >= p7.getY() - (p7.getHeight() / 2)) && (y <= p7.getY() + p7.getHeight())) {
            y += 0;
        } else if ((x >= p6.getX() - (p6.getWidth() / 7)) && (x <= p6.getX() + (p6.getWidth())) && (y >= p6.getY() - (p6.getHeight() / 2)) && (y <= p6.getY() + p6.getHeight())) {
            y += 0;
        } else if ((x >= p5.getX() - (p5.getWidth() / 7)) && (x <= p5.getX() + (p5.getWidth())) && (y >= p5.getY() - (p5.getHeight() / 2)) && (y <= p5.getY() + p5.getHeight())) {
            y += 0;
        } else if ((x >= p4.getX() - (p4.getWidth() / 7)) && (x <= p4.getX() + (p4.getWidth())) && (y >= p4.getY() - (p4.getHeight() / 2)) && (y <= p4.getY() + p4.getHeight())) {
            y += 0;
        } else if ((x >= p3.getX() - (p3.getWidth() / 7)) && (x <= p3.getX() + (p3.getWidth())) && (y >= p3.getY() - (p3.getHeight() / 2)) && (y <= p3.getY() + p3.getHeight())) {
            y += 0;
        } else if ((x >= p2.getX() - (p2.getWidth() / 7)) && (x <= p2.getX() + (p2.getWidth())) && (y >= p2.getY() - (p2.getHeight() / 2)) && (y <= p2.getY() + p2.getHeight())) {
            y += 0;
        } else if ((x >= p1.getX() - (p1.getWidth() / 7)) && (x <= p1.getX() + (p1.getWidth())) && (y >= p1.getY() - (p1.getHeight() / 2)) && (y <= p1.getY() + p1.getHeight())) {
            y += 0;
        } else if (y >= 450) {
            y += 0;
            clip.stop();
        } else {
            y += 2;
        }
    }

    public void jump(int jump) {
        if (canJump) {
            dy -= jump;
        } else {
            dy = 0;
        }
    }

    public void move(int dx, int dy) {
        x += dx;
        y += dy;
    }

    public void music(String sound) {
        try {
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(getClass().getResource(routeMusic + sound + ".wav")));
            clip.start();
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void addScore(JLabel p1, JLabel p2) {
        if ((x >= p1.getX() - (p1.getWidth() / 3)) && (x <= p1.getX() + (p1.getWidth())) && (y <= p1.getY() + p1.getHeight()) && (y >= p1.getY() - (p1.getHeight() / 3))) {
            YouWin win = new YouWin();
            s.setScore(s.getScore() + 50);
            s.mostrar();
            s.fileScore(3);
            clip.stop();
            win.setVisible(true);
        }
        if ((x >= p2.getX() - (p2.getWidth() / 3)) && (x <= p2.getX() + (p2.getWidth())) && (y <= p2.getY() + p2.getHeight()) && (y >= p2.getY() - (p2.getHeight() / 3))) {
            YouWin win = new YouWin();
            s.setScore(s.getScore() - 50);
            s.mostrar();
            s.fileScore(3);
            clip.stop();
            win.setVisible(true);
        }
    }

    public void death(String sound) {
        if (y >= 445 && y <= 445) {
            try {
                player = new ImageIcon(this.getClass().getResource("/img/Kill.gif")).getImage();
                clip2 = AudioSystem.getClip();
                clip2.open(AudioSystem.getAudioInputStream(getClass().getResource(routeMusic + sound + ".wav")));
                clip2.start();
            } catch (Exception e) {
                e.getMessage();
            }
            YouLoseAlert al = new YouLoseAlert();
            al.setVisible(true);
        }
    }

    @Override
    public void panelLimitsRight(JLabel p1) {
        if ((x >= p1.getX() - (p1.getWidth() / 3)) && (x <= p1.getX() + (p1.getWidth())) && (y <= p1.getY() + p1.getHeight()) && (y >= p1.getY() - (p1.getHeight() / 3))) {
            dx = 0;
        }
    }

    @Override
    public void panelLimitsLeft(JLabel p1) {
        if ((x >= p1.getX() - (p1.getWidth() / 3)) && (x <= p1.getX() + (p1.getWidth())) && (y <= p1.getY() + p1.getHeight()) && (y >= p1.getY() - (p1.getHeight() / 3))) {
            dx = 0;
        }
    }

    @Override
    public void panelLimitsUpStairs(JLabel p1) {
        if ((x >= p1.getX() - (p1.getWidth() / 3)) && (x <= p1.getX() + (p1.getWidth())) && (y <= p1.getY() + p1.getHeight()) && (y >= p1.getY() - (p1.getHeight() / 3))) {
            y -= 3;
            player = new ImageIcon(this.getClass().getResource("/img/Up.gif")).getImage();
        }
    }

    @Override
    public void panelLimitsDownStairs(JLabel p1) {
        if ((x >= p1.getX() - (p1.getWidth() / 3)) && (x <= p1.getX() + (p1.getWidth())) && (y <= p1.getY() + (p1.getHeight() / 2)) && (y >= p1.getY() - (p1.getHeight() / 2))) {
            y += 3;
            player = new ImageIcon(this.getClass().getResource("/img/Up.gif")).getImage();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == mi1) {
            System.out.println("Opcion 1 ejecutada con exito");
            if (cont % 2 == 0) {
                clip.stop();
            } else {
                clip.start();
            }
            cont++;
        }
        if (e.getSource() == mi2) {
            Instructions ins = new Instructions();
            ins.setVisible(true);
        }
    }
}
