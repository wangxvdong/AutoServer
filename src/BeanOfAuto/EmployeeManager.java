package BeanOfAuto;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.*;


public class EmployeeManager {
    private ArrayList<Staff> alStaff;
    private Connection con;
    private PreparedStatement prep;
    public Staff GetStaff(){
        return null;
    }
    public void initDBConnect(Connection c){
        con=c;

    }

    public boolean addEmployee(String name,String pwd,String contact,String picture,int salary,int aut) throws SQLException {

        try{

            this.prep= con.prepareStatement("insert into employee(name,pwd,authority,contact,picture,salary) values(?,?,?,?,?,?)");
            prep.clearBatch();
            prep.setString(1,name);


            MD5 m5=new MD5();
            String ps= m5.GetMD5(pwd);

            prep.setString(2,ps);
            prep.setInt(3,aut);
            prep.setString(4,contact);
            prep.setString(5,picture);
            prep.setInt(6,salary);
            prep.addBatch();

            prep.executeBatch();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateEmployee(String id,String cols,String value) throws SQLException {

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

    public boolean deleteEmployee(int id) throws SQLException {

        try{

            Statement   stmt = con.createStatement();
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


















