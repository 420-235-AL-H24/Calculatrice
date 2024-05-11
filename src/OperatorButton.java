import java.awt.*;
import java.awt.event.ActionEvent;

public class OperatorButton extends MyButton {
    static String lastOperator = "";
    static double lastValue = 0.0;

    protected OperatorButton(String text) {
        super(text, Color.RED);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (this.getText()) {
            case "+/-" -> Calculatrice.resultField.setValue(-Calculatrice.resultField.getValue());
            case "." -> Calculatrice.resultField.setText(Calculatrice.resultField.getText() + ".");
            case "sqrt" -> Calculatrice.resultField.setValue(Math.sqrt(Calculatrice.resultField.getValue()));
            case "%" -> Calculatrice.resultField.setValue(Calculatrice.resultField.getValue() / 100);
            case "1/x" -> Calculatrice.resultField.setValue(1 / Calculatrice.resultField.getValue());
            case "=" -> {
                double result = lastValue;
                switch (lastOperator) {
                    case "+" -> result += Calculatrice.resultField.getValue();
                    case "-" -> result -= Calculatrice.resultField.getValue();
                    case "*" -> result *= Calculatrice.resultField.getValue();
                    case "/" -> result /= Calculatrice.resultField.getValue();
                }
                lastValue = Calculatrice.resultField.getValue();
                Calculatrice.resultField.setValue(result);
            }
            default ->  {
                lastOperator = this.getText();
                lastValue = Calculatrice.resultField.getValue();
                Calculatrice.resultField.clear();
            }
        }
    }
}
