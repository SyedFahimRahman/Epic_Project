package src;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class GUIimproved extends JFrame {
    //GUI components
   private JRadioButton[] answerRadioButtons;
  private  JLabel questionLabel, title;

   private ButtonGroup radioButtonGroup;
   private Timer questionTimer;
   private JLabel timerLabel;
//cuyrrent q index
    int currentQuestion = 0;
//arrays to store the qs , answer choices and the correct answer
    String[] questionsArray;
    String[][] answerChoicesArray;
    char[] correctAnswersArray;
    //flag to track if the user answered the q in time
    private boolean answeredInTime = false; //to track if the user answered in the time frame

    private SpeedFormat speedFormat;

    //constructor to intialize tthe GUI
    public GUIimproved(String[] questionsArray, String[][] answerChoicesArray, char[] correctAnswersArray) {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 800);
        this.setTitle("Mind Mingle");
        this.setLocationRelativeTo(null); // this centers the window on the screen
        this.setLayout(null);
        this.getContentPane().setBackground(new Color(255, 204, 153));
//initialising data from parameters
        this.questionsArray = questionsArray;
        this.answerChoicesArray = answerChoicesArray;
        this.correctAnswersArray = correctAnswersArray;
        this.speedFormat = speedFormat;
        title = new JLabel("Mind Mingle");
        title.setBounds(200, 50, 360, 50);
        title.setFont(new Font("Chalkduster", Font.BOLD, 28));
        title.setBackground(Color.white);
        title.setOpaque(true);
        title.setForeground(new Color(255, 204, 153));
        title.setBorder(new EmptyBorder(0, 10, 0, 0));

        questionLabel = new JLabel("<html>" + questionsArray[currentQuestion] + "<html>");
        questionLabel.setBounds(120, 120, 600, 100);
        questionLabel.setFont(new Font("Arial", Font.BOLD, 18));
        questionLabel.setBorder(new EmptyBorder(0, 10, 0, 0));

        answerRadioButtons = new JRadioButton[4];
        radioButtonGroup = new ButtonGroup();

        timerLabel = new JLabel("Time left : 15 seconds");
        timerLabel.setBounds(120, 650, 600, 20);
        timerLabel.setFont(new Font("Arial", Font.BOLD, 14));


        for (int i = 0; i < answerChoicesArray[currentQuestion].length; i++) { //because one option has less than 4 answer choices, i changed it to answerChoicesArray[currentQuestion].length
            answerRadioButtons[i] = new JRadioButton("<html>" + answerChoicesArray[currentQuestion][i] + "<html>");
            answerRadioButtons[i].setBounds(300, 200 + i * 100, 300, 150);
            radioButtonGroup.add(answerRadioButtons[i]);
            this.add(answerRadioButtons[i]);

            int lasti = i; //this is needed to access i in actionlistener
            answerRadioButtons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    questionTimer.stop(); //stop the timer when a user makes a choice
                    speedFormat.checkAnswer(lasti);
                    moveToNextQuestion();
                }
            });
        }
        this.add(timerLabel);
        this.add(questionLabel);
        this.add(title);
        this.setVisible(true); // displaying the gui

        startTimer();

    }

    // Method to initialize and start the timer
    private void startTimer() {

        //This for the timer to move onto the next question after 20secs
        questionTimer = new Timer(1000, new ActionListener() { //reduce the timer delay
            int remainingTime = 15; //15 seconds

            @Override
            public void actionPerformed(ActionEvent e) {
                remainingTime--;

                if (remainingTime >= 0) {
                    updateTimerLabel(remainingTime);
                } else {
                    questionTimer.stop();
                    if (!speedFormat.isQuizComplete()) {
                        speedFormat.moveToNextQuestions();
                    }
                }
            }
        });
        questionTimer.setRepeats(true);
        questionTimer.start();

    }
    // Method to update the timer label
    private void updateTimerLabel(int remainingTime) {
        timerLabel.setText("Time left: " + remainingTime + " seconds");
    }

    private void moveToNextQuestion() {  // Method to move to the next question
            questionTimer.stop();

        if (speedFormat.isQuizComplete()) {
            JOptionPane.showMessageDialog(this, "Quiz completed! Your final score is: " + speedFormat.getScore());
            JDialog dialog = new JDialog();
            dialog.setAlwaysOnTop(true);
            JOptionPane.showMessageDialog(dialog, "Go back to the main page?", "Back to Main Page", JOptionPane.INFORMATION_MESSAGE);
            new FormatChoice();
        } else {
            questionLabel.setText("<html>" + speedFormat.getCurrentQuestion() + "<html>");

            // Clears existing radio buttons
            radioButtonGroup.clearSelection();
            for (int i = 0; i < answerRadioButtons.length; i++) {
                this.remove(answerRadioButtons[i]);
            }

            // Initializes new radio buttons for the new question
            String[] answerChoices = speedFormat.getCurrentAnswerChoices();
            answerRadioButtons = new JRadioButton[answerChoices.length];
            for (int i = 0; i < answerChoices.length; i++) {
                answerRadioButtons[i] = new JRadioButton("<html>" + answerChoices[i] + "<html>");
                answerRadioButtons[i].setBounds(300, 200 + i * 100, 300, 150);
                radioButtonGroup.add(answerRadioButtons[i]);
                this.add(answerRadioButtons[i]);

                int lasti = i; // This is needed to access i in ActionListener
                answerRadioButtons[i].addActionListener(e -> {
                    speedFormat.checkAnswer(lasti);
                    questionTimer.stop();
                    moveToNextQuestion();
                });
            }

            startTimer();
            this.repaint();
        }
    }}