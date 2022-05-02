package webapp;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

@WebServlet(name="test", urlPatterns="/test")
public class test extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		RequestWelcome welcome = RequestWelcome.fromRequestParameters(request);
        welcome.setAsRequestAttributesAndCalculate(request);
		response.getWriter().write("hello");
		response.getWriter().flush();
		request.getRequestDispatcher("/welcome.jsp").forward(request, response);
	}
    	private static class RequestWelcome {
		public RequestWelcome() {}

		public static RequestWelcome fromRequestParameters(HttpServletRequest request) {
			return new RequestWelcome();
		}

		public void setAsRequestAttributesAndCalculate(HttpServletRequest request) {

		}
	}
}
