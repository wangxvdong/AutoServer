package ServletOfPage;

import Bean.PageBean;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ServletAtIndex extends HttpServlet  {

    public String username;
    public  void init() throws ServletException {
        System.out.println("hello inti");
        username="登录";
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {




       if(request.getSession().getAttribute("username")==null)
           response.sendRedirect("login.jsp");
        else {
          //  this.username = request.getSession().getAttribute("username").toString();
          // PageBean pb=new PageBean();

         //  request.getSession().setAttribute("username_",pb);
            PrintWriter pw = response.getWriter();
            pw.println("hello jquery" + request.getSession().getAttribute("hello"));
            pw.close();
            System.out.println("heleo world dopost" + request.getSession().getAttribute("hello"));
        }
        System.out.println("index end");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
