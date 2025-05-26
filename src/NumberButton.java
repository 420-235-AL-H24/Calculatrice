import java.awt.*;
import java.awt.event.ActionEvent;

public class NumberButton extends MyButton {
    protected NumberButton(String text) {
        super(text, Color.BLUE);
        super.setFont(myFont.deriveFont(16.0f));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Calculatrice.resultField.addText(this.getText());
    }
}
