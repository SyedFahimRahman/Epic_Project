import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.io.*;
import java.nio.Buffer;
import javax.swing.JOptionPane;

public class login extends JFrame {
    private JPanel panel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton signUpButton;

    public login() {
        setTitle("Login Page");
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setBackground(new Color(255, 204, 153));
        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        loginButton = new JButton("Login");

        signUpButton = new JButton("Sign Up");


        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //check the entered username + password
                String username = usernameField.getText();
                char[] password = passwordField.getPassword(); // its a char for security reasons

                if (checkLoginInfo(username, new String(password))) {
                    //if the login matches
                    JOptionPane.showMessageDialog(login.this,"Successful login");
                    // add here later to switch to code gui

                } else {
                    //login doesnt match
                    JOptionPane.showMessageDialog(login.this,"Error. It doesn't seem to match");
                }

            }
        });

        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); //closes the login page
                new signUp().setVisible(true); //opens the sign up page
            }
        });
        panel.add(new JLabel("Login Page"));
        panel.add(new JLabel("Username:"));
        panel.add(usernameField);
        panel.add(new JLabel("Password:"));
        panel.add(passwordField);
        panel.add(loginButton);
        panel.add(signUpButton);

        add(panel);


    }

    private boolean checkLoginInfo(String inputUsername, String inputPassword) {
        //read the text file and check if the username and password match
        try {
            BufferedReader reader = new BufferedReader(new FileReader("user_loginInfo.txt")); //read the text file
            String line;
            while ((line = reader.readLine()) != null) {
                //read each line from the file
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    //if the line has exactly two parts seperated by :
                    String storedUsername = parts[0];
                    String storedPassword = parts[1];
                    if (storedUsername.equals(inputUsername) && storedPassword.equals(inputPassword)) ;
                   //check if the passowrd and username match the ones entered
                    reader.close(); //close the file
                    return true; // if its successful
                }
            }


            reader.close(); //close when done reading
        } catch (IOException ex) { // this handles any IOExeption that might happen (eg it cant find the file)
            ex.printStackTrace();
        }
        return false; // if no match is found
    }
}
