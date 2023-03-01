package esprit.tn.projetspringbootangular;

import esprit.tn.projetspringbootangular.Services.IserviceAnnonce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableAspectJAutoProxy // activation AOP
@EnableScheduling
public class ProjetSpringBootAngularApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjetSpringBootAngularApplication.class, args);}




}







