import java.awt.*;
import java.awt.event.ActionEvent;

public class NumberButton extends MyButton {
    final int value;
    protected NumberButton(String text) {
        super(text, Color.BLUE);
        this.value = Integer.parseInt(text);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Calculatrice.resultField.setValue(10 * Calculatrice.resultField.getValue() + this.value);
    }
}
