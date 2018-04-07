package BeanOfAuto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private  Connection con;
    public Connection ConnectDataBase(String durl, String account, String pwd) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException
    {
		try {
	            Class.forName("com.mysql.jdbc.Driver");
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	            System.out.println("找不到驱动 ");
	        }

	        //"jdbc:mysql://bdm256530140.my3w.com:3306/bdm256530140_db";
        con= DriverManager.getConnection(durl,account,pwd/*"bdm256530140","datapwd123"*/);

        return con;
    }

    public Connection GetDBConnection()
    {
        return con;
    }
    public Connection GetConnectLeval0()
    {
        return con;
    }
    public Connection GetConnectLeval1()
    {
        return con;
    }
    public Connection GetConnectLeval2()
    {
        return con;
    }
}
