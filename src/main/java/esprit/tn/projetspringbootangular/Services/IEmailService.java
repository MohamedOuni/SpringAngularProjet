package esprit.tn.projetspringbootangular.Services;

public interface IEmailService {

    void sendSimpleMail(String email, String subject, String message);
}
