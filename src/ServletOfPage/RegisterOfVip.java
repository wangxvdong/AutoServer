package ServletOfPage;

import BeanOfAuto.ConnectionManager;
import BeanOfAuto.CustomerManager;
import BeanOfAuto.DBConnection;
import BeanOfAuto.Staff;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class RegisterOfVip extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Staff security=(Staff) request.getSession().getAttribute("curemployee");
        if(security.authority<=2) {
            String url = "jdbc:mysql://bdm256530140.my3w.com:3306/bdm256530140_db";
            String user = "bdm256530140";
            String pwddb = "datapwd123";

/*
       String url="jdbc:mysql://localhost:3306/automobileservice";
        String user="root";
        String pwddb="123456";
*/
            //ConnectionManager cm=new ConnectionManager();
            DBConnection con = new DBConnection();
            CustomerManager cusm = new CustomerManager();


            try {
                con.ConnectDataBase(url, user, pwddb);
                cusm.initDBConnect(con.GetDBConnection());
                //   String nowdate=new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());

                try {
              /*  String tname=( request.getParameter("name") );
                String plate=request.getParameter("plate");
                String contact=request.getParameter("contact");
                String cartype=request.getParameter("cartype");
                String regtime=request.getParameter("regtime");
                cusm.insertnewcustomer(tname, plate, contact, cartype,regtime,"1");*/


                    // con.insertnewcustomer(tname, plate, contact, cartype, regtime,isvip);
                    //  Date c=Calendar.getInstance().getTime();
                    //  c.setYear(10);
                    //  out.println(c.toString()+"&&&&&&&&&&&");
                    //  con.insertnewvip(regtime,"00",request.getParameter("total"),request.getParameter("used"),"0");

                    String tname = (request.getParameter("name"));
                    String plate = request.getParameter("plate");
                    String contact = request.getParameter("contact");
                    String cartype = request.getParameter("cartype");
                    String regtime = request.getParameter("regtime");

                    //Date c=Calendar.getInstance().getTime();
                    //c.setYear(10);
                    String nowdate = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
                    String s = new String("h");
                    if (tname != null) {
                        if (!tname.isEmpty()) {
                            //con.insertnewcustomer(tname, plate, contact, cartype,regtime);


                            String lt = request.getParameter("limittype");

                            if (lt != null)
                                if (!lt.isEmpty()) {
                                    String isvip = new String("1");
                                    cusm.insertnewcustomer(tname, plate, contact, cartype, regtime, isvip);
                                    if (lt.equals("number")) {
//	con.insertnewvip(nowtime, )


                                        Date c = Calendar.getInstance().getTime();
                                        c.setYear(10);

                                        cusm.insertnewvip(regtime, "00", request.getParameter("total"), request.getParameter("used"), "0");
                                    } else if (lt.equals("time")) {

                                        isvip = new String("2");

                                        cusm.insertnewvip_time(regtime, "00", request.getParameter("begintime"), request.getParameter("endtime"));
                                    } else {

                                        isvip = new String("0");
                                        cusm.insertnewcustomer(tname, plate, contact, cartype, regtime, isvip);
                                    }


                                }
                        }
                    }


                } catch (Exception e) {
                    e.printStackTrace();
                }
//            ResultSet result = stmt.executeQuery("select * from employee where name='"+name+"'");
//            result.first();
                //System.out.println("@@@@@"+ result.getString("name"));
                // System.out.println("@@@@@"+ result.getString("picture"));


               /* Staff s = new Staff();
                s.id = result.getInt("eid");
                System.out.println("one a again ######");

                s.name = result.getString("name");
                s.authority = result.getInt("authority");
                s.picture = result.getString("picture");*/

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
