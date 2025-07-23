import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;
import java.io.IOException;

@WebServlet(name = "QuizServlet", urlPatterns = "/quizSubmit")
public class QuizServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // Retrieve parameters from the HTML form
        String question1Answer = request.getParameter("question1");
        String question2Answer = request.getParameter("question2");
        String question3Answer = request.getParameter("question3");
        String question4Answer = request.getParameter("question4");
        String question5Answer = request.getParameter("question5");

        // Basic validation and processing (for demonstration purposes)
        int score = 0;
        if ("correct_answer_q1".equalsIgnoreCase(question1Answer)) {
            score++;
        }
        if ("correct_answer_q2".equalsIgnoreCase(question2Answer)) {
            score++;
        }
        if ("correct_answer_q3".equalsIgnoreCase(question3Answer)) {
            score++;
        }
        if ("correct_answer_q4".equalsIgnoreCase(question4Answer)) {
            score++;
        }
        if ("correct_answer_q5".equalsIgnoreCase(question5Answer)) {
            score++;
        }
        
        // Store correct answers (example - you'd fetch this from a source like a database)
        Map<String, String> correctAnswers = new HashMap<>();
        correctAnswers.put("question1", "correct_answer_q1");
        correctAnswers.put("question2", "correct_answer_q2");
        correctAnswers.put("question3", "correct_answer_q3");
        correctAnswers.put("question4", "correct_answer_q4");
        correctAnswers.put("question5", "correct_answer_q5");
        
        List<String> incorrectQuestions = new ArrayList<>();
        if (!"correct_answer_q1".equalsIgnoreCase(question1Answer)) {
            incorrectQuestions.add("Question 1: What color is the sky?"); // Or the full question text
        }
        if (!"correct_answer_q2".equalsIgnoreCase(question2Answer)) {
            incorrectQuestions.add("Question 2: What is 2 + 2?");
        }
        if (!"correct_answer_q3".equalsIgnoreCase(question3Answer)) {
            incorrectQuestions.add("Question 3: What is 5 x 4?");
        }
        if (!"correct_answer_q4".equalsIgnoreCase(question4Answer)) {
            incorrectQuestions.add("Question 4: Where can you buy the books?");
        }
        if (!"correct_answer_q5".equalsIgnoreCase(question5Answer)) {
            incorrectQuestions.add("Question 5: Convert decimal to fraction 62.82?");
        }
        
        request.setAttribute("userScore", score);
        request.setAttribute("incorrectQuestions", incorrectQuestions);
        request.setAttribute("correctAnswers", correctAnswers); // To show correct answers for missed questions

        // Forward to a JSP page to display the results
        request.getRequestDispatcher("/quizResult.jsp").forward(request, response);
    }
}
