package esprit.tn.projetspringbootangular.Dto;

import esprit.tn.projetspringbootangular.Entities.Package;
import esprit.tn.projetspringbootangular.Entities.Status;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
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
    Integer idUniversity;
    String name;
    String email;
    String adresse;
    String ville;
    String doyen;
}
