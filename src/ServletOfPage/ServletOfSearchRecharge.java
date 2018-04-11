package ServletOfPage;

import BeanOfAuto.CustomerManager;
import BeanOfAuto.CustomerOfVip;
import BeanOfAuto.DBConnection;
import BeanOfAuto.Staff;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class ServletOfSearchRecharge extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Staff security=(Staff) request.getSession().getAttribute("curemployee");
        if(security.authority<=2) {


       /* String s= request.getParameter("dsubmit").toString();
        if(s.equals("确认submit"))
        {
            request.getRequestDispatcher( "/ServletOfPage/ServletOfDeductVip" ).forward(request,   response);
        }*/
          /*  if ((request.getSession().getAttribute("deductviphasruned").equals(true))) {
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
            String sb = request.getParameter("searchbox").toString();

            CustomerManager cm = new CustomerManager();
            cm.initDBConnect(con.GetDBConnection());
            try {
                ArrayList al = cm.GetCustomerInfoS(sb); // 只取出单条客户记录,尽快改成多条可选择方式!!!
                if (sb != null)
                    if (!sb.isEmpty()) {
                        CustomerOfVip cvp = ((CustomerOfVip) al.get(0));
                        // request.setAttribute("xcnum",cvp.p1num);
                       // request.getSession().setAttribute("projectnum", cvp);
                        //  request.setAttribute("qunum",cvp.p3num);


                        request.getSession().setAttribute("searchvip", al.get(0));
                        String path = request.getContextPath();
                        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
                        // response.sendRedirect("/AutoServer/deductvip.jsp");
                        //  return;
                        request.getRequestDispatcher("/AutoServer/recharge.jsp").forward(request, response);
                 /*      response.sendRedirect("/searchvip.jsp");
                        return;*/
                        // 之前的跳转到deductvip.jsp的代码 上面


                    }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
