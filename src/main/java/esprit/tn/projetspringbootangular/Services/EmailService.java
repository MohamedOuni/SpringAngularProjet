package esprit.tn.projetspringbootangular.Services;

import esprit.tn.projetspringbootangular.Entities.EmailDetailAnnonce;

public interface EmailService {
    String sendSimpleMail(String email, String subject, String message);}
/*  String sendSimpleMail(EmailDetailAnnonce details);*/



