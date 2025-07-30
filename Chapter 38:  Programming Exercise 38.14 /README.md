## Additional Quiz Servlet

### Servlet Quiz: 
Creating an additional quiz servlet in Java involves defining a new Java class that extends HttpServlet and handles HTTP requests related to quiz functionality. This servlet would typically manage the display of quiz questions, process user answers, and potentially track scores based on right or wrong answers.

- <mark>@WebServlet("/QuizServlet"):</mark> This annotation maps the servlet to the /QuizServlet URL pattern.
  
- <mark>doGet():</mark> Handles initial requests, displays the current question, or the final score if the quiz is over.
  
- <mark>doPost():</mark> Handles answer submissions, validates them, updates the score, and moves to the next question.

- <mark>HttpSession:</mark> Used to maintain the currentQuestionIndex and score across multiple requests from the same user.

- <mark>Question class:</mark> A simple class to represent a question with its text, options, and the index of the correct answer.

Supposedly, the quizzes needed to dynamically load questions with the deployments. Consider the factors such as:

- Complie the Java code using a JDK
  
- Package the compiled servlet and its dependencies into a method file

- Deploy the method file into a Servlet container like Apache Tomcat

### Summary:
To store quiz questions and answers in a Java Servlet application, it's more efficient to use a database rather than static lists, as this allows for easier updates without code changes and redeployment. A recommended approach involves creating database tables for Questions, Answers, and perhaps Quizzes to effectively manage various sets of questions.

