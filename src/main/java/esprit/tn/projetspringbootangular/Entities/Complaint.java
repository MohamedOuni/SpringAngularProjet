package esprit.tn.projetspringbootangular.Entities;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level=AccessLevel.PRIVATE)
@Entity
public class Complaint
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idComplaint;
    String title;
    @Enumerated(EnumType.STRING)
    Categorie categorie;
    @Temporal(TemporalType.DATE)
    Date date;
    String description;
    @Enumerated(EnumType.STRING)
    ComplaintStatus status;
    String response;
    @ManyToOne()
    User user;
}
