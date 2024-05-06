import javax.swing.*;
import java.awt.*;

public class Calculatrice {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculatrice");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Permet d'arrêter le programme lorsqu'on ferme la fenêtre.
        frame.setSize(500, 600);
        frame.setLocation(3200, 100);

        frame.setJMenuBar(creerMenu());

        JTextField resultField = new JTextField("0.0");
        frame.add(resultField, BorderLayout.NORTH);
        Font textFont = resultField.getFont();
        resultField.setFont(textFont.deriveFont(40.0f));

        JPanel panneauPrincipal = new JPanel(new BorderLayout());
        frame.add(panneauPrincipal, BorderLayout.CENTER);

        panneauPrincipal.add(creerPanneauEdit(), BorderLayout.NORTH);
        panneauPrincipal.add(creerPanneauMemoire(), BorderLayout.WEST);
        panneauPrincipal.add(creerPanneauNumeors(), BorderLayout.CENTER);

        frame.setVisible(true);
    }

    public static JMenuBar creerMenu() {
        JMenuBar menuBar = new JMenuBar();

        JMenu menuEdit = new JMenu("Edit");
        menuEdit.add(new JMenuItem("Copy"));
        menuEdit.add(new JMenuItem("Paste"));
        menuBar.add(menuEdit);

        JMenu menuView = new JMenu("View");
        ButtonGroup groupeMode = new ButtonGroup();

        JMenuItem itemStandard = new JRadioButtonMenuItem("Standard");
        itemStandard.setSelected(true);
        groupeMode.add(itemStandard);
        menuView.add(itemStandard);

        JMenuItem itemScientific = new JRadioButtonMenuItem("Scientific");
        groupeMode.add(itemScientific);
        menuView.add(itemScientific);

        menuView.addSeparator();
        JMenuItem itemDigits = new JCheckBoxMenuItem("Digit Grouping");
        menuView.add(itemDigits);
        menuBar.add(menuView);

        JMenu menuHelp = new JMenu("Help");
        menuHelp.add(new JMenuItem("Help Topics"));
        menuHelp.add(new JMenuItem("About Calculator"));
        menuBar.add(menuHelp);

        return menuBar;
    }

    public static JPanel creerPanneauEdit() {
        JPanel panneauEdit = new JPanel(new FlowLayout());

        JButton buttonBackspace = creerBouton("Backspace");
        panneauEdit.add(buttonBackspace);

        JButton buttonCE = creerBouton("CE");
        panneauEdit.add(buttonCE);

        JButton buttonC = creerBouton("C");
        panneauEdit.add(buttonC);

        return panneauEdit;
    }

    public static JPanel creerPanneauMemoire() {
        JPanel panneauMemoire = new JPanel(new GridLayout(4, 1));
        panneauMemoire.add(creerBouton("MC"));
        panneauMemoire.add(creerBouton("MR"));
        panneauMemoire.add(creerBouton("MS"));
        panneauMemoire.add(creerBouton("M+"));
        return panneauMemoire;
    }

    private static JPanel creerPanneauNumeors() {
        JPanel panneauNumeros = new JPanel(new GridLayout(4, 5));
        for (int i = 0; i < 10; i++)
            panneauNumeros.add(creerBouton(String.valueOf(i)));
        return panneauNumeros;
    }
    
    public static JButton creerBouton(String texte) {
        JButton bouton = new JButton(texte);
        bouton.setMargin(new Insets(5, 5, 5, 5));
        bouton.setBackground(Color.GREEN);
        return bouton;
    }

    public static class MyButton extends JButton {

    }
}
