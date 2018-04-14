package BeanOfAuto;

import java.sql.*;
import java.util.ArrayList;

public class ConsumpManager {
    private ArrayList<Staff> alStaff;
    private Connection con;
    private PreparedStatement prep;
    private RecordConsump rcmp;

    public ConsumpManager(){
        this.rcmp=new RecordConsump();
    }

    public Staff GetStaff(){
        return null;
    }
    public void initDBConnect(Connection c){
        con=c;

    }

    public boolean addRecordConsumption(String cid,String cpid,float payable,float pocket,float rebate,String rctime) throws SQLException {

        try{

            this.prep= con.prepareStatement("insert into recordconsumption(cid,cpid,payable,pocket,rebate,rctime) values(?,?,?,?,?,?)");
            prep.clearBatch();
            prep.setString(1,cid);
            prep.setString(2,cpid);
            prep.setFloat (3,payable);
            prep.setFloat(4,pocket);
            prep.setFloat(5,rebate);
            prep.setDate(6, Date.valueOf(rctime));
            prep.addBatch();

            prep.executeBatch();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deduct(String id,String cols,String value) throws SQLException {

        try{


            this.prep= con.prepareStatement("update vipcard set "+cols+" ="+cols+"- ? where vcid=?");
            prep.clearBatch();
            prep.setInt(1,Integer.parseInt(value));
            prep.setInt(2,Integer.parseInt(id));
            prep.addBatch();

            prep.executeBatch();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean recharge(String id,String cols,String value) throws SQLException {

        try{


            this.prep= con.prepareStatement("update vipcard set "+cols+" ="+cols+"+ ? where vcid=?");
            prep.clearBatch();
            prep.setInt(1,Integer.parseInt(value));
            prep.setInt(2,Integer.parseInt(id));
            prep.addBatch();

            prep.executeBatch();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean deleteEmployee(int id) throws SQLException {

        try{

            Statement stmt = con.createStatement();
            stmt.execute("delete from employee where eid="+Integer.toString(id));
            stmt.close();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public void closeStatment() throws SQLException {
        if(!this.prep.isClosed())
            this.prep.close();
    }
}
