import javax.swing.*;
import java.awt.*;

public class GameOver extends JPanel {
    private final MainWindow mainWindow;

    public GameOver(MainWindow mainWindow) {
        this.mainWindow = mainWindow;

        add(new JLabel("Game over"));
        Button button = new Button("Start again");
        button.addActionListener(d -> {
            button.setFocusable(false);
            mainWindow.startNewGame();
        });
        add(button);
    }
}
