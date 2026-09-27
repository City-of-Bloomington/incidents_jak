package in.bloomington.incident.utils;
import java.io.IOException;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.core.Ordered;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class IncidentFilter implements Filter {

    // static String securityPolicy = "frame-src 'none'; sandbox allow-forms allow-scripts allow-popups allow-same-origin allow-top-navigation allow-popups-to-escape-sandbox; img-src 'self' data:; object-src 'none';frame-ancestors 'none'; script-src 'self' https://bloomington.in.gov https://outlaw.bloomington.in.gov https://auth.bloomington.in.gov;";
    static String securityPolicy = "frame-src 'none'; sandbox allow-forms allow-scripts allow-popups allow-same-origin allow-top-navigation allow-popups-to-escape-sandbox; img-src 'self' data:; object-src 'none';frame-ancestors 'none';";  
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) 
        throws IOException, ServletException {
	HttpServletResponse response = (HttpServletResponse) resp;
	response.addHeader("Content-Security-Policy", IncidentFilter.securityPolicy);
	response.addHeader("X-Frame-Options", "DENY");    
	chain.doFilter(req, resp);
    }
    @Override
    public void destroy() {

    }    
    @Override
    public void init(FilterConfig arg0) throws ServletException {

    }
    
}
