package webapp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// TODO: Auto-generated Javadoc
/**
 * The Class Calc.
 * @author Khizbullina I.F.
 */
@WebServlet(name="Calc", urlPatterns="/Calc")
public class Calc extends HttpServlet {

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
		RequestCalc Calc = RequestCalc.fromRequestParameters(request);
		Calc.setAsRequestAttributesAndCalculate(request);

		request.getRequestDispatcher("/result.jsp").forward(request, response);
	}

	/**
	 * The Class RequestCalc.
	 */
	private static class RequestCalc {
		
		/** The order. */
		private final Order order;
		
		/** The clean services. */
		private String clean_services = "";

		/**
		 * Instantiates a new request calc.
		 *
		 * @param surname the surname
		 * @param name the name
		 * @param patronymic the patronymic
		 * @param address the address
		 * @param date_time the date time
		 * @param clean_area the clean area
		 * @param clean_type the clean type
		 * @param clean_service_1 the clean service 1
		 * @param clean_service_2 the clean service 2
		 * @param clean_service_3 the clean service 3
		 * @param clean_service_4 the clean service 4
		 * @param clean_service_5 the clean service 5
		 * @param clean_service_6 the clean service 6
		 * @param clean_service_7 the clean service 7
		 * @param clean_service_8 the clean service 8
		 */
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

		/**
		 * From request parameters.
		 *
		 * @param request the request
		 * @return the request calc
		 */
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

		/**
		 * Sets the as request attributes and calculate.
		 *
		 * @param request the new as request attributes and calculate
		 */
		public void setAsRequestAttributesAndCalculate(HttpServletRequest request) {
			request.setAttribute("surname", order.getSurname_calc());
			request.setAttribute("name", order.getName_calc());
			request.setAttribute("patronymic", order.getPatronymic_calc());
			request.setAttribute("address", order.getAddress_calc());
			request.setAttribute("date", order.getDate_calc());
			request.setAttribute("time", order.getTime_calc());
			request.setAttribute("clean_area", order.getClean_area_calc());
			request.setAttribute("clean_type", order.getClean_type_calc());

			order.Calculate();

			for (String clean_service: order.getClean_services()) {
				if (clean_service != null) {
					clean_services = clean_services + clean_service + "<br>";
				}
			}

			SQLConnect.insertOrder(order.getSurname_calc(), order.getName_calc(), order.getPatronymic_calc(), order.getAddress_calc(), order.getDate_calc(), order.getTime_calc(), Integer.parseInt(order.getClean_area_calc()), order.getClean_type_calc(), clean_services, order.getPrice());

			String number = String.valueOf(SQLConnect.getLastOrder());
			while (number.length() < 5) {
				number = "0" + number;
			}

			request.setAttribute("clean_services", clean_services);
			request.setAttribute("price", order.getPrice());
			request.setAttribute("number", number);
			request.setAttribute("result", SQLConnect.getResult());
			order.GeneratePDF();
		}
	}
}
