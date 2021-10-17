import java.awt.*;
import java.util.Random;

public class Apple {
    private static Image imageApple;
    private static int appleX;
    private static int appleY;

    public static void setImageApple(Image imageApple) {
        Apple.imageApple = imageApple;
    }

    public static Image getImageApple() {
        return imageApple;
    }

    public static int getAppleX() {
        return appleX;
    }

    public static int getAppleY() {
        return appleY;
    }

    public static void createApple() {
        appleX = new Random().nextInt(20) * GameField.DOT_SIZE;
        appleY = new Random().nextInt(20) * GameField.DOT_SIZE;
    }

    public static void checkApple(GameField gameField) {
        if (gameField.x[0] == appleX && gameField.y[0] == appleY) {
            gameField.dots++;
            Apple.createApple();
        }
    }
}
