package webapp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@WebServlet(name="Calc", urlPatterns="/Calc")
public class Welcome extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		RequestWelcome welcome = RequestWelcome.fromRequestParameters(request);
        welcome.setAsRequestAttributesAndCalculate(request);

		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
    	private static class RequestWelcome {
		public RequestWelcome() {}

		public static RequestWelcome fromRequestParameters(HttpServletRequest request) {
			return new RequestWelcome();
		}

		public void setAsRequestAttributesAndCalculate(HttpServletRequest request) {
            SQLConnect.Connect();
            SQLConnect.CreateDB();
		}
	}
}
