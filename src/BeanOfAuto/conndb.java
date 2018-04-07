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


public class conndb {

	

private String name;
private int num;
private Connection conn;
private Statement stmt;
private ResultSet rsm;
private String fname;
private String fnumber;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getNum() {
	return num;
}
public void setNum(int num) {
	this.num = num;
}

public conndb() throws Exception
{
	
	
	
	Class.forName("com.mysql.jdbc.Driver");
	String url="jdbc:mysql://localhost:3306/automobileservice";
	String username="root";
	String passwd="123456";
	Connection con=DriverManager.getConnection(url,username,passwd);
	
	 stmt= con.createStatement();
	 rsm=stmt.executeQuery("select * from test");
	 
	 rsm.first();
	 
	/*
	rs.first();
	System.out.println(rs.getString(1)+rs.getString(2));
	rs.next();
	System.out.println(rs.getString(1)+rs.getString(2));
	*/
	
	
	/*
	Class.forName("com.mysql.jdbc.Driver");
 	this.conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/automobileservice","root","123456");
 	this.stmt=conn.createStatement();
 	 rsm=stmt.executeQuery("select * from test");
 	*/
	
}
public String getFname() throws Exception {
	fname=rsm.getString(1);
	return fname;
}
public void setFname(String fname) {
	this.fname = fname;
}
public String getFnumber() throws Exception {
	fnumber=rsm.getString(2);
	return fnumber;
}
public void setFnumber(String fnumber) {
	this.fnumber = fnumber;
}

public void insertnewcustomer(String name,String plate,String contact,String cartype,String regtime,String isvip) throws Exception

{
	//if(!this.rsm.isClosed())
	//	rsm.close();
	this.stmt.execute("insert into customer(name,plate,contact,cartype,regdate,isvip) values('"+name+"','"+ plate+"','"+contact+"','"+ cartype+"','"+regtime+"',"+isvip+")" );
		
}
public void insertnewvip(String ctime,String cid,String total,String used,String p3) throws Exception
{
	ResultSet rs =this.stmt.executeQuery("select cid  from customer order by cid desc limit 1");
	rs.first();
	Date c=Calendar.getInstance().getTime();
	Calendar now=Calendar.getInstance();
	now.add(Calendar.YEAR, 10);
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	String tenofyear=sdf.format(now.getTime());
	c.setYear(10);
	
	this.stmt.execute("insert into vipcard(cid,btime,etime,p1,p2,p3) values("+rs.getString("cid")+",'"+ctime+"','"+tenofyear+"',"+total+","+used+","+p3+")");
}

public void insertnewvip_time(String ctime,String cid,String btime,String etime) throws SQLException
{
	ResultSet rs =this.stmt.executeQuery("select cid  from customer order by cid desc limit 1");
	rs.first();
	this.stmt.execute("insert into viptimelimit(cid,begin,end,createtime) values("+rs.getString("cid")+",'"+btime+"','"+etime+"','"+ctime+"')");
	
	//this.stmt.
}

public boolean IsUnique(String name,String plate,String call) throws SQLException
{
	//this.stmt.execute(sql)
	 ResultSet rs= this.stmt.executeQuery("select * from customer where name='"+name+"'or contact='"+call+"' or plate='"+plate+"'");
	int rowcount= rs.getRow();
	if(rowcount>=1)
	return true;
	return false;
}


public ArrayList<CustomerOfVip> GetCustomerInfoS(String val) throws SQLException
{
	
	
	ResultSet rs= this.stmt.executeQuery("select * from customer inner join vipcard on customer.cid=vipcard.cid where vipcard.vcid="+val+" or plate like '%"+val+"%' or contact like '%"+val+"%'");
	rs.first();
	ArrayList<CustomerOfVip> alcv=new ArrayList<CustomerOfVip>();
	while(rs.next())
	{
	CustomerOfVip v=new CustomerOfVip();
	v.id=rs.getString("vcid");
	v.name=rs.getString("name");
	v.phone=rs.getString("contact");
	v.plate=rs.getString("plate");
	v.p1num=rs.getInt("p1");
	v.p2num=rs.getInt("p2");
	v.p3num=rs.getInt("p3");
	alcv.add(v);
	}
	return alcv;
	
}

public CustomerOfVip GetCustomerInfo(String val) throws SQLException
{
	
	
	ResultSet rs= this.stmt.executeQuery("select * from customer inner join vipcard on customer.cid=vipcard.cid where vipcard.vcid="+val+" or plate like '%"+val+"%' or contact like '%"+val+"%'");
	rs.first();
	CustomerOfVip alcv=new CustomerOfVip();
	
	
	CustomerOfVip v=new CustomerOfVip();
	v.id=rs.getString("vcid");
	v.name=rs.getString("name");
	v.phone=rs.getString("contact");
	v.plate=rs.getString("plate");
	v.p1num=rs.getInt("p1");
	v.p2num=rs.getInt("p2");
	v.p3num=rs.getInt("p3");
	
	return alcv;
	
}

public boolean ExecuteSqlCommand(String sql) throws SQLException
{
	return this.stmt.execute(sql);
	
	
	
	
}
	public void AddEmployee(String name,String pwd,String contact,String pic) throws SQLException
	{
		MD5 m5=new MD5();
		String ps= m5.GetMD5(pwd);
		this.stmt.execute("insert into employee(name,pwd,contact,picture) values(name,ps,contact,pic)");
	}
	
}
