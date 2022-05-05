package webapp;

import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// TODO: Auto-generated Javadoc
/**
 * The Class Authentication.
 * @author Yunusbaev R.I.
 */
@WebServlet(name="Auth", urlPatterns="/Auth")
public class Authentication extends HttpServlet {

    /**
     * Do post.
     *
     * @param request the request
     * @param response the response
     * @throws ServletException the servlet exception
     * @throws IOException Signals that an I/O exception has occurred.
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        RequestAuth Auth = RequestAuth.fromRequestParameters(request);
        Auth.setAsRequestAttributesAndCalculate(request, response);
    }

    /**
     * The Class RequestAuth.
     */
    private static class RequestAuth {
        
        /** The username. */
        private String username;
        
        /** The password. */
        private String password;
        
        /** The username password. */
        private HashMap<String, String> username_password = new HashMap<>();

        /**
         * Instantiates a new request auth.
         *
         * @param username the username
         * @param password the password
         */
        public RequestAuth(String username, String password) {
            this.username = username;
            this.password = password;
        }

        /**
         * From request parameters.
         *
         * @param request the request
         * @return the request auth
         */
        public static RequestAuth fromRequestParameters(HttpServletRequest request) {
            return new RequestAuth(
                    request.getParameter("username"),
                    request.getParameter("password"));
        }

        /**
         * Sets the as request attributes and calculate.
         *
         * @param request the request
         * @param response the response
         * @throws ServletException the servlet exception
         * @throws IOException Signals that an I/O exception has occurred.
         */
        public void setAsRequestAttributesAndCalculate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            request.setAttribute("username", username);
            request.setAttribute("password", password);

            username_password.put("123", "123");

            if (username_password.containsKey(username)) {
                if (username_password.get(username).equals(password)) {
                    request.getRequestDispatcher("/admin.jsp").forward(request, response);
                }
            }
        }
    }
}
