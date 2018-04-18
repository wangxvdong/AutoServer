package BeanOfAuto;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
import java.sql.ResultSet;
import BeanOfAuto.RecordConsump;
import java.util.ArrayList;

public class CustomerManager {

    private Connection con;
    private Statement stmt;
    private ArrayList<RecordConsump> rcmp;


    public CustomerManager(){
        this.rcmp=new ArrayList<>();
    }
    public void initDBConnect(Connection c){
        con=c;

    }
    public void closeStatement(){
        try {
            if(!this.stmt.isClosed()) {
                this.stmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void insertnewcustomer(String name,String plate,String contact,String cartype,String regtime,String isvip) throws Exception{
        //if(!this.rsm.isClosed())
        //	rsm.close();
        Statement st= this.con.createStatement();
        st.execute("insert into customer(name,plate,contact,cartype,regdate,isvip) values('"+name+"','"+ plate+"','"+contact+"','"+ cartype+"','"+regtime+"',"+isvip+")" );

        st.close();

    }
    public void insertnewvip(String ctime,String cid,String total,String used,String p3) throws Exception
    {
        Statement st= this.con.createStatement();
        ResultSet rs =st.executeQuery("select cid  from customer order by cid desc limit 1");
        rs.first();
        Date c=Calendar.getInstance().getTime();
        Calendar now=Calendar.getInstance();
        now.add(Calendar.YEAR, 10);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String tenofyear=sdf.format(now.getTime());
        c.setYear(10);
        String gscid=rs.getString("cid");
        st.execute("insert into vipcard(cid,btime,etime,p1,p2,p3) values("+gscid+",'"+ctime+"','"+tenofyear+"',"+total+","+used+","+p3+")");
        st.close();
        if(Integer.valueOf(total)>=1) {
            RecordConsump r=new RecordConsump();

            r.cid = gscid;
            r.date = ctime;
            r.cpid=1;
            r.count=Integer.valueOf(total);
            this.rcmp.add(r);
        }
        if(Integer.valueOf(used)>=1) {
            RecordConsump r=new RecordConsump();

            r.cid = gscid;
            r.date = ctime;
            r.cpid=2;
            r.count=Integer.valueOf(used);
            this.rcmp.add(r);
        }
        if(Integer.valueOf(p3)>=1) {
            RecordConsump r=new RecordConsump();

            r.cid = gscid;
            r.date = ctime;
            r.cpid=4;
            r.count=Integer.valueOf(p3);
            this.rcmp.add(r);
        }
       /* RecordConsumption rc=new RecordConsumption();
        rc.initDBConnect(this.con);
        if(Integer.valueOf(total)>=1)
        rc.addRecordConsumption(rs.getString("cid"),"1",Integer.valueOf(total),)*/
    }

    public void insertnewvip_time(String ctime,String cid,String btime,String etime) throws SQLException
    {
        Statement st= this.con.createStatement();
        ResultSet rs =st.executeQuery("select cid  from customer order by cid desc limit 1");
        rs.first();
        String gscid=rs.getString("cid");
        st.execute("insert into vipcard(cid,btime,etime) values("+rs.getString("cid")+",'"+btime+"','"+etime+"')");

        st.close();
        if(gscid!=null)
         if(Integer.valueOf(gscid)>0){
            RecordConsump r=new RecordConsump();

            r.cid = gscid;
            r.date = ctime;

            this.rcmp.add(r);
        }

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


        Statement st=this.con.createStatement();
        ResultSet rs= st.executeQuery("select * from customer inner join vipcard on customer.cid=vipcard.cid where vipcard.vcid="+val+" or plate like '%"+val+"%' or contact like '%"+val+"%'");
//        rs.first();
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
            v.vid=rs.getInt("cid");
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
    public ArrayList<RecordConsump> listReconrdConsump(){
        return this.rcmp;
    }

    public ResultSet listExpiryMember() {


        try {
            Statement st = this.con.createStatement();
          return st.executeQuery("select *  from expirymember");


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
