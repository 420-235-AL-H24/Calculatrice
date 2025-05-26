import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

// Cette classe représente un champ texte spécialisé pour contenir une valeur numérique.
public class NumberField extends JTextField implements KeyListener {
    private double value;

    public NumberField() {
        super();
        clear();
        setEditable(false);
    }

    public void addText(String text) {
        if (value != 0.0)
            this.setText(this.getText() + text);
        else
            this.setText(text);
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
        super.setText("0");
    }

    @Override
    public void keyTyped(KeyEvent e) {
        MyButton bouton = (e.getKeyChar() == '\n'
                ? Calculatrice.buttonMap.get("=")
                : Calculatrice.buttonMap.get(String.valueOf(e.getKeyChar())));
        if (bouton != null)
            bouton.actionPerformed(null);
        else
            System.out.println("press: " + e.getKeyChar());
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Intentionnellement laissé vide
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Intentionnellement laissé vide
    }
}
