package pl.okpol.mdplanner.mail;

public interface MailSender {
    void sendMail(String to, String topic, String message);
}
