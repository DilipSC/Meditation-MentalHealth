import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginPage extends JFrame implements ActionListener {
    // Components
    JLabel emailLabel, passwordLabel, messageLabel;
    JTextField emailField;
    JPasswordField passwordField;
    JButton loginButton, signupButton;

    static java.util.Map<String, String> users = new java.util.HashMap<>();

    public LoginPage() {
        // Frame settings
        setTitle("Login Page");
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

        // Message Label
        messageLabel = new JLabel();
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(messageLabel, gbc);

        // Login Button
        loginButton = new JButton("Login");
        loginButton.setBackground(new Color(50, 205, 50)); // Green background
        loginButton.setForeground(Color.WHITE); // White text
        loginButton.setFocusPainted(false); // Remove focus border
        loginButton.setFont(labelFont);
        loginButton.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2, true)); // Rounded border
        loginButton.setPreferredSize(new Dimension(150, 40)); // Set button size
        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(loginButton, gbc);
        loginButton.addActionListener(this);

        // Signup Button
        signupButton = new JButton("Signup");
        signupButton.setBackground(Color.WHITE);
        signupButton.setForeground(Color.BLACK);
        signupButton.setFocusPainted(false);
        signupButton.setFont(labelFont);
        signupButton.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2, true));
        signupButton.setPreferredSize(new Dimension(150, 40));
        gbc.gridx = 1;
        gbc.gridy = 4; // Placing it below the login button
        panel.add(signupButton, gbc);
        signupButton.addActionListener(this);

        // Add panel to the frame
        add(panel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String email = emailField.getText();
            String password = String.valueOf(passwordField.getPassword());

            if (users.containsKey(email) && users.get(email).equals(password)) {
                messageLabel.setText("Login successful!");
            } else {
                messageLabel.setText("Invalid email or password.");
            }
        } else if (e.getSource() == signupButton) {
            dispose(); // Close the current window
            new SignupPage();
        }
    }
}
