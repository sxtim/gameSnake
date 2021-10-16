import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameField extends JPanel implements ActionListener {

    public static final int SIZE = 640;
    public static int DOT_SIZE = 16;
    public static final int ALL_DOTS = 800;


    public static int[] x = new int[ALL_DOTS];
    public static int[] y = new int[ALL_DOTS];
    public static int dots; // размер змейки
    private Timer timer;


    public GameField() {
        setBackground(Color.BLACK);
        LoadImages.loadImages();
        initGame();
        addKeyListener(new Control.FieldKeyListener());
        setFocusable(true);
    }



    public void initGame() {
        dots = 3;
        for (int i = 0; i < dots; i++) {
            x[i] = 48 - i * DOT_SIZE;
            y[i] = 48;
        }
        timer = new Timer(200, this);
        timer.start();
        Apple.createApple();

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (GameEvents.inGame) {
            g.drawImage(Apple.getImageApple(), Apple.getAppleX(), Apple.getAppleY(), this);
            for (int i = 0; i < dots; i++) {
                g.drawImage(LoadImages.imageDot, x[i], y[i], this);
            }
        } else {
            String str = "Game Over";
            Font f = new Font("Arial", Font.BOLD, 14);
            g.setColor(Color.white);
             g.setFont(f);
            g.drawString(str, SIZE / 2, SIZE / 2);
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (GameEvents.inGame) {
            Control.move();
            Apple.checkApple();
            GameEvents.checkCollisions();
        }
        repaint();

    }









}



