import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameField extends JPanel implements ActionListener {

    private static final int SIZE = 320;
    private static final int DOT_SIZE = 16;
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

    public GameField(){
        setBackground(Color.BLACK);
        loadImages();
        initGame();
    }

    public void initGame(){
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
        if(inGame){
            g.drawImage(Apple.getImageApple(), Apple.getAppleX(), Apple.getAppleY(),this);
            for (int i = 0; i < dots; i++) {
                g.drawImage(imageDot, x[i], y[i],this);
            }
        }
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if(inGame){

        }
        repaint();

    }

    public static void loadImages() {
        ImageIcon iia = new ImageIcon("apple.png");
        Apple.setImageApple(iia.getImage());

        ImageIcon iid = new ImageIcon("appleDot.png");
        imageDot = iid.getImage();
    }


    public static int getDOT_SIZE() {
        return DOT_SIZE;
    }

}
