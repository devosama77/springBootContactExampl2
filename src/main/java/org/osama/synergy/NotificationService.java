package org.osama.synergy;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    public JavaMailSender javaMailSender;

    @Autowired
    public NotificationService(JavaMailSender javaMailSender){
        this.javaMailSender=javaMailSender;
    }

    public void sendNotification(Contact contact){
        SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
        simpleMailMessage.setTo("devosama77@gmail.com");
        simpleMailMessage.setFrom(contact.getEmail());
        simpleMailMessage.setSubject("Hello From Osama");
        simpleMailMessage.setText("This is Cool Message from Osama");
        javaMailSender.send(simpleMailMessage);

    }
}
