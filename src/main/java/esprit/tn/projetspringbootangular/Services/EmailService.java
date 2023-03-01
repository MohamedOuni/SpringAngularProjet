package esprit.tn.projetspringbootangular.Services;

import esprit.tn.projetspringbootangular.Entities.EmailDetailAnnonce;
import esprit.tn.projetspringbootangular.Entities.EmailDetails;

public interface EmailService {




    public void sendSimpleEmail(String toEmail, String body, String Subject);
}




