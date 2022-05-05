package webapp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// TODO: Auto-generated Javadoc
/**
 * The Class ChangeCleanArea.
 * @author Shimanov K.A.
 */
@WebServlet(name="ChangeCleanArea", urlPatterns="/ChangeCleanArea")
public class ChangeCleanArea extends HttpServlet {
    
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
        RequestCleanArea CleanArea = RequestCleanArea.fromRequestParameters(request);
        CleanArea.setAsRequestAttributesAndCalculate(request, response);
        request.getRequestDispatcher("/admin.jsp").forward(request, response);
    }

    /**
     * The Class RequestCleanArea.
     */
    private static class RequestCleanArea {
        
        /** The clean area. */
        private String clean_area;

        /**
         * Instantiates a new request clean area.
         *
         * @param clean_area the clean area
         */
        public RequestCleanArea(String clean_area) {
            this.clean_area = clean_area;
        }

        /**
         * From request parameters.
         *
         * @param request the request
         * @return the request clean area
         */
        public static RequestCleanArea fromRequestParameters(HttpServletRequest request) {
            return new RequestCleanArea(
                    request.getParameter("clean_area"));
        }

        /**
         * Sets the as request attributes and calculate.
         *
         * @param request the request
         * @param response the response
         * @throws ServletException the servlet exception
         * @throws IOException Signals that an I/O exception has occurred.
         */
        public void setAsRequestAttributesAndCalculate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            if (clean_area != "") {
                int clean_area_try;
                try {
                    request.setAttribute("clean_area", clean_area);
                    clean_area_try = Integer.parseInt(clean_area);
                    SQLConnect.changeDBValue("CleanArea", "clean_area", "Площадь помещения", String.valueOf(clean_area_try));
                    request.setAttribute("result", SQLConnect.getResult());
                } catch (NumberFormatException e) {
                    e.getMessage();
                }
            }
        }
    }
}
