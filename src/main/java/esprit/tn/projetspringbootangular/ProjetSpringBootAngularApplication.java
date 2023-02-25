package esprit.tn.projetspringbootangular;

import esprit.tn.projetspringbootangular.Entities.Partnership;
import esprit.tn.projetspringbootangular.Repository.PartnershipRepository;
import esprit.tn.projetspringbootangular.Services.PartnershipServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjetSpringBootAngularApplication {

    @Autowired
    PartnershipServiceImpl partnershipService;
    @Autowired
    private PartnershipRepository partnershipRepository;

    public static void main(String[] args) {
        SpringApplication.run(ProjetSpringBootAngularApplication.class, args);
    }






}
