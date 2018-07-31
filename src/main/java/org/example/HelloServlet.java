
package org.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet
{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().println("<h1>Hello Servlet</h1>");
        response.getWriter().println("session=" + request.getSession(true).getId());

        File file = new File(System.getProperty("platform-config"));

        Properties prop = new Properties();
        prop.load(new FileInputStream(file));
        response.getWriter().println("<div>");
        response.getWriter().println("platform-config=" + file.getAbsolutePath());
        response.getWriter().println("</div>");
        response.getWriter().println("<div>");
        response.getWriter().println("tst=" + prop.getProperty("tst"));
        response.getWriter().println("</div>");
    }
}