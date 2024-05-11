import javax.swing.*;

public class NumberField extends JTextField {
    private double value;

    public NumberField() {
        super();
        this.clear();
    }

    public NumberField(double value) {
        super();
        this.setValue(value);
    }

    @Override
    public void setText(String text) {
        super.setText(text);
        this.value = Double.parseDouble(text);
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
        super.setText(String.valueOf(value));
    }

    public void clear() {
        this.value = 0.0;
        super.setText("");
    }
}
