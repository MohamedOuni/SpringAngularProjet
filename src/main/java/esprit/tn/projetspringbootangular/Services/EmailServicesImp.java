package esprit.tn.projetspringbootangular.Services;


import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailServicesImp  implements  IEmailService {

    private final JavaMailSender javaMailSender;

    @Override
    public void sendSimpleMail(String email, String subject, String message) {

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("bugSmashers@esprit.tn");
        mailMessage.setTo(email);
        mailMessage.setText(message);
        mailMessage.setSubject(subject);
        javaMailSender.send(mailMessage);
        System.out.println("Mail Send...");
    }
}
