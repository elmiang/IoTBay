package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class cart_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css\" integrity=\"sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk\" crossorigin=\"anonymous\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/IoTBay.css\">\r\n");
      out.write("        <title>Cart</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <div class=\"header-img\">\r\n");
      out.write("        <ul>\r\n");
      out.write("          <li><a href=\"index.jsp\"><img class=\"logo\" src=\"css/IoTBlogo3.png\"/></a></li>\r\n");
      out.write("          <li style=\"float:right; margin-right:10px;\"> <a class=\"button top-actions\"href=\"register.jsp\"> Register </a></li>\r\n");
      out.write("          <li style=\"float:right; margin-right:10px;\"><a class=\"button top-actions\" href=\"login.jsp\"> Login </a></li>\r\n");
      out.write("          <li style=\"float:right\" class=\"listImage\"><a href=\"cart.jsp\"><img class=\"logo\" src=\"css/cart.png\"/></a></li>\r\n");
      out.write("        </ul>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"topnav\">\r\n");
      out.write("            <a href=\"products.jsp\" style=\"float: left;\">All Products</a>\r\n");
      out.write("            <a style=\"float: left;\">Kits</a>\r\n");
      out.write("            <a style=\"float: left;\">Parts</a>\r\n");
      out.write("            <a style=\"float: left;\">Sensors</a>\r\n");
      out.write("            <a style=\"float: right;\">About</a>\r\n");
      out.write("            <a style=\"float: right;\">Contact</a>\r\n");
      out.write("        </div>\r\n");
      out.write("        \r\n");
      out.write("        ");

            String name = request.getParameter("name");
        
      out.write("\r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("        <main class=\"main-content\">\r\n");
      out.write("            <h2>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${user.name}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("'s Cart </h2>\r\n");
      out.write("            <table class=\"table\">\r\n");
      out.write("              <thead class=\"thead-dark\">\r\n");
      out.write("                <tr>\r\n");
      out.write("                  <th scope=\"col\"></th>\r\n");
      out.write("                  <th scope=\"col\">Item Picture</th>\r\n");
      out.write("                  <th scope=\"col\">Product Info</th>\r\n");
      out.write("                  <th scope=\"col\">Price</th>\r\n");
      out.write("                </tr>\r\n");
      out.write("              </thead>\r\n");
      out.write("              <tbody>\r\n");
      out.write("                <tr>\r\n");
      out.write("                  <th scope=\"row\"></th>\r\n");
      out.write("                  <td>Pic (change later)</td>\r\n");
      out.write("                  <td>Lorem Ipsum</td>\r\n");
      out.write("                  <td>$15.00</td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                  <th scope=\"row\"></th>\r\n");
      out.write("                  <td>Pic (change later)</td>\r\n");
      out.write("                  <td>Lorem Ipsum</td>\r\n");
      out.write("                  <td>$75.00</td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                  <th scope=\"row\"></th>\r\n");
      out.write("                  <td>Pic (change later)</td>\r\n");
      out.write("                  <td>Lorem Ipsum</td>\r\n");
      out.write("                  <td>$135.00</td>\r\n");
      out.write("                </tr>\r\n");
      out.write("              </tbody>\r\n");
      out.write("            </table>\r\n");
      out.write("            \r\n");
      out.write("            <table class=\"table\">\r\n");
      out.write("            <thead class=\"thead-dark\">\r\n");
      out.write("                <tr>\r\n");
      out.write("                  <th scope=\"col\"></th>\r\n");
      out.write("                  <th scope=\"col\">Order Summary</th>\r\n");
      out.write("                </tr>\r\n");
      out.write("            </thead>\r\n");
      out.write("            \r\n");
      out.write("            <tbody>\r\n");
      out.write("                <tr>\r\n");
      out.write("                  <th scope=\"row\"></th>\r\n");
      out.write("                  <td>Number of Items: (Amount of Items)</td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                  <th scope=\"row\"></th>\r\n");
      out.write("                  <td>Total: (Cost of Items)</td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                  <th scope=\"row\"></th>\r\n");
      out.write("                  <td>Shipping: (Cost of Shipping)</td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                \r\n");
      out.write("                <tr>\r\n");
      out.write("                  <th scope=\"row\"></th>\r\n");
      out.write("                  <td>Grand Total: (Grand Total)</td>\r\n");
      out.write("                </tr>\r\n");
      out.write("            </tbody>\r\n");
      out.write("            </table>\r\n");
      out.write("            \r\n");
      out.write("            <a class=\"button\" href=\"checkout.jsp\">Continue </a>\r\n");
      out.write("            \r\n");
      out.write("            \r\n");
      out.write("        </main>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
