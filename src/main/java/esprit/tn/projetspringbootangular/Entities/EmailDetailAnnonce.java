package esprit.tn.projetspringbootangular.Entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailDetailAnnonce {
    private String recipient;
    private String msgBody;
    private String subject;

}
