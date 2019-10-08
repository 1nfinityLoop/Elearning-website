package com.mycompany.elearn.email;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;


public class SmtpMailSender {
  
   
    private MailSender mailSender;
     
    
    public void setMailSender(MailSender mailSender) {  
        this.mailSender = mailSender;  
    }  
 
    /**
     * This method will send compose and send the message
     * */
    public void sendMail(String to, String subject, String body)
    {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        mailSender.send(message);
    }
}
