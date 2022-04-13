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
		private String address_calc;
		private String date_time_calc;
		private String clean_area_calc;
		private String clean_type_calc;
		private String clean_service_1_calc;
		private String clean_service_2_calc;
		private String clean_service_3_calc;
		private String clean_service_4_calc;
		private String clean_service_5_calc;
		private String clean_service_6_calc;
		private String clean_service_7_calc;
		private String clean_service_8_calc;
		private String result;


		public RequestCalc(String surname, String name, String patronymic, String address, String date_time, String clean_area, String clean_type, String clean_service_1, String clean_service_2, String clean_service_3, String clean_service_4, String clean_service_5, String clean_service_6, String clean_service_7, String clean_service_8) {
			this.surname_calc = surname;
			this.name_calc = name;
			this.patronymic_calc = patronymic;
			this.address_calc = address;
			this.date_time_calc = date_time;
			this.clean_area_calc = clean_area;
			this.clean_type_calc = clean_type;
			this.clean_service_1_calc = clean_service_1;
			this.clean_service_2_calc = clean_service_2;
			this.clean_service_3_calc = clean_service_3;
			this.clean_service_4_calc = clean_service_4;
			this.clean_service_5_calc = clean_service_5;
			this.clean_service_6_calc = clean_service_6;
			this.clean_service_7_calc = clean_service_7;
			this.clean_service_8_calc = clean_service_8;
		}

		public static RequestCalc fromRequestParameters(HttpServletRequest request) {
			return new RequestCalc(
					request.getParameter("surname"),
					request.getParameter("name"),
					request.getParameter("patronymic"),
					request.getParameter("address"),
					request.getParameter("date_time"),
					request.getParameter("clean_area"),
					request.getParameter("clean_type"),
					request.getParameter("clean_service_1"),
					request.getParameter("clean_service_2"),
					request.getParameter("clean_service_3"),
					request.getParameter("clean_service_4"),
					request.getParameter("clean_service_5"),
					request.getParameter("clean_service_6"),
					request.getParameter("clean_service_7"),
					request.getParameter("clean_service_8")	);
		}
		
		public void setAsRequestAttributesAndCalculate(HttpServletRequest request) {
			request.setAttribute("surname", surname_calc);
			request.setAttribute("name", name_calc);
			request.setAttribute("patronymic", patronymic_calc);
			request.setAttribute("address", address_calc);
			request.setAttribute("date_time", date_time_calc);
			request.setAttribute("clean_area", clean_area_calc);
			request.setAttribute("clean_type", clean_type_calc);
			request.setAttribute("clean_service_1", clean_service_1_calc);
			request.setAttribute("clean_service_2", clean_service_2_calc);
			request.setAttribute("clean_service_3", clean_service_3_calc);
			request.setAttribute("clean_service_4", clean_service_4_calc);
			request.setAttribute("clean_service_5", clean_service_5_calc);
			request.setAttribute("clean_service_6", clean_service_6_calc);
			request.setAttribute("clean_service_7", clean_service_7_calc);
			request.setAttribute("clean_service_8", clean_service_8_calc);

			result = clean_service_1_calc;
			request.setAttribute("result", result);
		}
	}
}
