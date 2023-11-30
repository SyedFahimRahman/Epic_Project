package src;
import java.util.List;
    public class SpeedFormat {
        private String[] questionsArray;
        private String[][] answerChoicesArray;
        private char[] correctAnswersArray;

        private int currentQuestion = 0;
        private int score = 0;
        private boolean answeredInTime = false;

        public SpeedFormat(String[] questionsArray, String[][] answerChoicesArray, char[] correctAnswersArray) {
            this.questionsArray = questionsArray;
            this.answerChoicesArray = answerChoicesArray;
            this.correctAnswersArray = correctAnswersArray;
        }
        public void moveToNextQuestions(){
            if(!answeredInTime){
                moveToNextQuestion();
            }
        }
        public  boolean isQuizComplete(){
       return currentQuestion >= questionsArray.length - 1;
        }
        public  String getCurrentQuestion() {
            return questionsArray[currentQuestion];
        }

        public  String[] getCurrentAnswerChoices() {
            return answerChoicesArray[currentQuestion];
        }

        public  void checkAnswer(int selectedAnswer) {
            if (correctAnswersArray.length > currentQuestion) {
                char userAnswer = (char) ('A' + selectedAnswer);
                if (correctAnswersArray[currentQuestion] == userAnswer) {
                    score++;
                    answeredInTime = true;
                }
            }
            moveToNextQuestions();
        }

        private void moveToNextQuestion() {
            if (currentQuestion < questionsArray.length - 1) {
                currentQuestion++;
                answeredInTime = false; // Reset for the new question

            }
        }

        public int getScore() {
            return score;
        }

        public boolean hasAnsweredInTime() {
            return answeredInTime;
        }
    }

