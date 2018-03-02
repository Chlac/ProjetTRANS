package web;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import core.Application;

/**
 * 
 *
 */
public class Init implements ServletContextListener {

    
    /**
     * Gets called at the server initialization, this is the entry point of the project
     */
	@Override
    public void contextInitialized( ServletContextEvent event ) {
        Application.init();
    }

    @Override
    public void contextDestroyed( ServletContextEvent event ) {
        
    }
}