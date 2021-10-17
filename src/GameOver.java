import javax.swing.*;
import java.awt.*;

public class GameOver extends JPanel {
    private final MainWindow mainWindow;

    public GameOver(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        setBackground(Color.pink);
        setLayout(null);
        JLabel label = new JLabel("GAME OVER");
        label.setBounds(GameField.SIZE / 2 - 75, 25, 200, 100);
        label.setFont(new Font("Serif", Font.BOLD, 20));


        Button restartButton = new Button("RESTART");
        restartButton.setBounds(GameField.SIZE / 2 - 100, 200, 200, 50);
        restartButton.setFont(new Font("Serif", Font.PLAIN, 25));
        restartButton.addActionListener(d -> {
            restartButton.setFocusable(false);
            mainWindow.startNewGame();
        });

        Button menuButton = new Button("MENU");
        menuButton.setBounds(GameField.SIZE / 2 - 100, 275, 200, 50);
        menuButton.setFont(new Font("Serif", Font.PLAIN, 25));
        menuButton.addActionListener(d -> {
            restartButton.setFocusable(false);
            mainWindow.startMenu();
        });

        add(menuButton);

        add(restartButton);
        add(label);
    }
}
