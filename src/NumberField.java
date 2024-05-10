import javax.swing.*;

public class NumberField extends JTextField {
    private double value;

    public NumberField() {
        super();
        this.setValue(0.0);
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
        this.setText(String.valueOf(value));
    }

    public void addValue(double value) {
        this.setValue(this.value + value);
    }
}
