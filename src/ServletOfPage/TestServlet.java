package ServletOfPage;

import BeanOfAuto.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

public class TestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



       /* String s= request.getParameter("dsubmit").toString();
        if(s.equals("确认submit"))
        {
            request.getRequestDispatcher( "/ServletOfPage/ServletOfDeductVip" ).forward(request,   response);
        }*/
      /*  if((request.getSession().getAttribute("isfirstrunofsearchvip").toString().equals("true"))) {
            request.getSession().setAttribute("isfirstrunofsearchvip", "false");
        }
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

        String ssssss= request.getParameter("pagemsg").toString();
      if(request.getParameter("pagemsg").toString().equals("search")) {
          String sb = request.getParameter("searchbox").toString();

          CustomerManager cm = new CustomerManager();
          cm.initDBConnect(con.GetDBConnection());
          try {
              ArrayList al = cm.GetCustomerInfoS(sb); // 只取出单条客户记录,尽快改成多条可选择方式!!!
              if (sb != null)
                  if (!sb.isEmpty()) {
                      CustomerOfVip cvp=( (CustomerOfVip)al.get(0));
                     // request.setAttribute("xcnum",cvp.p1num);
                      request.getSession().setAttribute("projectnum",cvp);
                    //  request.setAttribute("qunum",cvp.p3num);


                      request.getSession().setAttribute("searchvip", al.get(0));
                      String path = request.getContextPath();
                      String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
                      //response.sendRedirect(basePath+"deductvip.jsp");
                 // request.getRequestDispatcher( basePath+"searchvip.jsp" ).forward(request,   response);
                 /*      response.sendRedirect("/searchvip.jsp");
                        return;*/
                      // 之前的跳转到deductvip.jsp的代码 上面



                  }
          } catch (SQLException e) {
              e.printStackTrace();
          }
      }
      else if (request.getParameter("pagemsg").toString().equals("searchd"))
      {
          CustomerOfVip cp = ((CustomerOfVip) request.getSession().getAttribute("searchvip"));
          String pt = request.getParameter("projecttype").toString();
          String pc = request.getParameter("projectcount").toString();
          ConsumpManager cmr = new ConsumpManager();
                    /*DBConnection con=new DBConnection();
                    String url="jdbc:mysql://bdm256530140.my3w.com:3306/bdm256530140_db";
                    String user="bdm256530140";
                    String pwddb="datapwd123";
                    try {
                        con.ConnectDataBase(url,user,pwddb);
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
*/
          cmr.initDBConnect(con.GetDBConnection());
          try {
              switch (pt) {
                  case "洗车":
                      cmr.deduct(cp.id, "p1", pc);
                      break;
                  case "打蜡":
                      cmr.deduct(cp.id, "p2", pc);
                      break;
                  case "去污":
                      cmr.deduct(cp.id, "p3", pc);
                      break;
              }

          } catch (SQLException e) {
              e.printStackTrace();
          }


      }

       // }
        /*

        String url="jdbc:mysql://bdm256530140.my3w.com:3306/bdm256530140_db";
		String user="bdm256530140";
		String pwd="datapwd123";

         */
       /* String url="jdbc:mysql://localhost:3306/automobileservice";
        String user="root";
        String pwd="123456";

        ConnectionManager cm=new ConnectionManager();
        try {
            cm.ConnectDataBase(url,user,pwd);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        EmployeeManager em=new EmployeeManager();
        em.initDBConnect(cm.GetDBConnection());
        CustomerManager cusm=new CustomerManager();
        cusm.initDBConnect(cm.GetDBConnection());
        RecordConsumption rc=new RecordConsumption();
        rc.initDBConnect(cm.GetDBConnection());

        try {
            try {
                rc.addRecordConsumption("1","2",50,45,5,"2018-3-27");
                cusm.insertnewcustomer("独一无二1","于Basdfj","123423432","ford","2018-1-3","true");
                cusm.insertnewvip("2018-1-4","@","100","2","0");
            } catch (Exception e) {
                e.printStackTrace();
            }
           // em.deleteEmployee(2);
          //  em.updateEmployee("3","name","黑类类");
            em.addEmployee("开始","123","943706331","F：/贺龙咯.jpg",2500,2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            em.closeStatment();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        cm.closeDBConnection();
        PrintWriter pw=response.getWriter();
        pw.println("hwllwo world");
        */
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
