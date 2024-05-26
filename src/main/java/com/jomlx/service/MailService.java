package com.jomlx.service;

import com.sanctionco.jmail.JMail;
import org.simplejavamail.api.email.Email;
import org.simplejavamail.api.mailer.Mailer;
import org.simplejavamail.email.EmailBuilder;
import org.simplejavamail.mailer.MailerBuilder;

public class MailService {
    private Mailer mailer;
    private final String username = "jomelmislos123@gmail.com";
    private final String password = "qekctxqbaexflvhz";
    
    public MailService() {
        mailer = MailerBuilder
                    .withSMTPServer("smtp.gmail.com", 587, username, password)
                    .buildMailer();        
    }
    
    public void sendMail(String toEmail, String authCode) {
        boolean isEmailValid = JMail.strictValidator()
                .isValid(toEmail);
        
        if (isEmailValid) {
            String msgTemp = "<html>"
                    + "<body>"
                    + "<h2>Hello, </h2>"
                    + "<p>Thank you for signing up for our service! To complete your registration, please use the following one-time password (OTP):</p>"
                    + "<p>" + authCode + "</p>"
                    + "<p>If you did not sign up for our service, please ignore this email.</p>"
                    + "<p>Thank you!</p>"
                    + "<p>Memo company</p>"
                    + "</body>"
                    + "</html>";
            
            Email email = EmailBuilder.startingBlank()
                    .from("Memo Community", username)
                    .to(toEmail)
                    .withSubject("Verify Your Email Address")
                    .withHTMLText(msgTemp)
                    .buildEmail();

            mailer.sendMail(email);
            System.out.println("OTP email sent.");
        } else {
            System.out.println("Message cannot be sent");
        }
    }
}
