package Global;

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
            System.out.println("session created");
        }

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        System.out.println("sessio destroyed");
    }
}
