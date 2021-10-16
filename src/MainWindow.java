import javax.swing.*;

public class MainWindow extends JFrame {

        public static void main(String[] args) {
                MainWindow mw = new MainWindow();
        }

        public MainWindow() {
                setTitle("SNAKE");
                setDefaultCloseOperation(EXIT_ON_CLOSE);
                setSize(640,690);
                setLocation(1200,400);
                startNewGame();
                setVisible(true);
        }

        public void onGameOver() {
                System.out.println("onGameOver");
                replaceComponent(new GameOver(this));
        }

        public void startNewGame() {
                System.out.println("startNewGame");
                replaceComponent(new GameField(this));
        }

        private void replaceComponent(JComponent comp) {
                getContentPane().removeAll();
                getContentPane().add(comp);
                validate();
                repaint();
                setVisible(true);
                comp.requestFocus();
        }
}
