package ServletOfPage;

import Bean.PageBean;
import BeanOfAuto.CustomerManager;
import BeanOfAuto.CustomerOfVip;
import BeanOfAuto.DBConnection;
import BeanOfAuto.Staff;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

public class ServletAtIndex extends HttpServlet  {

    public String username;
    public  void init() throws ServletException {
       // System.out.println("hello inti");
        username="登录";
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        System.out.println("index.jsp!!!!");
        if(request.getParameter("searchrechargesubmit").equals("提交"))
        {
            String vid= request.getParameter("searchboxrecharge");



            //#############################
            Staff security=(Staff) request.getSession().getAttribute("curemployee");
            if(security.authority<=2) {


       /* String s= request.getParameter("dsubmit").toString();
        if(s.equals("确认submit"))
        {
            request.getRequestDispatcher( "/ServletOfPage/ServletOfDeductVip" ).forward(request,   response);
        }*/
               /* if ((request.getSession().getAttribute("deductviphasruned").equals(true))) {
                    request.getRequestDispatcher("/ServletOfPage/ServletOfDeductVip").forward(request, response);
                    return;
                }*/
        /*
        else{*/
                // String prolist=request.getParameter("projecttypelist").toString();

                DBConnection con = new DBConnection();
                String url = "jdbc:mysql://bdm256530140.my3w.com:3306/bdm256530140_db";
                String user = "bdm256530140";
                String pwddb = "datapwd123";
                try {
                    con.ConnectDataBase(url, user, pwddb);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

                //  String ssssss= request.getParameter("pagemsg").toString();
                // if(request.getParameter("pagemsg").toString().equals("search")) {
               // String sb = request.getParameter("searchbox").toString();

                CustomerManager cm = new CustomerManager();
                cm.initDBConnect(con.GetDBConnection());
                try {
                    ArrayList al = cm.GetCustomerInfoS(vid); // 只取出单条客户记录,尽快改成多条可选择方式!!!
                    if (vid != null)
                        if (!vid.isEmpty()) {
                            CustomerOfVip cvp = ((CustomerOfVip) al.get(0));



                            request.getSession().setAttribute("searchviprecharge", al.get(0));
                            String path = request.getContextPath();
                            String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
                            // response.sendRedirect("/AutoServer/deductvip.jsp");
                            //  return;

                            request.getRequestDispatcher("/recharge.jsp").forward(request,response);

                        }
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }

        }
            //##############################





//            request.getRequestDispatcher("/AutoServer/ServletOfPage/ServletOfSearchRecharge").forward(request,response);

        }

      /*  response.sendRedirect("/ServletOfLogin.java");
        return ;*/

/*

       if(request.getSession().getAttribute("username")==null) {
           response.sendRedirect("login.jsp");
           return;
       }
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
*/



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
