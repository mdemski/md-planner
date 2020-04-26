package pl.okpol.mdplanner.mail;

import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

@Component
public class MailSenderImpl implements MailSender {

    private JavaMailSenderImpl mailSender;

    public MailSenderImpl(Environment environment) {
        mailSender = new JavaMailSenderImpl();

        mailSender.setHost(environment.getProperty("spring.mail.host"));
        mailSender.setPort(587);
        mailSender.setUsername("spring.mail.username");
        mailSender.setPassword("spring.mail.password");
    }

    @Override
    public void sendMail(String to, String topic, String message) {
        SimpleMailMessage sMessage = new SimpleMailMessage();
        sMessage.setTo(to);
        sMessage.setSubject(topic);
        sMessage.setText(message);
        sMessage.setFrom("mdplanner@okpol.pl");

        this.mailSender.send(sMessage);
    }
}
