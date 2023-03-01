package esprit.tn.projetspringbootangular.Entities;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
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
    @Size(min=3, message="Title must contain at least 3 characters")
    String title;
    @Enumerated(EnumType.STRING)
    Categorie categorie;
    Date created_at;
    @Size(min= 10,message="Description must contain at least 10 characters")
    @Size(max= 100,message="Description must contain a maximum of 100 characters")
    @NotEmpty(message = "Please provide a description !")
    String description;
    @Enumerated(EnumType.STRING)
    ComplaintStatus status;
    String response;
    @ManyToOne()
    User user;
}
