package webapp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="Calc", urlPatterns="/Calc")
public class Calc extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		RequestCalc Calc = RequestCalc.fromRequestParameters(request);
		Calc.setAsRequestAttributesAndCalculate(request);
		
		request.getRequestDispatcher("/result.jsp").forward(request, response);
	}
	
	private static class RequestCalc {
		private String surname_calc;
		private String name_calc;
		private String patronymic_calc;
		private String clean_calc;
		private String address_calc;
		private String data_time_calc;
		private String result;


		public RequestCalc(String surname, String name, String patronymic, String address, String data_time, String clean) {
			this.surname_calc = surname;
			this.name_calc = name;
			this.patronymic_calc = patronymic;
			this.address_calc = address;
			this.data_time_calc = data_time;
			this.clean_calc = clean;
		}
		
		public static RequestCalc fromRequestParameters(HttpServletRequest request) {
			return new RequestCalc(
					request.getParameter("surname"),
					request.getParameter("name"),
					request.getParameter("patronymic"),
					request.getParameter("address"),
					request.getParameter("data_time"),
					request.getParameter("clean"));
		}
		
		public void setAsRequestAttributesAndCalculate(HttpServletRequest request) {
			request.setAttribute("surname", surname_calc);
			request.setAttribute("name", name_calc);
			request.setAttribute("patronymic", patronymic_calc);
			request.setAttribute("address", address_calc);
			request.setAttribute("data_time", data_time_calc);
			request.setAttribute("clean", clean_calc);

			if (surname_calc == null) {
				result = "Не работает";
				request.setAttribute("result", result);
			} else {
				result = surname_calc + " " + name_calc + " " + patronymic_calc + " " + address_calc + " " + data_time_calc + " " + clean_calc;
				request.setAttribute("result", result);
			}
		}
	}
}
