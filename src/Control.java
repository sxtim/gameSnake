import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Control {
    private static boolean right = true;
    private static boolean left = false;
    private static boolean up = false;
    private static boolean down = false;



    public static void move(GameField gameField) {
        for (int i = gameField.dots; i > 0; i--) {
            gameField.x[i] = gameField.x[i - 1];
            gameField.y[i] = gameField.y[i - 1];
        }
        if (left) {
            gameField.x[0] -= GameField.DOT_SIZE;
        }
        if (right) {
            gameField.x[0] += GameField.DOT_SIZE;
        }
        if (up) {
            gameField.y[0] -= GameField.DOT_SIZE;
        }
        if (down) {
            gameField.y[0] += GameField.DOT_SIZE;
        }
    }

    static class FieldKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);
            System.out.println("key pressed e= " + e.getKeyCode());
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
