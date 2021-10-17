import javax.swing.*;

public class MainWindow extends JFrame {

        public static void main(String[] args) {
                MainWindow mw = new MainWindow();
        }

        public MainWindow() {
                setTitle("SNAKE");
                setDefaultCloseOperation(EXIT_ON_CLOSE);
                setSize(640,690);
                setLocation(800,200);
                startMenu();
                setVisible(true);
        }

        public void onGameOver() {
                System.out.println("onGameOver");
                replaceComponent(new GameOver(this));
        }

        public void startNewGame() {
                System.out.println("restart");
                replaceComponent(new GameField(this));
        }

        public void startMenu() {
                System.out.println("startMenu");
                replaceComponent(new Menu(this));
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
