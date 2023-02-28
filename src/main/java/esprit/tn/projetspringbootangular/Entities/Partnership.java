package esprit.tn.projetspringbootangular.Entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Partnership implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idPartnership;
    @NonNull
    String representative_Name;
    @NonNull
    String representative_Email;
    @Enumerated(EnumType.STRING)
    Package partnerShip_Package;
    @Enumerated(EnumType.STRING)
    Status statut;
    Date partnershipDate;
    @NonNull
    Boolean archive;
    @NonNull
    float duree;

    @OneToOne()
    University university;
}
