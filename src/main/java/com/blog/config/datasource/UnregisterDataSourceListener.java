package com.blog.config.datasource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

@Configuration
public class UnregisterDataSourceListener implements ServletContextListener {

    Logger logger = LoggerFactory.getLogger(UnregisterDataSourceListener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // On Application Startup, please…

        // Usually I'll make a singleton in here, set up my pool, etc.
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
      // This manually deregisters JDBC driver, which prevents Tomcat 7 from complaining about memory leaks wrto this class
        Enumeration<Driver> drivers = DriverManager.getDrivers();
        while (drivers.hasMoreElements()) {
            Driver driver = drivers.nextElement();
            try {
                DriverManager.deregisterDriver(driver);
                logger.debug("deregistering jdbc driver:{}", driver);
            } catch (SQLException e) {
                e.printStackTrace();
                logger.debug("Error deregistering driver:{}", driver);
                logger.debug("Error message:{}", e.getMessage());
            }

        }
    }

}