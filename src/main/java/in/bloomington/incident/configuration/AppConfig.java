package in.bloomington.incident.configuration;
/**
 * @copyright Copyright (C) 2014-2015 City of Bloomington, Indiana. All rights reserved.
 * @license http://www.gnu.org/copyleft/gpl.html GNU/GPL, see LICENSE.txt
 * @author W. Sibo <sibow@bloomington.in.gov>
 *
 */

import java.util.List;
import java.util.ArrayList;
import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.beans.factory.BeanRegistrar;
import org.springframework.beans.factory.BeanRegistry;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.core.env.Environment;

@Configuration
public class AppConfig{

    final static String fileLocation = "/srv/data/incidents/conf/application.properties";
    @Bean(name = "propertiesfile")		
    public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
	PropertySourcesPlaceholderConfigurer properties = new PropertySourcesPlaceholderConfigurer();
	properties.setLocation(new FileSystemResource(fileLocation));
	properties.setIgnoreResourceNotFound(false);
	return properties;
    }

    @Bean
    public DispatcherServlet dispatcherServlet() {
	DispatcherServlet dispatcherServlet = new DispatcherServlet();
	dispatcherServlet.setThreadContextInheritable(true);
	dispatcherServlet.setThrowExceptionIfNoHandlerFound(true);
	return dispatcherServlet;
    }
    /**
    @Bean
    public ServletRegistrationBean dispatcherServletRegistration() {
	
	ServletRegistrationBean registration = new ServletRegistrationBean(dispatcherServlet());
	registration.setLoadOnStartup(0);
	registration.setName(DispatcherServletAutoConfiguration.DEFAULT_DISPATCHER_SERVLET_REGISTRATION_BEAN_NAME);
	
	return registration;
    }
    */

    
}
