import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

class Question {
    String question;
    String[] options;
    int correctAnswer;
    String level; // Easy, Medium, Hard

    Question(String question, String[] options, int correctAnswer, String level) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
        this.level = level;
    }
}
public class QuizApp {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        // Ask user name
        System.out.print("Enter your name: ");
        String userName = sc.nextLine();

        System.out.println("Choose Level: 1. Easy  2. Medium  3. Hard");
        int levelChoice = sc.nextInt();
        String chosenLevel = (levelChoice == 1) ? "Easy" : (levelChoice == 2) ? "Medium" : "Hard";

        // Question Bank with levels
        List<Question> quiz = Arrays.asList(
            new Question("Q1. Which keyword defines a class in Java?", 
                new String[]{"class","def","struct","object"},1,"Easy"),
            new Question("Q2. Entry point of Java program?", 
                new String[]{"start()","main()","run()","init()"},2,"Easy"),
            new Question("Q3. Default value of int in Java?",
                new String[]{"0","1","null","undefined"},1,"Easy"),
            new Question("Q4. Which loop executes at least once?",
                new String[]{"for","while","do-while","foreach"},3,"Easy"),
            new Question("Q5. Which operator is used for comparison?", 
                new String[]{"=","==","!=","<"},2,"Easy"),
            new Question("Q6. Which package is auto imported?",
                new String[]{"java.util","java.lang","java.io","java.sql"},2,"Easy"),
            new Question("Q7. Boolean default value?",
                new String[]{"true","false","null","0"},2,"Easy"),
            new Question("Q8. Which keyword is used to inherit a class?",
                new String[]{"extends","implements","inherit","super"},1,"Easy"),
            new Question("Q9. Which collection stores key-value pairs?",
                new String[]{"ArrayList","HashMap","LinkedList","TreeSet"},2,"Easy"),
            new Question("Q10. Which keyword is used to define a method?",
                new String[]{"func","method","def","void"},4,"Easy"),
            new Question("Q11. Which symbol is used for comments?",
                new String[]{"//","**","##","--"},1,"Easy"),
            new Question("Q12. Which data type stores characters?", 
                new String[]{"int","float","char","boolean"},3,"Easy"),
            new Question("Q13. Which keyword is used to stop loop?", 
                new String[]{"stop","exit","break","end"},3,"Easy"),
            new Question("Q14. Which keyword is used to continue loop?", 
                new String[]{"skip","next","continue","pass"},3,"Easy"),
            new Question("Q15. Which keyword is used to create object?", 
                new String[]{"new","create","object","instance"},1,"Easy"),
            //Medium Level Questions(15)
            new Question("Q16. Which keyword is used for interface implementation?",
                new String[]{"extends","implements","interface","inherit"},2,"Medium"),
            new Question("Q17. Which collection maintains insertion order?",
                new String[]{"HashSet","TreeSet","LinkedHashSet","HashMap"},3,"Medium"),
            new Question("Q18. Which exception occurs when dividing by zero?",
                new String[]{"NullPointerException","ArithmeticException","IOException","ClassCastException"},2,"Medium"),
            new Question("Q19. Which keyword prevents inheritance?",
                new String[]{"final","static","private","protected"},1,"Medium"),
            new Question("Q20. Which keyword is used for polymorphism?",
                new String[]{"abstract","override","extends","implements"},2,"Medium"),
            new Question("Q21. Which keyword is used for multiple inheritance?",
                new String[]{"extends","implements","super","final"},2,"Medium"),
            new Question("Q22. Which keyword is used for constructor chaining?",
                new String[]{"this","super","extends","return"},2,"Medium"),
            new Question("Q23. Which keyword is used for exception handling?",
                new String[]{"try","catch","throw","finally"},1,"Medium"),
            new Question("Q24. Which keyword is used to throw exception?",
                new String[]{"throw","throws","catch","error"},1,"Medium"),
            new Question("Q25. Which keyword is used to declare constant?",
                new String[]{"static","final","const","constant"},2,"Medium"),
            new Question("Q26. Which keyword is used for thread creation?",
                new String[]{"thread","Runnable","start","run"},2,"Medium"),
            new Question("Q27. Which keyword is used for synchronization?",
                new String[]{"sync","synchronized","lock","mutex"},2,"Medium"),
            new Question("Q28. Which keyword is used for package declaration?",
                new String[]{"package","import","namespace","module"},1,"Medium"),
            new Question("Q29. Which keyword is used for importing package?",
                new String[]{"include","import","package","use"},2,"Medium"),
            new Question("Q30. Which keyword is used for garbage collection?",
                new String[]{"delete","dispose","finalize","clear"},3,"Medium"),
            //Hard Level Questions(20)
            new Question("Q31. Which keyword is used for generic class?",
                new String[]{"generic","template","<>","type"},3,"Hard"),
            new Question("Q32. Which keyword is used for lambda expression?",
                new String[]{"->","=>","lambda","function"},1,"Hard"),
            new Question("Q33. Which keyword is used for reflection?",
             new String[]{"reflect","Class","Object","Method"},2,"Hard"),
            new Question("Q34. Which keyword is used for annotation?",
                new String[]{"@","annotation","meta","decorator"},1,"Hard"),
            new Question("Q35.  Which keyword is used for enum?",
                new String[]{"enum","enumeration","constant","list"},1,"Hard"),
            new Question("Q36. Which keyword is used for serialization?",
                new String[]{"Serializable","serial","save","persist"},1,"Hard"),
            new Question("Q37. Which keyword is used for transient variable?",
                new String[]{"transient","temporary","volatile","static"},1,"Hard"),
            new Question("Q38. Which keyword is used for volatile variable?",
                new String[]{"volatile","transient","static","final"},1,"Hard"),
            new Question("Q39. Which keyword is used for strictfp?",
                new String[]{"strictfp","fp","float","precision"},1,"Hard"),
            new Question("Q40. Which keyword is used for native method?",
                new String[]{"native","external","foreign","dll"},1,"Hard"),
            new Question("Q41. Which keyword is used for assert?",
                new String[]{"assert","check","verify","test"},1,"Hard"),
            new Question("Q42. Which keyword is used for module declaration?",
                new String[]{"module","package","namespace","import"},1,"Hard"),
            new Question("Q43. Which keyword is used for functional interface?",
                new String[]{"@FunctionalInterface","interface","abstract","lambda"},1,"Hard"),
            new Question("Q44. Which keyword is used for default method?",
                new String[]{"default","method","optional","base"},1,"Hard"),
            new Question("Q45. Which keyword is used for static block?",
                new String[]{"static","block","init","start"},1,"Hard"),
            new Question("Q46. Which keyword is used for dynamic binding?",
               new String[]{"dynamic","runtime","late","virtual"},2,"Hard"),
            new Question("Q47. Which keyword is used for checked exception?",
                new String[]{"IOException","RuntimeException","NullPointerException","Error"},1,"Hard"),
            new Question("Q48. Which keyword is used for unchecked exception?",
                new String[]{"RuntimeException","IOException","SQLException","Error"},1,"Hard"),
            new Question("Q49. Which keyword is used for marker interface?",
                new String[]{"Serializable","Cloneable","Marker","Empty"},2,"Hard"),
            new Question("Q50. Which keyword is used for cloning object?",
                new String[]{"clone","copy","duplicate","new"},1,"Hard")
            );
     // ✅ Filter questions by chosen level
        List<Question> selectedQuiz = new ArrayList<>();
        for (Question q : quiz) {
            if (q.level.equals(chosenLevel)) {
                selectedQuiz.add(q);
            }
        }
    int score = 0;
    int correct = 0, wrong = 0, skipped = 0, timeLimit = 30; // seconds

    // Quiz Loop
        for (int i = 0; i < selectedQuiz.size(); i++) {
            Question q = selectedQuiz.get(i);

        System.out.println("----------------------------");
        System.out.println("Question " + (i + 1) + " (" + q.level + ")");
        System.out.println(q.question);

        for (int j = 0; j < q.options.length; j++) {
            System.out.println((j + 1) + ". " + q.options[j]);
        }
        System.out.println("👉 Enter your answer (1-4). You have 30 seconds:");
        // Timer: 30 seconds
        long startTime = System.currentTimeMillis();
        int userAnswer = -1;

         while (true) {
            long elapsed = (System.currentTimeMillis() - startTime) / 1000;

            // ✅ Show live countdown
            System.out.print("\r⏳ Time left: " + (timeLimit - elapsed) + "s ");

            if (elapsed > timeLimit) {
                System.out.println("\n⏰ Time up! Skipped.\n");
                skipped++;
                break;
            }
            if (sc.hasNextInt()) {
                userAnswer = sc.nextInt();
                if (userAnswer >= 1 && userAnswer <= 4) break;
            } else {
                sc.next(); // clear invalid input
            }
        }
        if (userAnswer == q.correctAnswer) {
            System.out.println("✅ Correct!\n");
            score++;
            correct++;
        } else if (userAnswer != -1) {
            System.out.println("❌ Wrong! Correct answer is: " + q.correctAnswer + "\n");
            wrong++;
        }
    }

    // Final Score
    System.out.println("============================");
    System.out.println("🎯 Quiz Finished!");
     System.out.println("Player: " + userName);
    System.out.println("Score: " + score + "/" + selectedQuiz.size());
    System.out.println("Correct: " + correct + ", Wrong: " + wrong + ", Skipped: " + skipped);

    // Save result in file
    FileWriter fw = new FileWriter("results.txt", true);
        fw.write(userName + " | Level: " + chosenLevel +
                 " | Score: " + score + "/" + selectedQuiz.size() +
                 " | Correct: " + correct + " | Wrong: " + wrong + " | Skipped: " + skipped + "\n");
    fw.close();
    sc.close();
    }
}