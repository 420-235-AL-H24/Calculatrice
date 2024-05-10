import java.awt.*;
import java.awt.event.ActionEvent;

public class OperatorButton extends MyButton {
    public OperatorButton(String text) {
        super(text, Color.RED);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Calculatrice.resultField.setText(this.getText());
    }
}
