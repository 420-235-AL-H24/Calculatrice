import java.awt.*;
import java.awt.event.ActionEvent;

public class NumberButton extends MyButton {
    public NumberButton(String text) {
        super(text, Color.BLUE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Calculatrice.resultField.setText(Calculatrice.resultField.getText() + this.getText());
    }
}
