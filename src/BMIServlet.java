import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BMIServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws IOException, ServletException {

        String height = request.getParameter("height");
        String weight = request.getParameter("weight");

        double bmi = calculateBMI(
                Double.parseDouble(weight),
                Double.parseDouble(height));

        String bmiResult = estimateRMI(bmi);

        request.setAttribute("bmiResult", bmiResult);
        response.setHeader("Test", "Success");
        response.setHeader("BMI", String.valueOf(bmi));

        RequestDispatcher dispatcher
                = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }

    private Double calculateBMI(Double weight, Double height) {
        return weight / (height * height);
    }

    private String estimateRMI(double bmi) {
        String result = "";
        if(bmi < 18.5) {
            result = "体重过轻";
        } else if(bmi < 25) {
            result = "体重正常";
        } else if(bmi < 30) {
            result = "肥胖前期";
        } else if(bmi < 35) {
            result = "一级肥胖";
        } else if(bmi < 40) {
            result = "二级肥胖";
        } else {
            result = "肥胖晚期";
        }
        return result;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
