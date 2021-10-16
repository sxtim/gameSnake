import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Control {
    private static boolean right = true;
    private static boolean left = false;
    private static boolean up = false;
    private static boolean down = false;



    public static void move() {
        for (int i = GameField.dots; i > 0; i--) {
            GameField.x[i] = GameField.x[i - 1];
            GameField.y[i] = GameField.y[i - 1];
        }
        if (left) {
            GameField.x[0] -= GameField.DOT_SIZE;
        }
        if (right) {
            GameField.x[0] += GameField.DOT_SIZE;
        }
        if (up) {
            GameField.y[0] -= GameField.DOT_SIZE;
        }
        if (down) {
            GameField.y[0] += GameField.DOT_SIZE;
        }
    }

    static class FieldKeyListener extends KeyAdapter {
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
