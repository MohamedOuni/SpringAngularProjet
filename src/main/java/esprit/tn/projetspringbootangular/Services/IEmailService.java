package esprit.tn.projetspringbootangular.Services;

import esprit.tn.projetspringbootangular.Entities.EmailDetails;

public interface IEmailService {
    // Method
    // To send a simple email
    String sendSimpleMail(EmailDetails details);

    // Method
    // To send an email with attachment
    String sendMailWithAttachment(EmailDetails details);
}
