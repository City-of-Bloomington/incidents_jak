package in.bloomington.incident.configuration;
import org.springframework.beans.factory.BeanRegistrar;
import org.springframework.beans.factory.BeanRegistry;
import org.springframework.core.env.Environment;
import in.bloomington.incident.service.IncidentService;

public class MyBeanRegistrar implements BeanRegistrar {

    @Override
    public void register(BeanRegistry registry, Environment env) {
        // Programmatic bean registration logic
        registry.registerBean("incidentService", IncidentService.class);
    }

    
}
