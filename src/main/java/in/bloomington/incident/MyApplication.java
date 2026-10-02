package in.bloomington.incident;
/**
import org.springframework.boot.SpringApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.boot.web.servlet.ServletRegistrationBean;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration.Dynamic;
import jakarta.servlet.ServletRegistration;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
*/
import jakarta.servlet.ServletContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.web.servlet.ServletComponentScan;
// import org.springframework.beans.factory.BeanRegistrar;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration.Dynamic;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import in.bloomington.incident.configuration.AppConfig;

@SpringBootApplication
@ServletComponentScan 
public class MyApplication extends SpringBootServletInitializer{ 
    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
    }
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
	return builder.sources(MyApplication.class);
    }
    /**    
    @Override
   public void onStartup(ServletContext container) {
	// Create the 'root' Spring application context
	AnnotationConfigWebApplicationContext rootContext =
	    new AnnotationConfigWebApplicationContext();
	rootContext.register(AppConfig.class);
	
	// Manage the lifecycle of the root application context
	container.addListener(new ContextLoaderListener(rootContext));
	
	// Create the dispatcher servlet's Spring application context
	AnnotationConfigWebApplicationContext dispatcherContext =
	    new AnnotationConfigWebApplicationContext();
	dispatcherContext.register(DispatcherConfig.class);
	
	// Register and map the dispatcher servlet
	ServletRegistration.Dynamic dispatcher =
	    container.addServlet("dispatcher", new DispatcherServlet(dispatcherContext));
	dispatcher.setLoadOnStartup(1);
	dispatcher.addMapping("/");
    }
    */
    /**
    @Override
    public void onStartup(ServletContext container) throws ServletException {

        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(AppConfig.class);
        ctx.setServletContext(container);

        ServletRegistration.Dynamic servlet = container.addServlet(
                "dispatcher", new DispatcherServlet(ctx));

        servlet.setLoadOnStartup(1);
        servlet.addMapping("/control");
    }
    */
    @Override
    public void onStartup(ServletContext container) {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(AppConfig.class);
        ServletRegistration.Dynamic dispatcher = container.addServlet("dispatcher", new DispatcherServlet(context));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");

    }

}


@RestController
class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello from Spring Boot with embedded Tomcat 10 and Jakarta!";
    }
}

 



