import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupPage extends JFrame implements ActionListener {
    JLabel emailLabel, passwordLabel, confirmPasswordLabel, messageLabel;
    JTextField emailField;
    JPasswordField passwordField, confirmPasswordField;
    JButton registerButton, backButton;

    public SignupPage() {
        // Frame settings
        setTitle("Signup Page");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Set beige background
        getContentPane().setBackground(new Color(245, 245, 220));

        // Panel with GridBagLayout for better control over layout
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setOpaque(false); // Transparent panel so background color is visible
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        // Custom font
        Font labelFont = new Font("SansSerif", Font.BOLD, 16);
        Font inputFont = new Font("SansSerif", Font.PLAIN, 14);

        // Email Label and Field
        emailLabel = new JLabel("Email:");
        emailLabel.setFont(labelFont);
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(emailLabel, gbc);

        emailField = new JTextField(20);
        emailField.setFont(inputFont);
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(emailField, gbc);

        // Password Label and Field
        passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(labelFont);
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(passwordLabel, gbc);

        passwordField = new JPasswordField(20);
        passwordField.setFont(inputFont);
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(passwordField, gbc);

        // Confirm Password Label and Field
        confirmPasswordLabel = new JLabel("Confirm Password:");
        confirmPasswordLabel.setFont(labelFont);
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(confirmPasswordLabel, gbc);

        confirmPasswordField = new JPasswordField(20);
        confirmPasswordField.setFont(inputFont);
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(confirmPasswordField, gbc);

        // Message Label
        messageLabel = new JLabel();
        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(messageLabel, gbc);

        // Register Button
        registerButton = new JButton("Register");
        registerButton.setBackground(new Color(50, 205, 50)); // Green background
        registerButton.setForeground(Color.WHITE); // White text
        registerButton.setFocusPainted(false); // Remove focus border
        registerButton.setFont(labelFont);
        registerButton.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2, true)); // Rounded border
        registerButton.setPreferredSize(new Dimension(150, 40));
        gbc.gridx = 1;
        gbc.gridy = 4;
        panel.add(registerButton, gbc);
        registerButton.addActionListener(this);

        // Back Button
        backButton = new JButton("Back");
        backButton.setBackground(Color.WHITE);
        backButton.setForeground(Color.BLACK);
        backButton.setFocusPainted(false);
        backButton.setFont(labelFont);
        backButton.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2, true));
        backButton.setPreferredSize(new Dimension(150, 40));
        gbc.gridx = 1;
        gbc.gridy = 5;
        panel.add(backButton, gbc);
        backButton.addActionListener(this);

        // Add panel to the frame
        add(panel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == registerButton) {
            String email = emailField.getText();
            String password = String.valueOf(passwordField.getPassword());
            String confirmPassword = String.valueOf(confirmPasswordField.getPassword());

            if (email.isEmpty() || password.isEmpty()) {
                messageLabel.setText("Please fill in all fields.");
            } else if (!password.equals(confirmPassword)) {
                messageLabel.setText("Passwords do not match.");
            } else if (LoginPage.users.containsKey(email)) {
                messageLabel.setText("Email already registered.");
            } else {
                LoginPage.users.put(email, password);
                messageLabel.setText("Registration successful!");
            }
        } else if (e.getSource() == backButton) {
            dispose();
            new LoginPage();
        }
    }
}
