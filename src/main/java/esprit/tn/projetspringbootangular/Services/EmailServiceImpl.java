package esprit.tn.projetspringbootangular.Services;

import esprit.tn.projetspringbootangular.Entities.EmailDetails;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.security.auth.Subject;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements  EmailService {


    @Autowired
    private final JavaMailSender javaMailSender;




    public void sendSimpleEmail(String toEmail,
                                String body,
                                String Subject){
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("nouhe.kouki.1999@gmail.com");
        message.setTo(toEmail);
        message.setText(body);
        message.setSubject(Subject);

        javaMailSender.send(message);
        System.out.println("Mail Send...");
    }}


