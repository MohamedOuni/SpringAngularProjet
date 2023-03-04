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
public class University implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idUniversity;
    @Column(length = 45, nullable = false, unique = true)
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
    @Lob
    @Column(length = 45, nullable = true)
    byte[]  logo;

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

    public University(String name, @NonNull String email, @NonNull String adresse, @NonNull String ville, @NonNull String doyen, byte[] logo) {
        this.name = name;
        this.email = email;
        this.adresse = adresse;
        this.ville = ville;
        this.doyen = doyen;
        this.logo = logo;
    }

}
