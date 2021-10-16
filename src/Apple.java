import javax.swing.*;
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

    public static void checkApple() {
        if (GameField.x[0] == Apple.getAppleX() && GameField.y[0] == Apple.getAppleY()) {
            GameField.dots++;
            Apple.createApple();
        }
    }
}
