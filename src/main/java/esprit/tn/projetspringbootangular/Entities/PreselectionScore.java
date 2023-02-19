package esprit.tn.projetspringbootangular.Entities;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "score")
public class PreselectionScore implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private int score;



    @OneToOne(fetch = FetchType.LAZY)
    private SelectionCriteria selectionCriteria;

    @OneToOne(fetch = FetchType.LAZY)
    private Candidacy candidacy;

}
