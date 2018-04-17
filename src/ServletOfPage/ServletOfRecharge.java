package ServletOfPage;

import BeanOfAuto.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import BeanOfAuto.RecordConsump;

public class ServletOfRecharge extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Staff security=(Staff) request.getSession().getAttribute("curemployee");
        if(security.authority<=2) {
            System.out.println("current point is ServletOFreCharge.java");
            String path = request.getContextPath();
            String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
            CustomerOfVip cp = ((CustomerOfVip) request.getSession().getAttribute("searchboxrecharge"));
            String pt = request.getParameter("projecttype").toString();
            String pc = request.getParameter("projectcount").toString();
            ConsumpManager cm = new ConsumpManager();
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

            cm.initDBConnect(con.GetDBConnection());
            RecordConsumption rcmpn = new RecordConsumption();
            rcmpn.initDBConnect(con.GetDBConnection());
            CustomerOfVip vp = (CustomerOfVip) request.getSession().getAttribute("searchboxrecharge");
            int pcount = Integer.valueOf(request.getParameter("projectcount"));
            float payable = Float.valueOf(request.getParameter("payable"));
            float pocket = Float.valueOf(request.getParameter("pocket"));
            String nowdate = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
            try {
                switch (pt) {
                    case "洗车":
                        cm.recharge(cp.id, "p1", pc);


                        rcmpn.addRecordConsumption(String.valueOf( vp.vid), String.valueOf(1), pcount, payable, pocket, payable - pocket, nowdate);

                        break;
                    case "打蜡":
                        cm.recharge(cp.id, "p2", pc);


                        rcmpn.addRecordConsumption(String.valueOf( vp.vid), String.valueOf(2), pcount, payable, pocket, payable - pocket, nowdate);

                        break;
                    case "去污":
                        cm.recharge(cp.id, "p3", pc);
                        rcmpn.addRecordConsumption(String.valueOf( vp.vid), String.valueOf(3), pcount, payable, pocket, payable - pocket, nowdate);
                        break;
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }


            CustomerManager cmr = new CustomerManager();
            cmr.initDBConnect(con.GetDBConnection());
            try {
                ArrayList al = cmr.GetCustomerInfoS(cp.id); // 只取出单条客户记录,尽快改成多条可选择方式!!!
                if (cp != null)
                    if (!cp.id.isEmpty()) {
                        CustomerOfVip cvp = ((CustomerOfVip) al.get(0));
                        // request.setAttribute("xcnum",cvp.p1num);
                        //  request.getSession().setAttribute("projectnum", cvp);
                        //  request.setAttribute("qunum",cvp.p3num);


                        request.getSession().setAttribute("searchboxrecharge", al.get(0));
                        request.getRequestDispatcher("/recharge.jsp").forward(request, response);
                    }
            } catch (SQLException e) {
                e.printStackTrace();
            }



            /*response.sendRedirect("/recharge.jsp");
           return;*/
        }
        }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
