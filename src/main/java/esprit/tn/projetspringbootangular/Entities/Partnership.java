package esprit.tn.projetspringbootangular.Entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Partnership implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idPartnership;
    @NonNull
    String Representative_Name;
    @NonNull
    String Representative_Email;
    @Enumerated(EnumType.STRING)
    Package partnerShip_Package;
    @Enumerated(EnumType.STRING)
    Status statut;

    @OneToOne(mappedBy = "partnership")
    University university;
}
