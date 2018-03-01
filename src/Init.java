import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


public class Init implements ServletContextListener {

    @Override
    public void contextInitialized( ServletContextEvent event ) {
        System.out.println("QSDOIHQSDOIHQOISDHQSDQSDQSD");
    }

    @Override
    public void contextDestroyed( ServletContextEvent event ) {
        
    }
}