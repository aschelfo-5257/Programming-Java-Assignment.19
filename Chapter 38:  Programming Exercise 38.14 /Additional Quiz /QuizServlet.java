import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

@WebServlet(name = "QuizServlet", urlPatterns = "/quizSubmit")
/**
 * QuizServlet processes quiz submissions from a web form.
 * <p>
 * It evaluates user answers, calculates the score,
 * identifies incorrect responses, and forwards results to a JSP page.
 * </p>
 * 
 * Servlet URL: {@code /quizSubmit}
 */
@WebServlet(name = "QuizServlet", urlPatterns = "/quizSubmit")
public class QuizServlet extends HttpServlet {

    private static final Map<String, String> correctAnswers = new HashMap<>();

    static {
        // Initialize correct answers
        correctAnswers.put("question1", "correct_answer_q1");
        correctAnswers.put("question2", "correct_answer_q2");
        correctAnswers.put("question3", "correct_answer_q3");
        correctAnswers.put("question4", "correct_answer_q4");
        correctAnswers.put("question5", "correct_answer_q5");
    }
     /**
     * Handles HTTP POST requests for quiz submissions.
     * <p>
     * Retrieves user answers from the request, compares them to the correct answers,
     * calculates the total score, identifies incorrect questions, and
     * forwards the result to {@code quizResult.jsp}.
     * </p>
     *
     * @param request  the {@code HttpServletRequest} object that contains the form data
     * @param response the {@code HttpServletResponse} object used to return the result
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs during request handling
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        // Retrieve user responses
        Map<String, String> userAnswers = new HashMap<>();
        userAnswers.put("question1", request.getParameter("question1"));
        userAnswers.put("question2", request.getParameter("question2"));
        userAnswers.put("question3", request.getParameter("question3"));
        userAnswers.put("question4", request.getParameter("question4"));
        userAnswers.put("question5", request.getParameter("question5"));

        int score = 0;
        List<String> incorrectQuestions = new ArrayList<>();

        for (Map.Entry<String, String> entry : correctAnswers.entrySet()) {
            String questionKey = entry.getKey();
            String correctAnswer = entry.getValue();
            String userAnswer = userAnswers.get(questionKey);

            if (correctAnswer.equalsIgnoreCase(userAnswer)) {
                score++;
            } else {
                incorrectQuestions.add(getFullQuestionText(questionKey));
            }
        }

        // Set attributes for result display
        request.setAttribute("userScore", score);
        request.setAttribute("incorrectQuestions", incorrectQuestions);
        request.setAttribute("correctAnswers", correctAnswers);

        // Forward to the results JSP page
        request.getRequestDispatcher("/quizResult.jsp").forward(request, response);
    }

    /**
     * Returns the full text of a quiz question based on its key.
     *
     * @param questionKey the identifier for the question (e.g., "question1")
     * @return the full question text, or "Unknown Question" if not found
     */
    private String getFullQuestionText(String questionKey) {
        return switch (questionKey) {
            case "question1" -> "Question 1: What color is the sky?";
            case "question2" -> "Question 2: What is 2 + 2?";
            case "question3" -> "Question 3: What is 5 x 4?";
            case "question4" -> "Question 4: Where can you buy the books?";
            case "question5" -> "Question 5: Convert decimal to fraction 62.82?";
            default -> "Unknown Question";
        };
    }
}
