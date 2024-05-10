import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyButton extends JButton implements ActionListener {

    public MyButton(String text) {
        this(text, Color.BLUE);
    }

    public MyButton(String text, Color color) {
        super(text);
        this.setForeground(color);
        this.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (Character.isDigit(this.getText().charAt(0)))
            Calculatrice.resultField.setText(Calculatrice.resultField.getText() + this.getText());
        else
            Calculatrice.resultField.setText(this.getText());
    }

    @Override
    public String toString() {
        return "B{" + getText() + "}";
    }
}
