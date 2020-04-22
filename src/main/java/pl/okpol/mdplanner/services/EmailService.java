package pl.okpol.mdplanner.services;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailService {

    private JavaMailSender javaMailSender;
    private UserService userService;

    public EmailService(JavaMailSender javaMailSender, UserService userService) {
        this.javaMailSender = javaMailSender;
        this.userService = userService;
    }

    public void sendActiveUser(String email, String uuid, String serverAddress) {
        String htmlMsg = "Naciśnij <a href=\""
                + "http://localhost:4200" + "/aktywacja/"
                + email + "&"
                + uuid
                + "\">aktywuj</a> żeby aktywować konto";
        String title = "MDPlanner - link do aktywacji konta";
        sendHTMLMessage(email,htmlMsg,title);
    }


    public void sendHTMLMessage(String email, String message, String title) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
        String htmlMsg = message;
        try {
            mimeMessage.setContent(htmlMsg, "text/html;charset=utf-8");
            helper.setTo(email);
            helper.setSubject(title);
            helper.setFrom("mdplanner@okpol.pl");
            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }


}
