package ServletOfPage;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ServletAtIndex extends HttpServlet  {

    public  void init() throws ServletException {
        System.out.println("hello inti");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

          PrintWriter pw= response.getWriter();
          pw.println("hello jquery"+request.getSession().getAttribute("hello"));
           pw.close();
           System.out.println("heleo world dopost"+request.getSession().getAttribute("hello"));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
