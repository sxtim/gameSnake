import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameField extends JPanel implements ActionListener {

    private static final int SIZE = 320;
    public static int DOT_SIZE = 16;
    private static final int ALL_DOTS = 400;
    private static Image imageDot;

    private int[] x = new int[ALL_DOTS];
    private int[] y = new int[ALL_DOTS];
    private int dots; // размер змейки
    private Timer timer;
    private boolean right = true;
    private boolean left = false;
    private boolean up = false;
    private boolean down = false;
    private boolean inGame = true;

    public GameField() {
        setBackground(Color.BLACK);
        loadImages();
        initGame();
        addKeyListener(new FieldKeyListener());
        setFocusable(true);
    }

    public static int getDOT_SIZE() {
        return DOT_SIZE;
    }

    public void initGame() {
        dots = 3;
        for (int i = 0; i < dots; i++) {
            x[i] = 48 - i * DOT_SIZE;
            y[i] = 48;
        }
        timer = new Timer(250, this);
        timer.start();
        Apple.createApple();

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (inGame) {
            g.drawImage(Apple.getImageApple(), Apple.getAppleX(), Apple.getAppleY(), this);
            for (int i = 0; i < dots; i++) {
                g.drawImage(imageDot, x[i], y[i], this);
            }
        } else {
            String str = "Game Over";
            //Font f = new Font("Arial",14,Font.BOLD);
            g.setColor(Color.white);
            // g.setFont(f);
            g.drawString(str, 125, SIZE / 2);
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (inGame) {
            move();
            checkApple();
            checkCollisions();
        }
        repaint();

    }

    public void move() {
        for (int i = dots; i > 0; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }
        if (left) {
            x[0] -= DOT_SIZE;
        }
        if (right) {
            x[0] += DOT_SIZE;
        }
        if (up) {
            y[0] -= DOT_SIZE;
        }
        if (down) {
            y[0] += DOT_SIZE;
        }
    }

    private void checkCollisions() {
        for (int i = dots; i > 0; i--) {
            if (i > 4 && x[0] == x[i] && y[0] == y[i])  // если голова сталкивается c собой
                inGame = false;

            if (x[0] > SIZE)
                inGame = false;

            if (x[0] < 0)
                inGame = false;

            if (y[0] > SIZE)
                inGame = false;

            if (y[0] < 0)
                inGame = false;


        }
    }

    public void checkApple() {
        if (x[0] == Apple.getAppleX() && y[0] == Apple.getAppleY()) {
            dots++;
            Apple.createApple();
        }
    }


    public static void loadImages() {
        ImageIcon iia = new ImageIcon("apple.png");
        Apple.setImageApple(iia.getImage());

        ImageIcon iid = new ImageIcon("appleDot.png");
        imageDot = iid.getImage();
    }

    class FieldKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);
            int key = e.getKeyCode();
            if (key == KeyEvent.VK_LEFT && !right) {
                left = true;
                up = false;
                down = false;
            }
            if (key == KeyEvent.VK_RIGHT && !left) {
                right = true;
                up = false;
                down = false;
            }

            if (key == KeyEvent.VK_UP && !down) {
                right = false;
                up = true;
                left = false;
            }
            if (key == KeyEvent.VK_DOWN && !up) {
                right = false;
                down = true;
                left = false;
            }
        }
    }



}



