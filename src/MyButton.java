import javax.swing.*;
import java.awt.*;

public class MyButton extends JButton {

    public MyButton(String text) {
        this(text, Color.BLUE);
    }

    public MyButton(String text, Color color) {
        super(text);
        this.setForeground(color);
    }
}
