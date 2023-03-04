package esprit.tn.projetspringbootangular.Dto;

import esprit.tn.projetspringbootangular.Entities.Package;
import esprit.tn.projetspringbootangular.Entities.Status;
import esprit.tn.projetspringbootangular.Entities.University;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@ToString
public class PartnershipDto {
    //Attribut Partnership
    Integer idPartnership;
    String representative_Name;
    String representative_Email;
    @Enumerated(EnumType.STRING)
    Package partnerShip_Package;
    @Enumerated(EnumType.STRING)
    Status statut;
    Date partnershipDate;
    Boolean archive;

    //Attribut University
    private  String name;
    private String email;
    private String adresse;
    private String ville;
    private String doyen;

}
