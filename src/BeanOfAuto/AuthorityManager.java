package BeanOfAuto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public  class AuthorityManager {
    public static boolean verifyAuthority(Staff s,int aut){
        if(!(s.authority<=aut)) {
            return false;
        }
        return true;
    }
    public static Staff verifyUser(String name,String pwd){
        MD5 md=new MD5();
        String md5pwd= md.GetMD5(pwd);


        String url="jdbc:mysql://bdm256530140.my3w.com:3306/bdm256530140_db";
		String user="bdm256530140";
		String pwddb="datapwd123";

/*
       String url="jdbc:mysql://localhost:3306/automobileservice";
        String user="root";
        String pwddb="123456";
*/
       // ConnectionManager cm=new ConnectionManager();
        DBConnection con=new DBConnection();
        try {
            con.ConnectDataBase(url, user, pwddb);
            Statement stmt = con.GetDBConnection().createStatement();
            ResultSet result = stmt.executeQuery("select * from employee where name='"+name+"'");
            result.first();
            //System.out.println("@@@@@"+ result.getString("name"));
           // System.out.println("@@@@@"+ result.getString("picture"));

               if (result.getString("name").equals(name) && result.getString("pwd").equals(md5pwd))
                {
                    Staff s = new Staff();
                    s.id = result.getInt("eid");
                    System.out.println("one a again ######");

                    s.name = result.getString("name");
                    s.authority = result.getInt("authority");
                    s.picture = result.getString("picture");
                    return s;
                } else
                  return null;

            } catch(ClassNotFoundException e){
                e.printStackTrace();
            } catch(SQLException e){
                e.printStackTrace();
            } catch(InstantiationException e){
                e.printStackTrace();
            } catch(IllegalAccessException e){
                e.printStackTrace();
            }

        return null;
    }
}
