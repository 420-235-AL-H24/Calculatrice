import javax.swing.*;

// Cette classe représente un champ texte spécialisé pour contenir une valeur numérique.
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

    // Lorsque la méthode setText (de la classe JTextField) est appelée, la valeur est recalculée automatiquement.
    @Override
    public void setText(String text) {
        try {
            this.value = Double.parseDouble(text);
            super.setText(text);
        }
        catch (NumberFormatException e) {
            e.printStackTrace();
            super.setText(String.valueOf(value)); // On reprend la valeur précédente.
        }
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
