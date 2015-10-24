package ua.artcode.listener;

import ua.artcode.model.AppDB;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener // config in web.xml
public class InitAppDataListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        AppDB appDB = new AppDB();
        ServletContext servletContext = sce.getServletContext();
        servletContext.setAttribute("appDB",appDB);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
