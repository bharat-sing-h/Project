import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class QuizWithTimer {
    public static void main(String[] args) {
        Quiz quiz = new Quiz(10); // Set the timer duration to 10 seconds

        // Add questions to the quiz
        quiz.addQuestion("Who won the Cricket World Cup 2023 ?", List.of("Australia", "India", "England", "South Africa"), 0);
        quiz.addQuestion("Which country host Olympics 2024 ?", List.of("India", "France", "Saudi Arabia", "China"), 1);
        quiz.addQuestion("What is the full form of IPS ?", List.of("Indian Police Service", "Indian Public Service", "Indian Public Security", "Indian Police Security"), 0);
        quiz.addQuestion("Who won the FIFA World Cup 2022 ?", List.of("Germany", "France", "England", "Argentina"), 3);
        quiz.addQuestion("Rainbow consist of how many colours?", List.of("6", "7", "8", "5"), 1);
        // Start the quiz
        quiz.startQuiz();
    }
}

class Quiz {
    private List<Question> questions;
    private int currentQuestionIndex;
    private int score;
    private final int timerDuration; // Time limit for each question in seconds

    public Quiz(int timerDuration) {
        this.questions = new ArrayList<>();
        this.currentQuestionIndex = 0;
        this.score = 0;
        this.timerDuration = timerDuration;
    }

    public void addQuestion(String question, List<String> options, int correctAnswer) {
        questions.add(new Question(question, options, correctAnswer));
    }

    public void displayQuestion() {
        Question currentQuestion = questions.get(currentQuestionIndex);
        System.out.println("Question " + (currentQuestionIndex + 1) + ": " + currentQuestion.getQuestion());

        for (int i = 0; i < currentQuestion.getOptions().size(); i++) {
            System.out.println((i + 1) + ". " + currentQuestion.getOptions().get(i));
        }
        System.out.println("");
        System.out.print("Please choose the option :- ");

    }

    public void submitAnswer(int userAnswer) {
        Question currentQuestion = questions.get(currentQuestionIndex);
        int correctAnswerIndex = currentQuestion.getCorrectAnswer()+1;

        if (userAnswer == correctAnswerIndex) {
            System.out.println("Correct!");
            score++;
            System.out.println("The right answer is " + (correctAnswerIndex));
            System.out.println("");
        } else {
            System.out.println("The right answer is " + (correctAnswerIndex));
            System.out.println("");
        }
    }

    public void displayResult() {
        System.out.println("\nQuiz Result:");
        System.out.println("Total Score: " + score + "/" + questions.size());
    }


    public void startQuiz() {
        System.out.println("Welcome to the Quiz!\n");

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("\nTime's up! Moving to the next question.");
                System.out.println("");
                nextQuestion();
                displayQuestion();
            }
        }, timerDuration * 1000);
    

        while (currentQuestionIndex < questions.size()) {
            displayQuestion();
            Scanner scanner = new Scanner(System.in);
            int userAnswer = scanner.nextInt();
            submitAnswer(userAnswer);
            timer.cancel(); // Cancel the timer after the user submits an answer

            // Move to the next question
            nextQuestion();
        }

        // Display final result
        displayResult();
    }

    private void nextQuestion() {
        currentQuestionIndex++;
    }
}

class Question {
    private String question;
    private List<String> options;
    private int correctAnswer;

    public Question(String question, List<String> options, int correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getOptions() {
        return options;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }
}
