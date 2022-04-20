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

		public RequestCalc(String surname, String name, String patronymic, String address, String date_time, String clean_area, String clean_type, String clean_service_1, String clean_service_2, String clean_service_3, String clean_service_4, String clean_service_5, String clean_service_6, String clean_service_7, String clean_service_8) {
			String date = "";
			String time = "";
			boolean itstime = false;
			for (int i = 0; i < date_time.length(); i++) {
				if (date_time.charAt(i) == 'T') {
					itstime = true;
				}
				if (itstime == true) {
					time = time + date_time.charAt(i);
				} else {
					date = date + date_time.charAt(i);
				}
			}
			order = new Order(surname, name, patronymic, address, date, time, clean_area, clean_type, clean_service_1, clean_service_2, clean_service_3, clean_service_4, clean_service_5, clean_service_6, clean_service_7, clean_service_8);
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
			request.setAttribute("date", order.getDate_calc());
			request.setAttribute("time", order.getTime_calc());
			request.setAttribute("clean_area", order.getClean_area_calc());
			request.setAttribute("clean_type", order.getClean_type_calc());

			SQLConnect.Connect();
			SQLConnect.CreateDB();

			order.Calculate();

			for (String clean_service: order.getClean_services()) {
				clean_services = clean_service + clean_service + "<br>";
			}

			request.setAttribute("clean_services", clean_services);
			request.setAttribute("result", SQLConnect.getResult());
		}
	}
}
