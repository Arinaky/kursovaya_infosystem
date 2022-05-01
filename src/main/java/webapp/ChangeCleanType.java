package webapp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="ChangeCleanType", urlPatterns="/ChangeCleanType")
public class ChangeCleanType extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        RequestCleanType CleanType = RequestCleanType.fromRequestParameters(request);
        CleanType.setAsRequestAttributesAndCalculate(request, response);
        request.getRequestDispatcher("/admin.jsp").forward(request, response);
    }

    private static class RequestCleanType {
        private String clean_type_1;
        private String clean_type_2;
        private String clean_type_3;
        private String clean_type_4;

        public RequestCleanType(String clean_type_1, String clean_type_2, String clean_type_3, String clean_type_4) {
            this.clean_type_1 = clean_type_1;
            this.clean_type_2 = clean_type_2;
            this.clean_type_3 = clean_type_3;
            this.clean_type_4 = clean_type_4;
        }

        public static RequestCleanType fromRequestParameters(HttpServletRequest request) {
            return new RequestCleanType(
                    request.getParameter("clean_type_1"),
                    request.getParameter("clean_type_2"),
                    request.getParameter("clean_type_3"),
                    request.getParameter("clean_type_4"));
        }

        public void setAsRequestAttributesAndCalculate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            int clean_type_try;
            if (clean_type_1 != null) {
                try {
                    clean_type_try = Integer.parseInt(clean_type_1);
                    SQLConnect.changeDBValue("CleanType", "clean_type", "Генеральная", String.valueOf(clean_type_try));
                } catch (NumberFormatException e) {e.getMessage();}
            }
            if (clean_type_2 != null) {
                try {
                    clean_type_try = Integer.parseInt(clean_type_2);
                    SQLConnect.changeDBValue("CleanType", "clean_type", "Облегченная", String.valueOf(clean_type_try));
                } catch (NumberFormatException e) {e.getMessage();}
            }
            if (clean_type_3 != null) {
                try {
                    clean_type_try = Integer.parseInt(clean_type_3);
                    SQLConnect.changeDBValue("CleanType", "clean_type", "После ремонта", String.valueOf(clean_type_try));
                } catch (NumberFormatException e) {e.getMessage();}
            }
            if (clean_type_4 != null) {
                try {
                    clean_type_try = Integer.parseInt(clean_type_4);
                    SQLConnect.changeDBValue("CleanType", "clean_type", "Послестроительная", String.valueOf(clean_type_try));
                } catch (NumberFormatException e) {e.getMessage();}
            }
            request.setAttribute("result", SQLConnect.getResult());
        }
    }
}
