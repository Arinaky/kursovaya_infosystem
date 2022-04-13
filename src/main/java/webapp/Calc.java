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
		private final Order order;
		private String clean_services = "";
		private String result;


		public RequestCalc(String surname, String name, String patronymic, String address, String date_time, String clean_area, String clean_type, String clean_service_1, String clean_service_2, String clean_service_3, String clean_service_4, String clean_service_5, String clean_service_6, String clean_service_7, String clean_service_8) {
			order = new Order(surname, name, patronymic, address, date_time, clean_area, clean_type, clean_service_1, clean_service_2, clean_service_3, clean_service_4, clean_service_5, clean_service_6, clean_service_7, clean_service_8);
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
			request.setAttribute("surname", order.getSurname_calc());
			request.setAttribute("name", order.getName_calc());
			request.setAttribute("patronymic", order.getPatronymic_calc());
			request.setAttribute("address", order.getAddress_calc());
			request.setAttribute("date_time", order.getDate_time_calc());
			request.setAttribute("clean_area", order.getClean_area_calc());
			request.setAttribute("clean_type", order.getClean_type_calc());
			request.setAttribute("clean_service_1", order.getClean_service_1_calc());
			request.setAttribute("clean_service_2", order.getClean_service_2_calc());
			request.setAttribute("clean_service_3", order.getClean_service_3_calc());
			request.setAttribute("clean_service_4", order.getClean_service_4_calc());
			request.setAttribute("clean_service_5", order.getClean_service_5_calc());
			request.setAttribute("clean_service_6", order.getClean_service_6_calc());
			request.setAttribute("clean_service_7", order.getClean_service_7_calc());
			request.setAttribute("clean_service_8", order.getClean_service_8_calc());

			order.Calculate();

			if (order.getClean_service_1_calc() != null) {clean_services = clean_services + order.getClean_service_1_calc() + "<br>";}
			if (order.getClean_service_2_calc() != null) {clean_services = clean_services + order.getClean_service_2_calc() + "<br>";}
			if (order.getClean_service_3_calc() != null) {clean_services = clean_services + order.getClean_service_3_calc() + "\n";}
			if (order.getClean_service_4_calc() != null) {clean_services = clean_services + order.getClean_service_4_calc() + "\n";}
			if (order.getClean_service_5_calc() != null) {clean_services = clean_services + order.getClean_service_5_calc() + "\n";}
			if (order.getClean_service_6_calc() != null) {clean_services = clean_services + order.getClean_service_6_calc() + "\n";}
			if (order.getClean_service_7_calc() != null) {clean_services = clean_services + order.getClean_service_7_calc() + "\n";}
			if (order.getClean_service_8_calc() != null) {clean_services = clean_services + order.getClean_service_8_calc() + "\n";}

			request.setAttribute("clean_services", clean_services);
			request.setAttribute("result", order.getPrice());
		}
	}
}
