package ServletOfPage;

import Bean.PageBean;
import BeanOfAuto.AuthorityManager;
import BeanOfAuto.Staff;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

public class ServletOfLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {





        request.setCharacterEncoding("UTF-8");
        System.out.println("one a again");
        System.out.println(request.getParameter("username"));
        System.out.println(request.getParameter("userpwd"));
        Staff s=  AuthorityManager.verifyUser(request.getParameter("username"),request.getParameter("userpwd"));
         if(!s.name.isEmpty())
         {
             PageBean pb=new PageBean();
             pb.setUsername_("kaishi le");
             request.getSession().setAttribute("username_",pb);
             System.out.println("=======================================");
             System.out.println(s.name);
             System.out.println(s.picture);



            // request.getSession().setAttribute("username",s.name);

         }
        response.sendRedirect("/index.jsp");
        //RequestDispatcher rd= request.getRequestDispatcher("/index.jsp");
          //      rd.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
