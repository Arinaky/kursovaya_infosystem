package webapp;

import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="Auth", urlPatterns="/Auth")
public class Authentication extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        RequestAuth Auth = RequestAuth.fromRequestParameters(request);
        Auth.setAsRequestAttributesAndCalculate(request, response);
    }

    private static class RequestAuth {
        private String username;
        private String password;
        private HashMap<String, String> username_password = new HashMap<>();

        public RequestAuth(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public static RequestAuth fromRequestParameters(HttpServletRequest request) {
            return new RequestAuth(
                    request.getParameter("username"),
                    request.getParameter("password"));
        }

        public void setAsRequestAttributesAndCalculate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            request.setAttribute("username", username);
            request.setAttribute("password", password);

            username_password.put("123", "123");

            if (username_password.containsKey(username)) {
                if (username_password.get(username).equals(password)) {
                    request.getRequestDispatcher("/admin.jsp").forward(request, response);
                }
            }
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }
}
