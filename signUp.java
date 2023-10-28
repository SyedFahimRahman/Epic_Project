import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.Color;

public class signUp extends JFrame{
    private JPanel panel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;
    private JButton signUpButton;
    private JButton backToLoginButton;

    public signUp() {
        setTitle("Sign Up Page");
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setBackground(new Color(255, 204, 153));

        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        confirmPasswordField = new JPasswordField(20);

        signUpButton = new JButton("Sign Up");

        backToLoginButton = new JButton("Back to Login");



        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Check if the password and confirm password match
                char[] password = passwordField.getPassword();
                char[] confirmPassword = confirmPasswordField.getPassword();

                if (new String(password).equals(new String(confirmPassword))) {
                    // Passwords match
                    String username = usernameField.getText();

                    System.out.println("Username: " + username);
                    System.out.println("Password: " + new String(password));
                    System.out.println("Confirm Password: " + new String(confirmPassword));
                    JOptionPane.showMessageDialog(signUp.this, "Congrats! You've made an account! Now please login.");


                    try {
                        BufferedWriter writer = new BufferedWriter(new FileWriter("user_loginInfo.txt", true));
                        writer.write(username + ":" + password);
                        writer.newLine();
                        writer.close();
                        System.out.println("");
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                } else {
                    //if the passwords dont match then show an error messgae
                    JOptionPane.showMessageDialog(signUp.this, "Passwords do not match. Try again", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }


        });

        backToLoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the sign-up page
                new login().setVisible(true); // Open the login page
            }
        });
        panel.add(new JLabel("Sign Up Page"));
        panel.add(new JLabel("Username:"));
        panel.add(usernameField);
        panel.add(new JLabel("Password:"));
        panel.add(passwordField);
        panel.add(new JLabel("Confirm Password:"));
        panel.add(confirmPasswordField);
        panel.add(signUpButton);
        panel.add(backToLoginButton);

        add(panel);

    }

    }


