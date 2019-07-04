package mail;

import javax.mail.*;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.internet.*;
import java.util.Properties;

public class SendMail {

    private class SMTPAuthenticator extends Authenticator {
        public PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(SMTP_AUTH_USER, SMTP_AUTH_PWD);
        }
    }
    private static final String SMTP_HOST_NAME = "smtp.gmail.com";
    private static final String SMTP_AUTH_USER = "kartashivan@gmail.com";
    private static final String SMTP_AUTH_PWD = "Fake2017";

    static final String emailMsgTxt = "Error found while clicking on an element";
    static final String emailSubjectTxt = "Please correct the Xpath";
    static final String emailFromAddress = "kartashivan@gmail.com";

    static final String[] emailTo = {"koiv.igor@gmail.com"};

    public void postMail(String[] recipients, String subject, String message, String from) throws MessagingException {
        boolean debug = false;

        Properties props = new Properties();

        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", SMTP_HOST_NAME);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.defaultEncoding","UTF-8");
        props.put("mail.smtp.socketFactory.fallback","false");
        props.put("mail.smtp.port","465");
        props.put("mail.smtp.socketFactory.port","465");

        Authenticator auth = new SMTPAuthenticator();
        Session mailSession = Session.getDefaultInstance(props, auth);

        mailSession.setDebug(debug);
        Message msg = new MimeMessage(mailSession);

        msg.setFrom(new InternetAddress(from));

        InternetAddress[] addressTo = new InternetAddress[recipients.length];
        for (int i = 0; i < recipients.length; i++) {
            addressTo[i] = new InternetAddress(recipients[i]);
        }
        msg.setRecipients(Message.RecipientType.TO,addressTo);

        msg.setSubject(subject);
        msg.setContent(message, "text/plain");

        Transport.send(msg);
        System.out.println("Sucsessfully sent mail");
    }
}