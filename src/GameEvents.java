public class GameEvents {
    private final GameField gameField;
    public boolean inGame = true;

    public GameEvents(GameField gameField) {

        this.gameField = gameField;
    }

    public void checkCollisions() {
        for (int i = gameField.dots; i > 0; i--) {
            if (i > 4 && gameField.x[0] == gameField.x[i] && gameField.y[0] == gameField.y[i])  // если голова сталкивается c телом
                inGame = false;

            if (gameField.x[0] > GameField.SIZE)
                inGame = false;

            if (gameField.x[0] < 0)
                inGame = false;

            if (gameField.y[0] > GameField.SIZE)
                inGame = false;

            if (gameField.y[0] < 0)
                inGame = false;
        }
    }

}
