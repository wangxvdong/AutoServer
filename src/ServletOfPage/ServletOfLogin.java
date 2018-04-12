package ServletOfPage;

import Bean.PageBean;
import BeanOfAuto.*;
import org.apache.catalina.Session;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

public class ServletOfLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /*System.out.println("session init ......#####");
        System.out.println(request.getSession().getAttribute("hello").toString());
*/

        request.setCharacterEncoding("UTF-8");
//#######################################################################Recharge Sevlet转发代码
        String condparam=request.getParameter("searchrechargesubmit");
        if(condparam!=null)
        if(condparam.equals("提交"))
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
                          //   response.sendRedirect("/AutoServer/recharge.jsp");
                            //  return;

                            request.getRequestDispatcher("/recharge.jsp").forward(request,response);
                           // return;

                        }
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }

        }
        //##############################
       /* System.out.println("one a again");
        System.out.println(request.getParameter("username"));
        System.out.println(request.getParameter("userpwd"));*/
        Staff s = AuthorityManager.verifyUser(request.getParameter("username"), request.getParameter("userpwd"));

        if (!s.name.isEmpty()) {
            PageBean pb = new PageBean();
            pb.setUsername_(s.name);
            /*Cookie cook=new Cookie("cooksecond","second cook");
            cook.setDomain("localhost");
            response.addCookie(cook);*/
            request.getSession().setAttribute("username_", pb);

            request.getSession().setAttribute("firuser","world");
            response.addCookie(new Cookie("fircook","firworld"));
            /*System.out.println("=======================================");
            System.out.println(s.name);
            System.out.println(s.picture);*/

            /*response.sendRedirect("/index.jsp");
            return;*/
            request.getSession().setAttribute("curemployee",s);
            RequestDispatcher rd= request.getRequestDispatcher("/index.jsp");
            rd.forward(request,response);
            // request.getSession().setAttribute("username",s.name);

        }

      /*  RequestDispatcher rd= request.getRequestDispatcher("/index.jsp");
        rd.forward(request,response);*/
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
