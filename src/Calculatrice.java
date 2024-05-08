import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

public class Calculatrice extends JFrame {
    public static void main(String[] args) {
        // Création de la fenêtre principale (la "racine graphique").
        JFrame frame = new Calculatrice();

        if (args.length == 2) {
            // Place la fenêtre à un endroit spécifique de l'écran (utile pour les démonstrations en classe).
            frame.setLocation(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        }

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Indique à Swing d'arrêter le programme quand on ferme la fenêtre.
        frame.setVisible(true); // Étape finale pour afficher la fenêtre graphique une fois qu'elle est prête.
    }

    public Calculatrice() {
        super("Calculatrice");
        this.setSize(500, 400); // Impose la taille initiale de la fenêtre (elle peut quand même être redimensionnée).

        this.setJMenuBar(createMenuBar()); // Ajout de la barre de menu (directement sous la barre de titre).
        this.add(createResultField(), BorderLayout.NORTH); // Ajout de la barre des résultats, en haut.
        this.add(createMemoryPanel(), BorderLayout.WEST); // Ajout du panneau de mémoire, à gauche.
        this.add(createMainPanel(), BorderLayout.CENTER); // Ajout du panneau principal, au centre.
    }

    private JMenuBar createMenuBar() {
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

    private JTextField createResultField() {
        JTextField resultField = new JTextField("0.0");
        resultField.setFont(resultField.getFont().deriveFont(40.0f));
        resultField.setHorizontalAlignment(JTextField.RIGHT);
        return resultField;
    }

    private JPanel createMemoryPanel() {
        JPanel panel = createPanel(new GridLayout(5, 1, 10, 10));

        JTextField memoryField = new JTextField();
        memoryField.setEditable(false);
        memoryField.setFont(memoryField.getFont().deriveFont(20.0f));
        memoryField.setHorizontalAlignment(JTextField.CENTER);
        panel.add(memoryField);

        panel.add(createButton("MC"));
        panel.add(createButton("MR"));
        panel.add(createButton("MS"));
        panel.add(createButton("M+"));

        return panel;
    }

    private JPanel createMainPanel() {
        JPanel mainPanel = new JPanel(); // Le BoxLayout est spécial et doit être créé après le panel.
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        JPanel editPanel = createEditPanel();
        editPanel.setMaximumSize(new Dimension(1000, 0));

        mainPanel.add(editPanel);
        mainPanel.add(createNumberPanel());
        return mainPanel;
    }

    private JPanel createEditPanel() {
        JPanel panel = createPanel(new GridLayout(1, 3, 10, 10));
        panel.add(createButton("Backspace", Color.RED));
        panel.add(createButton("CE", Color.RED));
        panel.add(createButton("C", Color.RED));
        return panel;
    }

    private JPanel createNumberPanel() {
        String[] labels = {
                "7", "8", "9", "/", "sqrt",
                "4", "5", "6", "*", "%",
                "1", "2", "3", "-", "1/x",
                "0", "+/-", ".", "+", "="
        };

        JPanel panel = createPanel(new GridLayout(4, 5, 10, 10));
        for (String label : labels)
            panel.add(createButton(label));
        return panel;
    }

    private static JPanel createPanel(LayoutManager layout) {
        JPanel panel = new JPanel(layout);
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        return panel;
    }

    private static JPanel createPanel(LayoutManager layout, Color color) {
        JPanel panel = new JPanel(layout);
        panel.setBorder(new LineBorder(color, 10));
        return panel;
    }

    private static JButton createButton(String text) {
        return new MyButton(text);
    }

    private static JButton createButton(String text, Color color) {
        return new MyButton(text, color);
    }
}
