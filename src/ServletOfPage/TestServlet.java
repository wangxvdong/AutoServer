package ServletOfPage;

import BeanOfAuto.ConnectionManager;
import BeanOfAuto.CustomerManager;
import BeanOfAuto.EmployeeManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class TestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ConnectionManager cm=new ConnectionManager();
        try {
            cm.ConnectDataBase("","","");
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

        try {
            try {
                cusm.insertnewcustomer("独一无二1","于Basdfj","123423432","ford","2018-1-3","true");
                cusm.insertnewvip("2018-1-4","@","100","2","0");
            } catch (Exception e) {
                e.printStackTrace();
            }
            em.deleteEmployee(2);
            em.updateEmployee("3","name","黑类类");
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
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
