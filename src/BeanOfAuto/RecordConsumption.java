package BeanOfAuto;

import java.sql.*;
import java.util.ArrayList;

public class RecordConsumption {
    private ArrayList<Staff> alStaff;
    private Connection con;
    private PreparedStatement prep;
    public Staff GetStaff(){
        return null;
    }
    public void initDBConnect(Connection c){
        con=c;

    }

    public boolean addRecordConsumption(String cid,String cpid,int count,float payable,float pocket,float rebate,String rctime) throws SQLException {

        try{


            PreparedStatement prep= con.prepareStatement("insert into recordconsumption(cid,cpid,count,payable,pocket,rebate,rctime) values(?,?,?,?,?,?,?)");
            prep.clearBatch();
            prep.setInt(1,Integer.valueOf( cid));
            prep.setInt(2,Integer.valueOf( cpid));
            prep.setInt(3,count);
            prep.setFloat (4,payable);
            prep.setFloat(5,pocket);
            prep.setFloat(6,rebate);
            prep.setDate(7, Date.valueOf(rctime));
            prep.addBatch();

            prep.executeBatch();
            prep.close();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean updateEmployee(String id,String cols,String value) throws SQLException {

        try{

            this.prep= con.prepareStatement("update employee set "+cols+" = ? where eid=?");
            prep.clearBatch();
            prep.setString(1,value);
            prep.setString(2,id);
            prep.addBatch();

            prep.executeBatch();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean deleteEmployee(int id) throws SQLException {

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
//    public void
}
