package BeanOfAuto;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;



public class ConnectionManager {


	private Connection con;
	
	public ConnectionManager()
	{}
	
	public Connection ConnectDataBase(String url,String user,String pwd) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException
	{
		/* try {
	            Class.forName("com.mysql.jdbc.Driver");
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	            System.out.println("�Ҳ������� ");
	        }*/
		/*Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://bdm256530140.my3w.com:3306/bdm256530140_db";
		con=DriverManager.getConnection(url,"bdm256530140","datapwd123");
*/
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
		//	pw.println("Class fro mnam e Driver Error");
			e.printStackTrace();
		}


		try {
			this.con=DriverManager.getConnection(url,user,pwd);
		} catch (SQLException e) {
			//pw.println("hell Driver mana ger error connect is error");
			e.printStackTrace();
		}

		
		return con;
	}
	
	public Connection GetDBConnection()
	{
		return con;
	}

	public void closeDBConnection(){
		try {
			if(!this.con.isClosed())
                this.con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
