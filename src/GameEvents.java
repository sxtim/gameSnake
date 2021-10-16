public class GameEvents {
    public static boolean inGame = true;

    public static void checkCollisions() {
        for (int i = GameField.dots; i > 0; i--) {
            if (i > 4 && GameField.x[0] == GameField.x[i] && GameField.y[0] == GameField.y[i])  // если голова сталкивается c телом
                inGame = false;

            if (GameField.x[0] > GameField.SIZE)
                inGame = false;

            if (GameField.x[0] < 0)
                inGame = false;

            if (GameField.y[0] > GameField.SIZE)
                inGame = false;

            if (GameField.y[0] < 0)
                inGame = false;
        }
    }

}
