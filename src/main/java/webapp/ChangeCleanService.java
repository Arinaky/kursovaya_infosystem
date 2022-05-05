package webapp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// TODO: Auto-generated Javadoc
/**
 * The Class ChangeCleanService.
 * @author Shimanov K.A.
 */
@WebServlet(name="ChangeCleanService", urlPatterns="/ChangeCleanService")
public class ChangeCleanService extends HttpServlet {
        
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
        RequestCleanService CleanService = RequestCleanService.fromRequestParameters(request);
        CleanService.setAsRequestAttributesAndCalculate(request, response);
        request.getRequestDispatcher("/admin.jsp").forward(request, response);
    }

    /**
     * The Class RequestCleanService.
     */
    private static class RequestCleanService {
        
        /** The clean service 1. */
        private String clean_service_1;
        
        /** The clean service 2. */
        private String clean_service_2;
        
        /** The clean service 3. */
        private String clean_service_3;
        
        /** The clean service 4. */
        private String clean_service_4;
        
        /** The clean service 5. */
        private String clean_service_5;
        
        /** The clean service 6. */
        private String clean_service_6;
        
        /** The clean service 7. */
        private String clean_service_7;
        
        /** The clean service 8. */
        private String clean_service_8;

        /**
         * Instantiates a new request clean service.
         *
         * @param clean_service_1 the clean service 1
         * @param clean_service_2 the clean service 2
         * @param clean_service_3 the clean service 3
         * @param clean_service_4 the clean service 4
         * @param clean_service_5 the clean service 5
         * @param clean_service_6 the clean service 6
         * @param clean_service_7 the clean service 7
         * @param clean_service_8 the clean service 8
         */
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

        /**
         * From request parameters.
         *
         * @param request the request
         * @return the request clean service
         */
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
            if (clean_service_1 != "") {
                try {
                    clean_type_try = Integer.parseInt(clean_service_1);
                    SQLConnect.changeDBValue("CleanServices", "clean_service", "Полировка полов", String.valueOf(clean_type_try));
                } catch (NumberFormatException e) {result = e.getMessage();}
            }
            if (clean_service_2 != "") {
                try {
                    clean_type_try = Integer.parseInt(clean_service_2);
                    SQLConnect.changeDBValue("CleanServices", "clean_service", "Мытье посуды", String.valueOf(clean_type_try));
                } catch (NumberFormatException e) {result = e.getMessage();}
            }
            if (clean_service_3 != "") {
                try {
                    clean_type_try = Integer.parseInt(clean_service_3);
                    SQLConnect.changeDBValue("CleanServices", "clean_service", "Стирка+глажка", String.valueOf(clean_type_try));
                } catch (NumberFormatException e) {result = e.getMessage();}
            }
            if (clean_service_4 != "") {
                try {
                    clean_type_try = Integer.parseInt(clean_service_4);
                    SQLConnect.changeDBValue("CleanServices", "clean_service", "Мытье окон", String.valueOf(clean_type_try));
                } catch (NumberFormatException e) {result = e.getMessage();}
            }
            if (clean_service_5 != "") {
                try {
                    clean_type_try = Integer.parseInt(clean_service_5);
                    SQLConnect.changeDBValue("CleanServices", "clean_service", "Уборка стен", String.valueOf(clean_type_try));
                } catch (NumberFormatException e) {result = e.getMessage();}
            }
            if (clean_service_6 != "") {
                try {
                    clean_type_try = Integer.parseInt(clean_service_6);
                    SQLConnect.changeDBValue("CleanServices", "clean_service", "Чистка унитаза", String.valueOf(clean_type_try));
                } catch (NumberFormatException e) {result = e.getMessage();}
            }
            if (clean_service_7 != "") {
                try {
                    clean_type_try = Integer.parseInt(clean_service_7);
                    SQLConnect.changeDBValue("CleanServices", "clean_service", "Чистка раковин", String.valueOf(clean_type_try));
                } catch (NumberFormatException e) {result = e.getMessage();}
            }
            if (clean_service_8 != "") {
                try {
                    clean_type_try = Integer.parseInt(clean_service_8);
                    SQLConnect.changeDBValue("CleanServices", "clean_service", "Уборка балкона", String.valueOf(clean_type_try));
                } catch (NumberFormatException e) {result = e.getMessage();}
            }
            request.setAttribute("result", result);
        }
    }
}
