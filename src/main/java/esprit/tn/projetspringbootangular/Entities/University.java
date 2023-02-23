package esprit.tn.projetspringbootangular.Entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

    @OneToOne
    Partnership partnership;

    @OneToMany (mappedBy = "university")
    Set<Rating> ratings;

    @OneToMany (mappedBy = "university", cascade = CascadeType.REMOVE)
    List<AnnonceMobilte> anMobiltes;

    @OneToMany (mappedBy = "university")
    List<AnnonceHeberge> anhebergements;

    @ManyToOne
    User user;
}
