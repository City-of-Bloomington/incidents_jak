package in.bloomington.incident.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    // @Autowired
    private JavaMailSender mailSender;
    //
    // Constructor injection is preferred over @Autowired
    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }
    
    public String sendSimpleEmail(String toEmail, String fromEmail,String subject, String body) {
	String back = "";
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(fromEmail);
        message.setTo(toEmail);
        message.setSubject(subject);
        message.setText(body);
	try{
	    mailSender.send(message);
	    back = "Email sent successfully";	    
	}catch(Exception ex){
	    back = "Error sending email "+ex;
	}
	return back;
    }
}
/**
  add these to  
# 
spring.mail.host=mail-relay.gmail.com
spring.mail.port=587
// these not needed
spring.mail.username=your-email@gmail.com
spring.mail.password=your-app-password

# Additional Properties
spring.mail.properties.mail.smtp.auth=false
spring.mail.properties.mail.smtp.starttls.enable=false

# Recommended Timeouts to prevent blocked threads
spring.mail.properties.mail.smtp.connectiontimeout=5000
spring.mail.properties.mail.smtp.timeout=3000
spring.mail.properties.mail.smtp.writetimeout=5000

*/
