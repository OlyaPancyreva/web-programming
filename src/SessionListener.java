import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionListener implements HttpSessionListener {
    public void sessionCreated(HttpSessionEvent arg0){
        System.out.println("A new session is created");
    }

    public void sessionDestroyed(HttpSessionEvent arg0){
        System.out.println("session is destroyed");
    }
}
