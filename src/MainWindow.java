import javax.swing.*;

public class MainWindow extends JFrame {
        public static void main(String[] args) {
                MainWindow mw = new MainWindow();
        }

        public MainWindow() {
                setTitle("SNAKE");
                setDefaultCloseOperation(EXIT_ON_CLOSE);
                setSize(320,345);
                setLocation(1200,400);
                add(new GameField());
                setVisible(true);
        }

}
