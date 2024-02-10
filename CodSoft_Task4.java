import java.util.*;

public class CodSoft_Task4  //Main class
{ 
    static class Question  //inner class
    {
        String questionText;
        List<String> options;
        int correctAnswerIndex;

        Question(String questionText, List<String> options, int correctAnswerIndex) //constructor of the inner class
        {
            this.questionText = questionText;
            this.options = options;
            this.correctAnswerIndex = correctAnswerIndex;
        }
    }

    public static void main(String[] args)  //main method
    {
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("What is the capital of India?", Arrays.asList("A. New Delhi", "B. Panjab", "C. Kashmir", "D. Asam"), 0));
        questions.add(new Question("Who was developed Java Programming Language?", Arrays.asList("A. Guido van Rossum", "B. James Gosling", "C. Dennis Ritchie", "D. Brendan Eich"), 1));
        questions.add(new Question("Which is a valid keyword in java?", Arrays.asList("A. Float", "B. string", "C. Array", "D. interface"), 3));
        questions.add(new Question("The brain of any computer system is", Arrays.asList("A. Memory", "B. Control unit", "C. CPU", "D. ALU"), 2));
        questions.add(new Question("The average of 20 numbers is zero. Of them, at the most, how many may be greater than zero?", Arrays.asList("A. 0", "B. 10", "C. 1", "D. 19"), 3));


        int score = 0;
        Scanner s1 = new Scanner(System.in);

        System.out.println("\nWelcome to the Quiz Game.");
        System.out.println("Note : For answer just enter A,B,C and D.");
        System.out.println("and You have only 10 seconds to answer a Question.");
        System.out.print("For Start the Game Just Click Enter Button.");
        s1.nextLine();
        System.out.println();
        
        for (int i = 0; i < questions.size(); i++) 
        {
            Question currentQuestion = questions.get(i);
            System.out.println("Question " + (i + 1) + ": " + currentQuestion.questionText);

            for (String option : currentQuestion.options) 
            {
                System.out.println(option);
            }
            Timer timer = new Timer();
            TimerTask task = new TimerTask() {
                public void run() {
                    System.out.println("Time's up!");
                    timer.cancel();
                }
            };
            timer.schedule(task, 10000); // Timer for 10 seconds

            System.out.print("Your answer: ");
            String userAnswer = s1.nextLine().toUpperCase();
            timer.cancel(); // Cancel the timer as soon as the user inputs their answer

            int userChoice = userAnswer.charAt(0) - 'A';
            if (userChoice == currentQuestion.correctAnswerIndex) 
            {
                System.out.println("Correct!");
                score++;
            } 
            else 
            {
                System.out.println("Incorrect! Correct answer is " + currentQuestion.options.get(currentQuestion.correctAnswerIndex));
            }
            System.out.println();
        }

        System.out.println("Quiz completed!");
        System.out.println("Your score: " + score + "/" + questions.size()+"\n");
        s1.close();
    }
}
