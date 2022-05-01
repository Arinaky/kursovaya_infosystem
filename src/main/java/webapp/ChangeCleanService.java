package webapp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="ChangeCleanService", urlPatterns="/ChangeCleanService")
public class ChangeCleanService extends HttpServlet {
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        RequestCleanService CleanService = RequestCleanService.fromRequestParameters(request);
        CleanService.setAsRequestAttributesAndCalculate(request, response);
        request.getRequestDispatcher("/admin.jsp").forward(request, response);
    }

    private static class RequestCleanService {
        private String clean_service_1;
        private String clean_service_2;
        private String clean_service_3;
        private String clean_service_4;
        private String clean_service_5;
        private String clean_service_6;
        private String clean_service_7;
        private String clean_service_8;

        public RequestCleanService(String clean_service_1, String clean_service_2, String clean_service_3, String clean_service_4, String clean_service_5, String clean_service_6, String clean_service_7, String clean_service_8) {
            this.clean_service_1 = clean_service_1;
            this.clean_service_2 = clean_service_2;
            this.clean_service_3 = clean_service_3;
            this.clean_service_4 = clean_service_4;
            this.clean_service_5 = clean_service_5;
            this.clean_service_6 = clean_service_6;
            this.clean_service_7 = clean_service_7;
            this.clean_service_8 = clean_service_8;
        }

        public static RequestCleanService fromRequestParameters(HttpServletRequest request) {
            return new RequestCleanService(
                    request.getParameter("clean_service_1"),
                    request.getParameter("clean_service_2"),
                    request.getParameter("clean_service_3"),
                    request.getParameter("clean_service_4"),
                    request.getParameter("clean_service_5"),
                    request.getParameter("clean_service_6"),
                    request.getParameter("clean_service_7"),
                    request.getParameter("clean_service_8"));
        }

        public void setAsRequestAttributesAndCalculate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            int clean_type_try;
            String result = null;
            if (clean_service_1 != null) {
                try {
                    clean_type_try = Integer.parseInt(clean_service_1);
                    SQLConnect.changeDBValue("CleanServices", "clean_service", "Полировка полов", String.valueOf(clean_type_try));
                } catch (NumberFormatException e) {result = e.getMessage();}
            }
            if (clean_service_2 != null) {
                try {
                    clean_type_try = Integer.parseInt(clean_service_2);
                    SQLConnect.changeDBValue("CleanServices", "clean_service", "Мытье посуды", String.valueOf(clean_type_try));
                } catch (NumberFormatException e) {result = e.getMessage();}
            }
            if (clean_service_3 != null) {
                try {
                    clean_type_try = Integer.parseInt(clean_service_3);
                    SQLConnect.changeDBValue("CleanServices", "clean_service", "Стирка+глажка", String.valueOf(clean_type_try));
                } catch (NumberFormatException e) {result = e.getMessage();}
            }
            if (clean_service_4 != null) {
                try {
                    clean_type_try = Integer.parseInt(clean_service_4);
                    SQLConnect.changeDBValue("CleanServices", "clean_service", "Мытье окон", String.valueOf(clean_type_try));
                } catch (NumberFormatException e) {result = e.getMessage();}
            }
            if (clean_service_5 != null) {
                try {
                    clean_type_try = Integer.parseInt(clean_service_5);
                    SQLConnect.changeDBValue("CleanServices", "clean_service", "Уборка стен", String.valueOf(clean_type_try));
                } catch (NumberFormatException e) {result = e.getMessage();}
            }
            if (clean_service_6 != null) {
                try {
                    clean_type_try = Integer.parseInt(clean_service_6);
                    SQLConnect.changeDBValue("CleanServices", "clean_service", "Чистка унитаза", String.valueOf(clean_type_try));
                } catch (NumberFormatException e) {result = e.getMessage();}
            }
            if (clean_service_7 != null) {
                try {
                    clean_type_try = Integer.parseInt(clean_service_7);
                    SQLConnect.changeDBValue("CleanServices", "clean_service", "Чистка раковин", String.valueOf(clean_type_try));
                } catch (NumberFormatException e) {result = e.getMessage();}
            }
            if (clean_service_8 != null) {
                try {
                    clean_type_try = Integer.parseInt(clean_service_8);
                    SQLConnect.changeDBValue("CleanServices", "clean_service", "Уборка балкона", String.valueOf(clean_type_try));
                } catch (NumberFormatException e) {result = e.getMessage();}
            }
            request.setAttribute("result", result);
        }
    }
}
