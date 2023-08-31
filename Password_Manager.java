import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class PasswordManagerGUI extends JFrame {
    private Map<String, String> accounts;
    private JTextField usernameField;
    private JPasswordField passwordField;

    public PasswordManagerGUI() {
        accounts = new HashMap<>();
        setTitle("Gestionnaire de Mots de Passe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(3, 2));

        JLabel usernameLabel = new JLabel("Nom d'utilisateur:");
        usernameField = new JTextField();
        JLabel passwordLabel = new JLabel("Mot de passe:");
        passwordField = new JPasswordField();
        JButton addButton = new JButton("Ajouter un compte");
        JButton loginButton = new JButton("Se connecter");

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                accounts.put(username, password);
                JOptionPane.showMessageDialog(null, "Compte ajouté avec succès.");
            }
        });

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                if (accounts.containsKey(username) && accounts.get(username).equals(password)) {
                    JOptionPane.showMessageDialog(null, "Connexion réussie.");
                } else {
                    JOptionPane.showMessageDialog(null, "Nom d'utilisateur ou mot de passe incorrect.");
                }
            }
        });

        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(addButton);
        panel.add(loginButton);

        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new PasswordManagerGUI().setVisible(true);
            }
        });
    }
}
