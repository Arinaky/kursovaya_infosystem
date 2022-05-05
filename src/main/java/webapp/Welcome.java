package webapp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

// TODO: Auto-generated Javadoc
/**
 * The Class Welcome.
 * @author Yunusbaev R.I.
 */
@WebServlet(name="welcome", urlPatterns="/welcome")
public class Welcome extends HttpServlet {
    
    /**
     * Do post.
     *
     * @param request the request
     * @param response the response
     * @throws ServletException the servlet exception
     * @throws ServletException the servlet exception
     * @throws IOException Signals that an I/O exception has occurred.
     * @throws IOException Signals that an I/O exception has occurred.
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		RequestWelcome welcome = RequestWelcome.fromRequestParameters(request);
        welcome.setAsRequestAttributesAndCalculate(request);

		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
    	
	    /**
	     * The Class RequestWelcome.
	     */
	    private static class RequestWelcome {
		
		/**
		 * Instantiates a new request welcome.
		 */
		public RequestWelcome() {}

		/**
		 * From request parameters.
		 *
		 * @param request the request
		 * @return the request welcome
		 */
		public static RequestWelcome fromRequestParameters(HttpServletRequest request) {
			return new RequestWelcome();
		}

		/**
		 * Sets the as request attributes and calculate.
		 *
		 * @param request the new as request attributes and calculate
		 */
		public void setAsRequestAttributesAndCalculate(HttpServletRequest request) {
            SQLConnect.Connect();
            SQLConnect.CreateDB();
		}
	}
}
