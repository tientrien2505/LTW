package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class header_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Header</title>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"header.css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <header id=\"header\">\n");
      out.write("            <div class =\"wrap\">\n");
      out.write("                <div id=\"logo\"></div>\n");
      out.write("\t\t<div id=\"profile\" class=\"text\">Sign In</div>\n");
      out.write("\t\t<div id=\"search_area\">\n");
      out.write("                    <input type=\"text\" name=\"text_search\" id=\"text_search\" placeholder=\"type content to search\" class=\"text\">\n");
      out.write("                    <button id=\"search\" class=\"text\">Search</button>\n");
      out.write("\t\t</div>\n");
      out.write("            </div>\n");
      out.write("        </header>\n");
      out.write("\t<div class=\"wrap\">\n");
      out.write("            <nav id=\"nav\" class=\"nav2\">\n");
      out.write("\t\t<ul>\n");
      out.write("                    <li title=\"Home\">\n");
      out.write("\t\t\t<a href=\"home.html\">HOME</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li title=\"study process\">\n");
      out.write("\t\t\t<a href=\"process.html\">Study Process</a>\n");
      out.write("\t\t\t<ul id=\"case_study\">\n");
      out.write("                            <li title=\"study C\"><a href=\"#\">STUDY C</a></li>\n");
      out.write("                            <li title=\"study java\"><a href=\"#\">STUDY JAVA</a></li>\n");
      out.write("                            <li title=\"study javascript\"><a href=\"#\">STUDY JAVASCRIPT</a></li>\n");
      out.write("\t\t\t</ul>\n");
      out.write("                    </li>\n");
      out.write("                    <li title=\"library\">\n");
      out.write("\t\t\t<a href=\"library.html\">Library</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li title=\"profile\">\n");
      out.write("\t\t\t<a href=\"profile.html\">Profile</a>\n");
      out.write("                    </li>\n");
      out.write("\t\t</ul>\n");
      out.write("            </nav>\n");
      out.write("\t</div>\n");
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
