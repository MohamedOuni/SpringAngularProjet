package esprit.tn.projetspringbootangular.Controllers;

import esprit.tn.projetspringbootangular.Entities.EmailDetailAnnonce;
import esprit.tn.projetspringbootangular.Entities.EmailDetails;
import esprit.tn.projetspringbootangular.Services.EmailService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@Tag(name = "Web Services pour la gestion du lannonce avec Swagger")
@RestController
@AllArgsConstructor
public class EmailController {
    @Autowired
    private final EmailService emailService;
    //@PostMapping("/sendMail")
    /*public String sendMail(@RequestBody EmailDetails details)
    {
        String status
                = emailService.sendSimpleMail(details);

        return status;
    }*/
}






