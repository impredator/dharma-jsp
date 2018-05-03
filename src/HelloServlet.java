import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HelloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println(
                "<!DOCTYPE html><html>" +
                        "<head>" +
                        "<meta charset=\"UTF-8\" />" +
                        "<title>HTML Rendered by Servlet</title>" +
                        "</head>" +
                        "<body>" +
                        "<h1>HTML Rendered by Servlet</h1></br>" +
                        "<p>This page was rendered by the Hello Servlet!</p>" +
                        "</body>" +
                        "</html>"
        );
    }
}
