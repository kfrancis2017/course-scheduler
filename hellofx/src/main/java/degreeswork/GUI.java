package degreeswork;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//comment line 168 is login and 458 is create a new user.

public class GUI extends JFrame {
    // In your GUI class
    private DegreeWorks degreeWorks;
    
    
    
    // Class-level variables for easy adjustment of component positions and sizes
    private int initialFrameWidth = 500; // Initial frame width for reference
    private int initialFrameHeight = 400; // Initial frame height for reference
    private int componentWidth = 300; // Component width (text fields and buttons)
    private int componentHeight = 30; // Component height
    private int verticalSpacing = 15; // Space between components
    private int topMargin = 80; // Top margin for the first component
    
    public GUI() {
        createUI();
        setTitle("Custom Login Form");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(initialFrameWidth, initialFrameHeight); // Set initial size
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.WHITE); // Set background to white
        
        degreeWorks = new DegreeWorks();
    }
    
    //TODO: REMOVE THIS FUNCTION
    private void createUI() {
        // Set properties and add components
        setupComponents();
        
        // Adding components to the frame
        
    }
    
    private void setupComponents() {
        //clear screen
        getContentPane().removeAll();
        // Create components
        JLabel loginLabel = new JLabel("LOGIN", SwingConstants.CENTER);
        JTextField userTextField = new JTextField("Username/email");
        JPasswordField passwordField = new JPasswordField("Password");
        JButton loginButton = new JButton("LOGIN");
        JButton resetButton = new JButton("Forgot?");
        JCheckBox rememberMeCheckbox = new JCheckBox("Remember me");

        // Set fixed positions and sizes for components
        int fixedCenterX = 150; // You can change this to fit your layout
        int fixedTopMargin = 50; // Starting y position
        int fixedComponentWidth = 200; // Width of text fields and buttons
        int fixedComponentHeight = 30; // Height of text fields and buttons
        int fixedVerticalSpacing = 40; // Vertical space between components

        // Update component positions
        loginLabel.setBounds(0, fixedTopMargin, fixedComponentWidth, fixedComponentHeight);
        userTextField.setBounds(fixedCenterX, fixedTopMargin + fixedComponentHeight + fixedVerticalSpacing, fixedComponentWidth, fixedComponentHeight);
        passwordField.setBounds(fixedCenterX, fixedTopMargin + 2 * (fixedComponentHeight + fixedVerticalSpacing), fixedComponentWidth, fixedComponentHeight);
        rememberMeCheckbox.setBounds(fixedCenterX, fixedTopMargin + 3 * (fixedComponentHeight + fixedVerticalSpacing), fixedComponentWidth / 2, fixedComponentHeight);
        //forgotPasswordLabel.setBounds(fixedCenterX + fixedComponentWidth - fixedComponentWidth / 7, fixedTopMargin + 3 * (fixedComponentHeight + fixedVerticalSpacing), fixedComponentWidth / 2, fixedComponentHeight);
        loginButton.setBounds(fixedCenterX, fixedTopMargin + 4 * (fixedComponentHeight + fixedVerticalSpacing), fixedComponentWidth, fixedComponentHeight + 10);
        resetButton.setBounds(fixedCenterX, fixedTopMargin + 10 * (fixedComponentHeight + fixedVerticalSpacing), fixedComponentWidth, fixedComponentHeight + 10);

        // Add components to the container
        getContentPane().add(loginLabel);
        getContentPane().add(userTextField);
        getContentPane().add(passwordField);
        getContentPane().add(rememberMeCheckbox);
        //getContentPane().add(forgotPasswordLabel);
        getContentPane().add(loginButton);
        getContentPane().add(resetButton);

        // Refresh the frame to show the new content
        validate();
        repaint();

        
        
        // Login Label
        loginLabel.setFont(new Font("Arial", Font.BOLD, 20)); // Set font size and style for the login label
        
        // Username TextField
        userTextField.setForeground(Color.GRAY); // Set the foreground color to gray to simulate placeholder text
        userTextField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.GRAY)); // Set custom border
        userTextField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (userTextField.getText().equals("Username/email")) {
                    userTextField.setText("");
                    userTextField.setForeground(Color.BLACK);
                }
            }
            
            @Override
            public void focusLost(FocusEvent e) {
                if (userTextField.getText().isEmpty()) {
                    userTextField.setText("Username/email");
                    userTextField.setForeground(Color.GRAY);
                }
            }
        });
        
        // PasswordField
        passwordField.setText("Password");
        passwordField.setEchoChar((char) 0); // Initially display password as plain text
        passwordField.setForeground(Color.GRAY); // Set the foreground color to gray
        passwordField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.GRAY)); // Set custom border
        passwordField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (String.valueOf(passwordField.getPassword()).equals("Password")) {
                    passwordField.setText("");
                    passwordField.setEchoChar('*'); // Set to bullet points when focused
                    passwordField.setForeground(Color.BLACK);
                }
            }
            
            @Override
            public void focusLost(FocusEvent e) {
                if (String.valueOf(passwordField.getPassword()).isEmpty()) {
                    passwordField.setText("Password");
                    passwordField.setEchoChar((char) 0); // Show text as plain text when not focused
                    passwordField.setForeground(Color.GRAY);
                }
            }
        });
        
        // Remember Me Checkbox with a custom round icon
        rememberMeCheckbox = new JCheckBox("Remember me");
        rememberMeCheckbox.setOpaque(false);
        rememberMeCheckbox.setFocusPainted(false);
        
        // Custom icons for checkbox states
        Icon normalIcon = new Icon() {
            @Override
            public void paintIcon(Component c, Graphics g, int x, int y) {
                Graphics2D g2 = (Graphics2D) g; // Cast to Graphics2D for more control
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); // Apply anti-aliasing
                g2.drawOval(x, y, getIconWidth() - 1, getIconHeight() - 1);
                g2.drawOval(x + 1, y + 1, getIconWidth() - 3, getIconHeight() - 3);
            }
            
            @Override
            public int getIconWidth() {
                return 16;
            }
            
            @Override
            public int getIconHeight() {
                return 16;
            }
        };
        
        Icon selectedIcon = new Icon() {
            @Override
            public void paintIcon(Component c, Graphics g, int x, int y) {
                Graphics2D g2 = (Graphics2D) g; // Cast to Graphics2D for more control
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); // Apply anti-aliasing
                g2.setColor(Color.GRAY); // You can change color here
                g2.fillOval(x + 4, y + 4, getIconWidth() - 8, getIconHeight() - 8);
                g2.setColor(Color.BLACK); // Reset the color for the border
                g2.drawOval(x, y, getIconWidth() - 1, getIconHeight() - 1);
                g2.drawOval(x + 1, y + 1, getIconWidth() - 3, getIconHeight() - 3);
            }
            
            @Override
            public int getIconWidth() {
                return 16;
            }
            
            @Override
            public int getIconHeight() {
                return 16;
            }
        };
        
        // Implement a common method for login validation and navigation
        Runnable performLogin = () -> {
            // Simulate checking credentials
            String username = userTextField.getText();
            char[] password = passwordField.getPassword(); // Get password as char array for security
            
            // Here you should check the actual credentials, for demonstration I use placeholder values
            if (degreeWorks.login(username, String.valueOf(password))) {
                navigateToWelcomePage(username); // Call this method if login is successful
            } else {
                // Show login error
                showErrorMessage("Invalid username or password.", "Login Failed");
            }
        };
        
        // Key listener for both userTextField and passwordField
        KeyListener enterKeyListener = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    performLogin.run();
                }
            }
        };
        
        userTextField.addKeyListener(enterKeyListener);
        passwordField.addKeyListener(enterKeyListener);
        
        // Set custom icons
        rememberMeCheckbox.setIcon(normalIcon);
        rememberMeCheckbox.setSelectedIcon(selectedIcon);
        
        
        // Login Button
        loginButton.setBackground(new Color(102, 0, 153)); // Set background color
        loginButton.setForeground(Color.WHITE); // Set text color
        loginButton.setFocusPainted(false); // Remove focus outline
        loginButton.addActionListener(e -> performLogin.run());
        
        // Reset Button
        resetButton.setBorderPainted(false);
        resetButton.setOpaque(false);
        resetButton.setContentAreaFilled(false); // Make it look like a hyperlink
        resetButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        resetButton.addActionListener(e -> showResetPasswordDialog());
        
        add(loginLabel);
        add(userTextField);
        add(passwordField);
        add(rememberMeCheckbox);
        add(loginButton);
        add(resetButton);
        
        validate();
        repaint();
    }
    
    
    
    private void showResetPasswordDialog() {
        // Create a dialog frame for resetting the password
        JDialog resetDialog = new JDialog(this, "Reset Password", true);
        resetDialog.setLayout(new FlowLayout());
        resetDialog.setSize(300, 150);
        resetDialog.setLocationRelativeTo(this); // Center the dialog relative to the main frame
        resetDialog.getContentPane().setBackground(Color.WHITE); // Set background to white
        
        // Components for the email input
        JLabel emailLabel = new JLabel("Enter your email:");
        JTextField emailTextField = new JTextField(20);
        emailTextField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.GRAY)); // Set custom border
        JButton sendCodeButton = new JButton("Send Code");
        sendCodeButton.setBackground(new Color(102, 0, 153)); // Set background color
        sendCodeButton.setForeground(Color.WHITE); // Set text color
        sendCodeButton.setFocusPainted(false); // Remove focus outline
        sendCodeButton.setBorderPainted(false); // Remove button border
        sendCodeButton.setOpaque(true); // Apply background color
        
        // Initially, show only the email components
        resetDialog.add(emailLabel);
        resetDialog.getContentPane().add(emailTextField);
        resetDialog.getContentPane().add(sendCodeButton);
        
        // Common method to validate email and show next step or error
        Runnable emailValidation = () -> {
            String email = emailTextField.getText();
            // Check if the email contains "@" and a "." after the "@"
            if (email.contains("@") && email.indexOf(".") > email.indexOf("@")) {
                // Email seems valid, proceed with sending the reset code
                // Send the reset code here (you'll need to implement this)
                // For now, we'll just switch to the PIN input components
                resetDialog.getContentPane().removeAll();
                resetDialog.setLayout(new FlowLayout()); // Reset the layout
                resetDialog.getContentPane().setBackground(Color.WHITE); // Set background to white again
                
                // Components for the PIN input
                JLabel pinLabel = new JLabel("Enter your reset PIN:");
                JTextField pinTextField = new JTextField(20);
                pinTextField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.GRAY)); // Set custom border
                JButton verifyButton = new JButton("Verify PIN");
                verifyButton.setBackground(new Color(102, 0, 153)); // Set background color
                verifyButton.setForeground(Color.WHITE); // Set text color
                verifyButton.setFocusPainted(false); // Remove focus outline
                verifyButton.setBorderPainted(false); // Remove button border
                verifyButton.setOpaque(true); // Apply background color
                
                resetDialog.add(pinLabel);
                resetDialog.add(pinTextField);
                resetDialog.add(verifyButton);
                resetDialog.revalidate();
                resetDialog.repaint();
            } else {
                // Email is invalid, show an error message
                showErrorMessage("Please enter a valid email address.", "Invalid Email");
            }
        };
        
        // Action listener for the send code button
        sendCodeButton.addActionListener(e -> emailValidation.run());
        
        // Key listener for the email text field
        emailTextField.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    emailValidation.run();
                }
            }
        });
        
        resetDialog.setVisible(true); // Show the dialog
    }
    
    
    private void showErrorMessage(String message, String title) {
        // Create a custom dialog for the error message
        JDialog errorDialog = new JDialog(this, title, true);
        errorDialog.setSize(300, 120); // Adjusted for larger text
        errorDialog.setLocationRelativeTo(this); // Center the dialog relative to the main frame
        errorDialog.getContentPane().setBackground(Color.WHITE); // Set background to white
        
        // Set the container and layout
        Container contentPane = errorDialog.getContentPane();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS)); // Set BoxLayout
        
        // Create a label for the error message with larger font and centered text
        JLabel messageLabel = new JLabel(message);
        messageLabel.setForeground(Color.RED); // Set the text color to red for visibility
        messageLabel.setFont(new Font("Arial", Font.BOLD, 14)); // Increase font size
        messageLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Center the label horizontally in the container
        
        // Create a button for closing the dialog that matches other interface buttons
        JButton okButton = new JButton("OK");
        okButton.setBackground(new Color(102, 0, 153)); // Set background color
        okButton.setForeground(Color.WHITE); // Set text color
        okButton.setFocusPainted(false); // Remove focus outline
        okButton.setBorderPainted(false); // Match other buttons
        okButton.setOpaque(true); // Apply background color
        okButton.setFont(new Font("Arial", Font.BOLD, 12)); // Match font size with other buttons
        okButton.setAlignmentX(Component.CENTER_ALIGNMENT); // Center the button
        okButton.addActionListener(e -> errorDialog.dispose()); // Close the dialog when clicked
        
        // Adding a MouseListener to change button color on press for visual consistency
        okButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                okButton.setBackground(new Color(80, 0, 120)); // Darker shade when pressed
            }
            
            @Override
            public void mouseReleased(MouseEvent e) {
                okButton.setBackground(new Color(102, 0, 153)); // Original color when released
            }
        });
        
        // Add components to the dialog
        contentPane.add(Box.createVerticalStrut(10)); // Add some space at the top
        contentPane.add(messageLabel);
        contentPane.add(Box.createVerticalStrut(10)); // Add some space between label and button
        contentPane.add(okButton);
        contentPane.add(Box.createVerticalStrut(10)); // Add some space at the bottom
        
        errorDialog.setVisible(true); // Show the dialog
    }
    
    private void navigateToWelcomePage(String username) {
        // Clear all content from the frame
        getContentPane().removeAll();
        setLayout(new BorderLayout()); // Set layout for the welcome page
        
        // Create a panel for the top bar which will contain the logout button
        JPanel topBar = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        topBar.setBackground(Color.WHITE); // Set background to match the theme
        JButton logoutButton = new JButton("NOT work");
        logoutButton.setBackground(new Color(102, 0, 153)); // Set background color
        logoutButton.setForeground(Color.WHITE); // Set text color
        logoutButton.setFocusPainted(false); // Remove focus outline
        logoutButton.setFont(new Font("Arial", Font.BOLD, 12)); // Match font size and style with other buttons
        logoutButton.addActionListener(e -> {
            setupComponents();
        });
        topBar.add(logoutButton);
        
        // Welcome message
        String labelText = degreeWorks.getUser(username).replace("\n", "<br>");
        JLabel welcomeLabel = new JLabel("<html>" + labelText + "</html>", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 24)); // Set font size and style
        
        
        // Create a panel for the buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 20)); // horizontal gap, vertical gap
        buttonPanel.setBackground(Color.WHITE); // Set background or any color you like
        
        // Create New User button
        JButton createUserButton = new JButton("Create New User");
        customizeButton(createUserButton);
        createUserButton.addActionListener(e -> showCreateUserScreen(username));
        
        
        // View List of Users button
        JButton viewUsersButton = new JButton("View List of Users");
        customizeButton(viewUsersButton);
        
        // Add buttons to the panel
        buttonPanel.add(createUserButton);
        buttonPanel.add(viewUsersButton);
        
        // Adding components to the frame
        add(topBar, BorderLayout.NORTH);
        add(welcomeLabel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        
        // Refresh the frame to show the new content
        validate();
        repaint();
    }
    
    private void customizeButton(JButton button) {
        button.setBackground(new Color(102, 0, 153)); // Set background color
        button.setForeground(Color.WHITE); // Set text color
        button.setFocusPainted(false); // Remove focus outline
        button.setFont(new Font("Arial", Font.BOLD, 12)); // Match font size and style with other buttons
    }
    
    private void showCreateUserScreen(String username_current) {
        // Clear all content from the frame
        getContentPane().removeAll();
        setLayout(null); // Use null layout for absolute positioning
        
        // Initialize components with placeholder text and custom border
        JTextField newUserTextField = new JTextField("Username");
        newUserTextField.setForeground(Color.GRAY);
        newUserTextField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.GRAY));
        JPasswordField newPasswordField = new JPasswordField("Password");
        newPasswordField.setEchoChar((char) 0);
        newPasswordField.setForeground(Color.GRAY);
        newPasswordField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.GRAY));
        JTextField firstNameTextField = new JTextField("First Name");
        firstNameTextField.setForeground(Color.GRAY);
        firstNameTextField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.GRAY));
        JTextField lastNameTextField = new JTextField("Last Name");
        lastNameTextField.setForeground(Color.GRAY);
        lastNameTextField.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.GRAY));
        
        // Create the save button and apply the standard formatting
        JButton saveUserButton = new JButton("Save User");
        saveUserButton.setBackground(new Color(102, 0, 153));
        saveUserButton.setForeground(Color.WHITE);
        saveUserButton.setFocusPainted(false);
        saveUserButton.setFont(new Font("Arial", Font.BOLD, 12));
        saveUserButton.addActionListener(e -> {
            // Retrieve user input
            String username = newUserTextField.getText().trim();
            String password = new String(newPasswordField.getPassword()).trim();
            String firstName = firstNameTextField.getText().trim();
            String lastName = lastNameTextField.getText().trim();
            
            // Check that all fields are filled out
            if (username.isEmpty() || username.equals("Username") ||
            password.isEmpty() || password.equals("Password") ||
            firstName.isEmpty() || firstName.equals("First Name") ||
            lastName.isEmpty() || lastName.equals("Last Name")) {
                JOptionPane.showMessageDialog(null, "Please fill in all fields correctly.");
            } else {
                // Call the signup method
                boolean success = degreeWorks.signup(username, password, firstName, lastName);
                if (success) {
                    JOptionPane.showMessageDialog(null, "User created successfully.");
                    navigateToWelcomePage(username_current); // Navigate back to the welcome page
                } else {
                    // Handle the case where signup fails (e.g., if username is already taken)
                    JOptionPane.showMessageDialog(null, "Signup failed, please try again.");
                }
            }
        });
        
        // Add focus listeners (keep your existing focus listeners here)
        // Focus listeners to handle placeholder text for each text field
        FocusListener clearText = new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                JTextField source = (JTextField) e.getComponent();
                String text = source.getText();
                if (source == newUserTextField && text.equals("Username")) {
                    source.setText("");
                } else if (source == newPasswordField && text.equals("Password")) {
                    source.setText("");
                    ((JPasswordField) source).setEchoChar('*');
                } else if (source == firstNameTextField && text.equals("First Name")) {
                    source.setText("");
                } else if (source == lastNameTextField && text.equals("Last Name")) {
                    source.setText("");
                }
                source.setForeground(Color.BLACK);
            }
            
            @Override
            public void focusLost(FocusEvent e) {
                JTextField source = (JTextField) e.getComponent();
                if (source.getText().isEmpty()) {
                    if (source == newUserTextField) {
                        source.setText("Username");
                    } else if (source == newPasswordField) {
                        source.setText("Password");
                        ((JPasswordField) source).setEchoChar((char) 0);
                    } else if (source == firstNameTextField) {
                        source.setText("First Name");
                    } else if (source == lastNameTextField) {
                        source.setText("Last Name");
                    }
                    source.setForeground(Color.GRAY);
                }
            }
        };
        
        // Add focus listeners to each text field
        newUserTextField.addFocusListener(clearText);
        newPasswordField.addFocusListener(clearText);
        firstNameTextField.addFocusListener(clearText);
        lastNameTextField.addFocusListener(clearText);
        
        
        // Add components to the frame
        add(newUserTextField);
        add(newPasswordField);
        add(firstNameTextField);
        add(lastNameTextField);
        add(saveUserButton);
        
        // Define a method to update component positions based on frame size
        Runnable updateComponentPositions = () -> {
            int frameWidth = getWidth();
            int frameHeight = getHeight();
            int width = 200, height = 25, gap = 40;
            int startX = (frameWidth - width) / 2;
            int startY = (frameHeight - (5 * height + 4 * gap)) / 2;
            
            newUserTextField.setBounds(startX, startY, width, height);
            newPasswordField.setBounds(startX, startY + gap, width, height);
            firstNameTextField.setBounds(startX, startY + 2 * gap, width, height);
            lastNameTextField.setBounds(startX, startY + 3 * gap, width, height);
            saveUserButton.setBounds(startX, startY + 4 * gap, width, height);
        };
        
        // Call updateComponentPositions initially to set component positions
        updateComponentPositions.run();
        
        // Add a ComponentListener to the frame to handle resizing
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                updateComponentPositions.run();
            }
        });
        
        // Refresh the frame to show the new content
        validate();
        repaint();
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GUI frame = new GUI();
            frame.setVisible(true);
        });
    }
}