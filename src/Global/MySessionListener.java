package Global;

import BeanOfAuto.CustomerOfVip;
import BeanOfAuto.Staff;
import org.apache.catalina.Session;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MySessionListener implements HttpSessionListener{
    public MySessionListener(){
        System.out.println("session init created");

    }

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        HttpSession hs= httpSessionEvent.getSession();
        if(hs.isNew()) {
            hs.setAttribute("nowdate",new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()));
            hs.setAttribute("hello", "world!!!!!!!!!!");
            hs.setAttribute("isfirstrunofsearchvip", "true");
            CustomerOfVip vp=new CustomerOfVip();
            vp.id="-1";
            hs.setAttribute("projectnum", vp);
            hs.setAttribute("deductviphasruned",false);
            Staff s=new Staff();
            s.name="nobody";
            s.authority=10;
            hs.setAttribute("curemployee",s);
        }

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        System.out.println("sessio destroyed");
    }
}
