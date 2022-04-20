/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.8
 * Generated at: 2022-04-19 18:46:11 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("<html lang=\"ru\">\n");
      out.write("<head>\n");
      out.write("\t\t<meta charset=\"utf-8\">\n");
      out.write("\t\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("\t\t<title>Калькулятор</title>\n");
      out.write("\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"css/style1.css\">\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\t\t<div class=\"container\">\n");
      out.write("\t\t\t<header class=\"header\">\n");
      out.write("\t\t\t\t<div class=\"contain\">\n");
      out.write("\t\t\t\t\t<div class=\"header_body\">\n");
      out.write("\t\t\t\t\t\t<a href=\"#\" class=\"header_logo\">\n");
      out.write("\t\t\t\t\t\t\t<img src=\"img/logof.png\" alt=\"\">\n");
      out.write("\t\t\t\t\t\t</a>\n");
      out.write("\t\t\t\t\t\t<div class=\"header_burger\">\n");
      out.write("\t\t\t\t\t\t\t<span></span>\n");
      out.write("\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t<nav class=\"header-menu\">\n");
      out.write("\t\t\t\t\t\t\t<ul class=\"header-list\">\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href=\"authorization.jsp\" class=\"header_link\">Панель админа</a></li>\n");
      out.write("\t\t\t\t\t\t\t\t<li><a href=\"about.jsp\" class=\"header_link\">О нас</a></li>\n");
      out.write("\t\t\t\t\t\t\t</ul>\n");
      out.write("\t\t\t\t\t\t</nav>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</header>\n");
      out.write("\n");
      out.write("\t\t    <div class=\"title\">Калькулятор клининговых услуг</div>\n");
      out.write("\n");
      out.write("\t\t    <form action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/Calc\" method=\"post\">\n");
      out.write("\t\t\t    <div class=\"user-details\">\n");
      out.write("\t\t\t\t    <div class=\"input-box\">\n");
      out.write("\t\t\t\t\t    <span class=\"details\">Фамилия</span>\n");
      out.write("\t\t\t\t\t    <input type=\"text\" placeholder=\"Ваша фамилия\" required name=\"surname\" id=\"surname\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${surname}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("\t\t\t\t    </div>\n");
      out.write("\t\t\t\t    <div class=\"input-box\">\n");
      out.write("\t\t\t\t\t    <span class=\"details\">Имя</span>\n");
      out.write("\t\t\t\t\t    <input type=\"text\" placeholder=\"Ваше имя\" required name=\"name\" id=\"name\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("\t\t\t\t    </div>\n");
      out.write("\t\t\t\t    <div class=\"input-box\">\n");
      out.write("\t\t\t\t\t    <span class=\"details\">Отчество</span>\n");
      out.write("\t\t\t\t\t    <input type=\"text\" placeholder=\"Отчество\" required name=\"patronymic\" id=\"patronymic\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${patronymic}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("\t\t\t\t    </div>\n");
      out.write("\t\t\t\t    <div class=\"input-box\">\n");
      out.write("\t\t\t\t\t    <span class=\"details\">Адрес</span>\n");
      out.write("\t\t\t\t\t    <input type=\"text\" placeholder=\"Адрес\" required name=\"address\" id=\"address\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${address}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("\t\t\t\t    </div>\n");
      out.write("\t\t\t\t    <div class=\"input-box\">\n");
      out.write("\t\t\t\t\t    <span class=\"details\">Дата и время</span>\n");
      out.write("\t\t\t\t\t    <input type=\"datetime-local\" name=\"date_time\" id=\"date_time\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${date_time}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("\t\t\t\t    </div>\n");
      out.write("\t\t\t\t    <div class=\"input-box\">\n");
      out.write("                        <span class=\"details\">Площадь помещения</span>\n");
      out.write("                    \t<input type=\"text\" name=\"clean_area\" id=\"clean_area\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${clean_area}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("                    </div>\n");
      out.write("\t\t\t    </div>\n");
      out.write("\n");
      out.write("\t\t\t    <div class=\"clean-details\">\n");
      out.write("\t\t\t\t    <input type=\"radio\" name=\"clean_type\" id=\"dot-1\" value=\"Генеральная\">\n");
      out.write("\t\t\t\t    <input type=\"radio\" name=\"clean_type\" id=\"dot-2\" value=\"Облегченная\">\n");
      out.write("\t\t    \t\t<input type=\"radio\" name=\"clean_type\" id=\"dot-3\" value=\"После ремонта\">\n");
      out.write("\t\t    \t\t<input type=\"radio\" name=\"clean_type\" id=\"dot-4\" value=\"Послестроительная\">\n");
      out.write("\t\t\t    \t<input type=\"radio\" name=\"clean2\" id=\"m-1\">\n");
      out.write("\t\t\t\t    <input type=\"radio\" name=\"clean2\" id=\"m-2\">\n");
      out.write("    \t\t\t\t<input type=\"radio\" name=\"clean2\" id=\"m-3\">\n");
      out.write("\t    \t\t\t<input type=\"radio\" name=\"clean2\" id=\"m-4\">\n");
      out.write("\t\t    \t\t<input type=\"checkbox\" name=\"clean_service_1\" id=\"dop-3\" value=\"Полировка полов\">\n");
      out.write("\t\t\t    \t<input type=\"checkbox\" name=\"clean_service_2\" id=\"dop-4\" value=\"Мытье посуды\">\n");
      out.write("\t\t\t\t    <input type=\"checkbox\" name=\"clean_service_3\" id=\"dop-5\" value=\"Стирка+глажка\">\n");
      out.write("    \t\t\t\t<input type=\"checkbox\" name=\"clean_service_4\" id=\"dop-6\" value=\"Мытье окон\">\n");
      out.write("\t    \t\t\t<input type=\"checkbox\" name=\"clean_service_5\" id=\"dop-7\" value=\"Уборка стен\">\n");
      out.write("\t\t    \t\t<input type=\"checkbox\" name=\"clean_service_6\" id=\"dop-8\" value=\"Чистка унитаза\">\n");
      out.write("\t\t\t    \t<input type=\"checkbox\" name=\"clean_service_7\" id=\"dop-9\" value=\"Чистка раковин\">\n");
      out.write("\t\t\t\t    <input type=\"checkbox\" name=\"clean_service_8\" id=\"dop-10\" value=\"Уборка балкона\">\n");
      out.write("\n");
      out.write("\t\t\t\t    <span class=\"clean-title\">Вид уборки</span>\n");
      out.write("\t\t\t\t    <div class=\"category\">\n");
      out.write("\t\t\t\t\t    <label for=\"dot-1\">\n");
      out.write("\t\t\t\t\t\t    <span class=\"dot one\"></span>\n");
      out.write("\t\t\t\t\t\t    <span class=\"clean_type\">Генеральная</span>\n");
      out.write("\t\t\t\t\t    </label>\n");
      out.write("\t\t\t\t\t    <label for=\"dot-2\">\n");
      out.write("\t\t\t\t\t\t    <span class=\"dot two\"></span>\n");
      out.write("\t\t\t\t\t\t    <span class=\"clean_type\">Облегченная</span>\n");
      out.write("\t\t\t\t\t    </label>\n");
      out.write("\t\t\t\t\t    <label for=\"dot-3\">\n");
      out.write("\t\t\t\t\t\t    <span class=\"dot three\"></span>\n");
      out.write("    \t\t\t\t\t\t<span class=\"clean_type\">После ремонта</span>\n");
      out.write("\t    \t\t\t\t</label>\n");
      out.write("\t\t    \t\t\t<label for=\"dot-4\">\n");
      out.write("\t\t\t    \t\t\t<span class=\"dot four\"></span>\n");
      out.write("\t\t\t\t    \t\t<span class=\"clean_type\">Послестроительная</span>\n");
      out.write("\t\t\t\t\t    </label>\n");
      out.write("    \t\t\t\t</div>\n");
      out.write("\n");
      out.write("\t\t\t\t    <span class=\"clean-title\">Дополнительные услуги</span>\n");
      out.write("    \t\t\t\t<div class=\"category\">\n");
      out.write("\t    \t\t\t\t<label for=\"dop-3\">\n");
      out.write("\t\t    \t\t\t\t<span class=\"dop q\"></span>\n");
      out.write("\t\t\t    \t\t\t<span class=\"clean_service_1\">Полировка полов</span>\n");
      out.write("\t\t\t\t    \t</label>\n");
      out.write("\t\t\t\t\t    <label for=\"dop-4\">\n");
      out.write("    \t\t\t\t\t\t<span class=\"dop w\"></span>\n");
      out.write("\t    \t\t\t\t\t<span class=\"clean_service_2\">Мытье посуды</span>\n");
      out.write("\t\t    \t\t\t</label>\n");
      out.write("\t\t\t    \t\t<label for=\"dop-5\">\n");
      out.write("\t\t\t\t    \t\t<span class=\"dop r\"></span>\n");
      out.write("\t\t\t\t\t    \t<span class=\"clean_service_3\">Стирка+глажка</span>\n");
      out.write("\t\t\t\t\t    </label>\n");
      out.write("    \t\t\t\t\t<label for=\"dop-6\">\n");
      out.write("\t    \t\t\t\t\t<span class=\"dop t\"></span>\n");
      out.write("\t\t    \t\t\t\t<span class=\"clean_service_4\">Мытье окон</span>\n");
      out.write("\t\t\t    \t\t</label>\n");
      out.write("\t\t\t\t    </div>\n");
      out.write("\n");
      out.write("    \t\t\t\t<div class=\"category\">\n");
      out.write("\t    \t\t\t\t<label for=\"dop-7\">\n");
      out.write("\t\t    \t\t\t\t<span class=\"dop y\"></span>\n");
      out.write("\t\t\t    \t\t\t<span class=\"clean_service_5\">Уборка стен</span>\n");
      out.write("\t\t\t\t    \t</label>\n");
      out.write("\t\t\t\t\t    <label for=\"dop-8\">\n");
      out.write("    \t\t\t\t\t\t<span class=\"dop u\"></span>\n");
      out.write("\t    \t\t\t\t\t<span class=\"clean_service_6\">Чистка унитаза</span>\n");
      out.write("\t\t    \t\t\t</label>\n");
      out.write("\t\t\t    \t\t<label for=\"dop-9\">\n");
      out.write("\t\t\t\t    \t\t<span class=\"dop i\"></span>\n");
      out.write("\t\t\t\t\t    \t<span class=\"clean_service_7\">Чистка раковин</span>\n");
      out.write("    \t\t\t\t\t</label>\n");
      out.write("\t    \t\t\t\t<label for=\"dop-10\">\n");
      out.write("\t\t    \t\t\t\t<span class=\"dop o\"></span>\n");
      out.write("\t\t\t    \t\t\t<span class=\"clean_service_8\">Уборка балкона</span>\n");
      out.write("\t\t\t\t    \t</label>\n");
      out.write("\t\t\t\t    </div>\n");
      out.write("    \t\t\t</div>\n");
      out.write("\n");
      out.write("    \t\t\t<div class=\"price\">\n");
      out.write("        \t\t\t<div class=\"button\">\n");
      out.write("\t\t    \t\t    <input type=\"submit\" value=\"Заказать\">\n");
      out.write("\t\t\t        </div>\n");
      out.write("\t\t    </form>\n");
      out.write("\n");
      out.write("\t\t    <form action=\"promo\">\n");
      out.write("\t\t\t    <div class=\"output-box\">\n");
      out.write("\t\t\t\t\t<span class=\"price-details\">У вас есть промокод? </span>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t    </div>\n");
      out.write("\t\t\t    <div class=\"promo-d\">\n");
      out.write("\t\t            <div class=\"input-box\">\n");
      out.write("\t\t\t\t\t    <input type=\"text\" placeholder=\"Промокод\" required>\n");
      out.write("\t\t\t\t    </div>\n");
      out.write("\t            </div>\n");
      out.write("\t            <div class=\"input-box\">\n");
      out.write("\t\t\t\t    <button class=\"but-det\">Применить</button>\n");
      out.write("\t\t\t    </div>\n");
      out.write("\t        </form>\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
