package BeanOfAuto;



import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
public String GetMD5(String token)
{
	

	System.out.println("welcome to my site");
			String str=new String();
		    MessageDigest md;
			try {
				md = MessageDigest.getInstance("MD5");
				 byte[] md5 = md.digest(token.getBytes());
				 for(int i=0;i<16;i++)
				 {
					 String c=new String();
					 c+=md5[i];
					 int a=0;
					a= Integer.parseInt(c, 10);
					
					 String s= Integer.toHexString(a);
					 
					 if(s.length()>2)
					 str+=s.substring(s.length()-2);
					 else if(s.length()==1)
						 str+="0"+s;
					 else
						 str+=s;
					 
					 
				 }
				
				 System.out.println(str);
				 
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return str;
}
}

