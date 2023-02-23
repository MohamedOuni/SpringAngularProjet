package esprit.tn.projetspringbootangular.Controllers;

import esprit.tn.projetspringbootangular.Entities.EmailDetailAnnonce;
import esprit.tn.projetspringbootangular.Services.EmailService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Web Services pour la gestion du lannonce avec Swagger")
@RestController
@AllArgsConstructor
public class EmailController {
   /* @Autowired
    private final EmailService emailService;*/

    // Sending a simple Email
  /*  @PostMapping("/sendMail")
    public String
    sendMail(@RequestBody String email, @RequestBody String subject, @RequestBody String message) {
        String status
                = emailService.sendSimpleMail(email, subject, message);

        return status;
    }*/

}

