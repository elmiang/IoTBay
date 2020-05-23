package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class store_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/IoTBay.css\">\n");
      out.write("        <title>Store</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"header-img\">\n");
      out.write("        <ul>\n");
      out.write("          <li><a href=\"index.jsp\"><img class=\"logo\" src=\"css/IoTBlogo3.png\"/></a></li>\n");
      out.write("          <li style=\"float:right; margin-right:10px;\"> <a class=\"button top-actions\"href=\"logout.jsp\"> Logout </a></li>\n");
      out.write("        </ul>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        <div class=\"topnav\">\n");
      out.write("             <a href=\"index.jsp\"style=\"float: left;\">Home</a>\n");
      out.write("            <a style=\"float: left;\">All Products</a>\n");
      out.write("            <a style=\"float: left;\">Kits</a>\n");
      out.write("            <a style=\"float: left;\">Parts</a>\n");
      out.write("            <a style=\"float: left;\">Sensors</a>\n");
      out.write("            <a style=\"float: right;\">About</a>\n");
      out.write("            <a style=\"float: right;\">Contact</a>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        <main class=\"main-content\">\n");
      out.write("            <h1 align=\"left\">Products</h1>\n");
      out.write("            \n");
      out.write("        </main>\n");
      out.write("        \n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
