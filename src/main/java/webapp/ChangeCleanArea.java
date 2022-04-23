package webapp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="ChangeCleanArea", urlPatterns="/ChangeCleanArea")
public class ChangeCleanArea extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        RequestCleanArea CleanArea = RequestCleanArea.fromRequestParameters(request);
        CleanArea.setAsRequestAttributesAndCalculate(request, response);
    }

    private static class RequestCleanArea {
        private String clean_area;

        public RequestCleanArea(String clean_area) {
            this.clean_area = clean_area;
        }

        public static RequestCleanArea fromRequestParameters(HttpServletRequest request) {
            return new RequestCleanArea(
                    request.getParameter("clean_area"));
        }

        public void setAsRequestAttributesAndCalculate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            if (clean_area != null) {
                int clean_area_try;
                try {
                    clean_area_try = Integer.parseInt(clean_area);
                    SQLConnect.changeDBValue("CleanArea", "clean_area", "Площадь помещения", String.valueOf(clean_area_try));
                } catch (NumberFormatException e) {
                    e.getMessage();
                }
            }
        }
    }
}
