package in.bloomington.incident.utils;
/**
 * @copyright Copyright (C) 2014-2016 City of Bloomington, Indiana. All rights reserved.
 * @license http://www.gnu.org/copyleft/gpl.html GNU/GPL, see LICENSE.txt
 * @author W. Sibo <sibow@bloomington.in.gov>
 *
 */
import com.mysql.cj.jdbc.AbandonedConnectionCleanupThread;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.stereotype.Component;
import org.springframework.context.event.EventListener;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

@Component
public class DatabaseCleanupConfig implements ApplicationListener<ContextClosedEvent> {

    private static final Logger logger = LoggerFactory.getLogger(DatabaseCleanupConfig.class);

    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        // 1. Shut down the MySQL cleanup background thread
        try {
            logger.info("Stopping MySQL AbandonedConnectionCleanupThread...");
            AbandonedConnectionCleanupThread.checkedShutdown();
            logger.info("MySQL cleanup thread stopped successfully.");
        } catch (Throwable t) {
            logger.error("Failed to stop MySQL cleanup thread", t);
        }

        // 2. Deregister JDBC drivers to prevent Tomcat memory leak warnings
        Enumeration<Driver> drivers = DriverManager.getDrivers();
        while (drivers.hasMoreElements()) {
            Driver driver = drivers.nextElement();
            try {
		logger.info("Deregistering JDBC driver: {}", driver);
                DriverManager.deregisterDriver(driver);
            } catch (SQLException e) {
                logger.error("Error deregistering JDBC driver: {}", driver, e);
            }
        }
    }
    
    @EventListener(ContextClosedEvent.class)
    public void handleContextClosed() {
        try {
            AbandonedConnectionCleanupThread.checkedShutdown();
        } catch (Throwable ignored) {
            // Log or ignore
        }
        Enumeration<Driver> drivers = DriverManager.getDrivers();
        while (drivers.hasMoreElements()) {
            Driver driver = drivers.nextElement();
            try {
		logger.info("Deregistering JDBC driver: {}", driver);
                DriverManager.deregisterDriver(driver);
            } catch (SQLException e) {
                logger.error("Error deregistering JDBC driver: {}", driver, e);
            }
        }
    }
    
}
