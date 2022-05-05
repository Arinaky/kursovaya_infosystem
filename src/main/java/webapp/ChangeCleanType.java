package webapp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// TODO: Auto-generated Javadoc
/**
 * The Class ChangeCleanType.
 * @author Shimanov K.A.
 */
@WebServlet(name="ChangeCleanType", urlPatterns="/ChangeCleanType")
public class ChangeCleanType extends HttpServlet {
    
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
        RequestCleanType CleanType = RequestCleanType.fromRequestParameters(request);
        CleanType.setAsRequestAttributesAndCalculate(request, response);
        request.getRequestDispatcher("/admin.jsp").forward(request, response);
    }

    /**
     * The Class RequestCleanType.
     */
    private static class RequestCleanType {
        
        /** The clean type 1. */
        private String clean_type_1;
        
        /** The clean type 2. */
        private String clean_type_2;
        
        /** The clean type 3. */
        private String clean_type_3;
        
        /** The clean type 4. */
        private String clean_type_4;

        /**
         * Instantiates a new request clean type.
         *
         * @param clean_type_1 the clean type 1
         * @param clean_type_2 the clean type 2
         * @param clean_type_3 the clean type 3
         * @param clean_type_4 the clean type 4
         */
        public RequestCleanType(String clean_type_1, String clean_type_2, String clean_type_3, String clean_type_4) {
            this.clean_type_1 = clean_type_1;
            this.clean_type_2 = clean_type_2;
            this.clean_type_3 = clean_type_3;
            this.clean_type_4 = clean_type_4;
        }

        /**
         * From request parameters.
         *
         * @param request the request
         * @return the request clean type
         */
        public static RequestCleanType fromRequestParameters(HttpServletRequest request) {
            return new RequestCleanType(
                    request.getParameter("clean_type_1"),
                    request.getParameter("clean_type_2"),
                    request.getParameter("clean_type_3"),
                    request.getParameter("clean_type_4"));
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
            int clean_type_try;
            String result = null;
            if (clean_type_1 != "") {
                try {
                    clean_type_try = Integer.parseInt(clean_type_1);
                    SQLConnect.changeDBValue("CleanTypes", "clean_type", "Генеральная", String.valueOf(clean_type_try));
                } catch (NumberFormatException e) {result = e.getMessage();}
            }
            if (clean_type_2 != "") {
                try {
                    clean_type_try = Integer.parseInt(clean_type_2);
                    SQLConnect.changeDBValue("CleanTypes", "clean_type", "Облегченная", String.valueOf(clean_type_try));
                } catch (NumberFormatException e) {result = e.getMessage();}
            }
            if (clean_type_3 != "") {
                try {
                    clean_type_try = Integer.parseInt(clean_type_3);
                    SQLConnect.changeDBValue("CleanTypes", "clean_type", "После ремонта", String.valueOf(clean_type_try));
                } catch (NumberFormatException e) {result = e.getMessage();}
            }
            if (clean_type_4 != "") {
                try {
                    clean_type_try = Integer.parseInt(clean_type_4);
                    SQLConnect.changeDBValue("CleanTypes", "clean_type", "Послестроительная", String.valueOf(clean_type_try));
                } catch (NumberFormatException e) {result = e.getMessage();}
            }
            request.setAttribute("result", result);
        }
    }
}
