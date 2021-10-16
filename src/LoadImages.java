import javax.swing.*;
import java.awt.*;

public class LoadImages {

    public static Image imageDot;

    public static void loadImages() {
        ImageIcon iia = new ImageIcon("apple.png");
        Apple.setImageApple(iia.getImage());

        ImageIcon iid = new ImageIcon("appleDot.png");
        imageDot = iid.getImage();
    }
}
