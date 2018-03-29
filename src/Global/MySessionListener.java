package Global;

import org.apache.catalina.Session;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MySessionListener implements HttpSessionListener{
    public MySessionListener(){
        System.out.println("session init created");

    }

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        HttpSession hs= httpSessionEvent.getSession();
        hs.setAttribute("hello","world!!!!!!!!!!");
        System.out.println("session created");
        System.out.println("session created");

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        System.out.println("sessio destroyed");
    }
}
