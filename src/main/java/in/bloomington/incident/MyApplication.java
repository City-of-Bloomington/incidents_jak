package in.bloomington.incident;

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
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration.Dynamic;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import in.bloomington.incident.configuration.AppConfig;

@SpringBootApplication
public class MyApplication extends SpringBootServletInitializer{ 
    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
    }
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
	return builder.sources(MyApplication.class)
	     .properties("spring.config.location=classpath:application.properties");
    }
    /**
    @Override
    public void onStartup(ServletContext container) {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(AppConfig.class);
        ServletRegistration.Dynamic dispatcher = container.addServlet("dispatcher", new DispatcherServlet(context));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");

    }
    */

}


@RestController
class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello from Spring Boot with embedded Tomcat 10 and Jakarta!";
    }
}

 



