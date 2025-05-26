import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// La classe MyButton hérite de JButton (pour en reprendre le fonctionnement de base) et implémente
// l'interface ActionListener (pour pouvoir gérer les événements de clic).
public class MyButton extends JButton implements ActionListener {
    protected static Font myFont = new Font("Tahoma", Font.PLAIN, 15);

    // Cette méthode permet de créer le bon sous-type de bouton automatiquement basé sur son texte.
    public static MyButton createButton(String text) {
        if (text.length() == 1 && Character.isDigit(text.charAt(0)))
            return new NumberButton(text);
        else
            return new OperatorButton(text);
    }

    // Le constructeur est "caché" pour encourager l'utilisation de la méthode ci-dessus.
    protected MyButton(String text, Color color) {
        super(text);
        this.setFont(myFont);
        this.setForeground(color);
        this.setBackground(new Color(252, 252, 252));
        this.addActionListener(this); // Le bouton écoute/réagit à ses propres événements.
    }

    // La méthode actionPerformed (de l'interface ActionListener) indique au bouton quoi
    // faire lors d'un clic. Les sous-classes vont réimplémenter cette méthode.
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("click: " + this.getText()); // Sera appelé seulement si la méthode n'est pas remplacée.
        //Calculatrice.resultField.setText(this.getText());
    }

    // La méthode toString aide au débogage seulement; elle n'affecte pas l'apparence du bouton.
    @Override
    public String toString() {
        return "B(" + getText() + ")";
    }
}
