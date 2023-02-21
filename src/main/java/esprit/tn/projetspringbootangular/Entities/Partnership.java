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
    String Representative_Name;
    @NonNull
    String Representative_Email;
    @Enumerated(EnumType.STRING)
    Package partnerShip_Package;
    @Enumerated(EnumType.STRING)
    Status statut;
    Date PartnershipDate;
    @NonNull
    Boolean archive;

    @OneToOne(mappedBy = "partnership", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    University university;
}
