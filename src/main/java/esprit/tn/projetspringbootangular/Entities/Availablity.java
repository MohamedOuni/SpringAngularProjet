package esprit.tn.projetspringbootangular.Entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level=AccessLevel.PRIVATE)
@Entity
public class Availablity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idAvailability;
    @Temporal(TemporalType.DATE)
    Date dateAvailables;
    @ManyToOne
    User user;
}
