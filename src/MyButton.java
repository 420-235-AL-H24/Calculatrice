import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyButton extends JButton implements ActionListener {

    public static MyButton createButton(String text) {
        if (text.length() == 1 && Character.isDigit(text.charAt(0)))
            return new NumberButton(text);
        else
            return new OperatorButton(text);
    }

    protected MyButton(String text, Color color) {
        super(text);
        this.setForeground(color);
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Calculatrice.resultField.setText(this.getText());
    }

    @Override
    public String toString() {
        return "B{" + getText() + "}";
    }
}
