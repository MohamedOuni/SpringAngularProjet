package esprit.tn.projetspringbootangular.Entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class University implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idUniversity;
    @NonNull
    String name;
    @NonNull
    String email;
    @NonNull
    String adresse;
    @NonNull
    String ville;
    @NonNull
    String doyen;
    @Enumerated(EnumType.STRING)
    Specialities speciality;
    @NonNull
    String logo;

    @OneToOne
    Partnership partnership;

    @OneToMany (mappedBy = "university")
    Set<Rating> ratings;

    @OneToMany (mappedBy = "university", cascade = CascadeType.REMOVE)
    Set<AnnonceMobilte> anMobiltes;

    @OneToMany (mappedBy = "university")
    Set<AnnonceHeberge> anhebergements;

    @ManyToOne
    User user;
}
