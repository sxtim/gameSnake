import javax.swing.*;
import java.awt.*;

public class Menu extends JPanel{
    private final MainWindow mainWindow;


    public Menu(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
        setBackground(Color.gray);
        setLayout(null);
        JLabel label = new JLabel("MENU");
        label.setBounds(GameField.SIZE / 2 - 45, 25, 200, 100);
        label.setFont(new Font("Serif", Font.BOLD, 20));



        Button button = new Button("Start Game");
        button.setFont(new Font("Serif", Font.PLAIN, 25));
        button.setBounds(GameField.SIZE / 2 - 100,125, 200, 50);
        button.addActionListener(d -> {
            button.setFocusable(false);
            mainWindow.startNewGame();
        });
        add(button);
        add(label);
    }
}
