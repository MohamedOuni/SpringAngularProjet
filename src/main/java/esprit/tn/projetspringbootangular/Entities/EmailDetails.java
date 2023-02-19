package esprit.tn.projetspringbootangular.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class EmailDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idEmailDetails;
    private String recipient;
    private String msgBody;
    private String subject;
    private String attachment;
}
