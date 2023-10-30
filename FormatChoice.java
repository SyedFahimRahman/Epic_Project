package src;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;


public class FormatChoice extends JFrame{

    JRadioButton radioButton,radioButton2,radioButton3;
    JLabel heading,title,imageLabel;
    JButton btn;


    public FormatChoice(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 800);
        this.setTitle("Mind Mingle");
        this.setLocationRelativeTo(null); // this centers the window on the screen
        this.setLayout(null);
        this.getContentPane().setBackground(new Color(255, 204, 153));

        title = new JLabel("Mind Mingle");
        title.setBounds(200, 50, 360, 50);
        title.setFont(new Font("Chalkduster", Font.BOLD, 28));
        title.setBackground(Color.white);
        title.setOpaque(true);
        title.setForeground(new Color(255, 204, 153));
        title.setBorder(new EmptyBorder(0, 10, 0, 0));

        heading = new JLabel("<html>" + "Which kind of quiz would you like to play?" + "<html>");
        heading.setBounds(250,180,300,50);
        heading.setFont(new Font("New Roman", Font.BOLD,20));
        heading.setForeground(Color.white);

        btn = new JButton("Submit");
        btn.setBounds(260,480,250,50);
        btn.setFont(new Font("Arial",Font.BOLD,18));
        btn.setForeground(new Color(255, 204, 153));

        radioButton = new JRadioButton("Levels -> Easy to Difficult");
        radioButton.setBounds(280,300,300,50);

        radioButton2 = new JRadioButton("Random Questions");
        radioButton2.setBounds(280,350,300,50);

        radioButton3 = new JRadioButton("Speedrun");
        radioButton3.setBounds(280,400,300,50);

        ImageIcon imageIcon = new ImageIcon("/Users/alisiakazimierek/Documents/mindmingle.jpg");
        Image image = imageIcon.getImage(); // Transform it into an Image object
        Image newImage = image.getScaledInstance(150, 150, Image.SCALE_SMOOTH); // Resize the image
        ImageIcon newImageIcon = new ImageIcon(newImage); // Transform it back to an ImageIcon
        imageLabel = new JLabel(newImageIcon);
        imageLabel.setBounds(100, 290, 150, 150); // Set the position and size of the image
        this.add(imageLabel);

        ButtonGroup bg = new ButtonGroup(); //this is to make the conceived as one, can only select one at a time
        bg.add(radioButton);
        bg.add(radioButton2);
        bg.add(radioButton3);



        this.add(radioButton);
        this.add(radioButton2);
        this.add(radioButton3);
        this.add(heading);
        this.add(title);
        this.add(btn);
        this.setVisible(true);

    }

}
