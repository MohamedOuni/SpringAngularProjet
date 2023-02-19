package esprit.tn.projetspringbootangular.Entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level=AccessLevel.PRIVATE)
@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idAppointment;
    @Temporal(TemporalType.DATE)
    Date date;
    @Enumerated(EnumType.STRING)
    AppointmentStatus status;
    @ManyToOne()
    User user;
}
