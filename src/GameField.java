import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameField extends JPanel implements ActionListener {

    public static final int SIZE = 640;
    public static int DOT_SIZE = 16;
    public static final int ALL_DOTS = 800;


    public int[] x = new int[ALL_DOTS];
    public int[] y = new int[ALL_DOTS];
    public int dots; // размер змейки
    private final MainWindow mainWindow;
    private Timer timer;

    private GameEvents gameEvents = new GameEvents(this);


    public GameField(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        setBackground(Color.BLACK);
        LoadImages.loadImages();
        initGame();
        addKeyListener(new Control.FieldKeyListener());
        setFocusable(true);
        grabFocus();
    }



    public void initGame() {
        dots = 3;
        for (int i = 0; i < dots; i++) {
            x[i] = 48 - i * DOT_SIZE;
            y[i] = 48;
        }
        timer = new Timer(240, this);
        timer.start();
        Apple.createApple();

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (gameEvents.inGame) {
            g.drawImage(Apple.getImageApple(), Apple.getAppleX(), Apple.getAppleY(), this);
            for (int i = 0; i < dots; i++) {
                g.drawImage(LoadImages.imageDot, x[i], y[i], this);
            }
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (gameEvents.inGame) {
            Control.move(this);
            Apple.checkApple(this);
            gameEvents.checkCollisions();

            repaint();
        } else {
            timer.stop();
            mainWindow.onGameOver();
        }
    }
}



