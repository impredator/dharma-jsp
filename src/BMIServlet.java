import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BMIServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws IOException, ServletException {

        String height = request.getParameter("height");
        String weight = request.getParameter("weight");

        double bmi = calculateBMI(
                Double.parseDouble(weight),
                Double.parseDouble(height));

        request.setAttribute("bmi", bmi);
        response.setHeader("Test", "Success");
        response.setHeader("BMI", String.valueOf(bmi));

        RequestDispatcher dispatcher
                = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }

    private Double calculateBMI(Double weight, Double height) {
        return weight / (height * height);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
