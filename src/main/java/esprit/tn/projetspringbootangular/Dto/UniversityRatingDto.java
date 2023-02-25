package esprit.tn.projetspringbootangular.Dto;

import esprit.tn.projetspringbootangular.Entities.Specialities;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Setter
@Builder
@AllArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UniversityRatingDto {

    //University Attributes
    Integer idUniversity;
    String name;
    String email;
    String adresse;
    String ville;
    String doyen;
    @Enumerated(EnumType.STRING)
    Specialities speciality;

    //Rating Attributes

    Integer idRating;

    int nb_stars;
}
