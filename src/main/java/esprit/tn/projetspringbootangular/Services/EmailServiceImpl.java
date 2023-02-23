package esprit.tn.projetspringbootangular.Services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements  EmailService {


    @Autowired
    private final JavaMailSender javaMailSender;


    /*@Override*/
    /*public String sendSimpleMail(EmailDetailAnnonce details) {
        try {

            // Creating a simple mail message
            SimpleMailMessage mailMessage
                    = new SimpleMailMessage();

            // Setting up necessary details
            mailMessage.setFrom("nouhe.kouki.1999@gmail.com");
            mailMessage.setTo(details.getRecipient());
            mailMessage.setText(details.getMsgBody());
            mailMessage.setSubject(details.getSubject());

            // Sending the mail
            javaMailSender.send(mailMessage);
            return "Mail Sent Successfully...";
        } catch (Exception e) {
            return "Error while Sending Mail";
        }

    }*/

    @Override
    public String sendSimpleMail(     String email, String subject, String message) {
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom("nouhe.kouki.1999@gmail.com");
            mailMessage.setTo(email);
            mailMessage.setSubject(subject);
            mailMessage.setText(message);
            javaMailSender.send(mailMessage);
            return "Email envoyé avec succès!";
        } catch (Exception ex) {
            return "Erreur lors de l'envoi de l'e-mail: " + ex.getMessage();
        }
    }
    }



