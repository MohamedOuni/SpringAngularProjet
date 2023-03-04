package esprit.tn.projetspringbootangular.Controllers;

import esprit.tn.projetspringbootangular.Services.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;

@RestController
public class MailController {
    @Autowired
    private MailService emailService;
    @PostMapping("/send-email")
    public ResponseEntity<String> sendEmail(@RequestParam("to") String to,
                                            @RequestParam("subject") String subject,
                                            @RequestParam("name") String name) throws MessagingException {

        emailService.sendEmail(to, subject, name);

        return ResponseEntity.ok("Email sent successfully");
    }
}
