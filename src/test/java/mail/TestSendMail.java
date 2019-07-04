package mail;

import javax.mail.MessagingException;

public class TestSendMail {

    public static void main(String[] args) throws MessagingException {
        SendMail mail = new SendMail();
        mail.postMail(SendMail.emailTo, SendMail.emailSubjectTxt,SendMail.emailMsgTxt,SendMail.emailFromAddress);
    }
}
