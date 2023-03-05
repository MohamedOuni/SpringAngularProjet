package esprit.tn.projetspringbootangular.Entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CommentAnnonce implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCommentaire;
    private String contenu;
    private LocalDate datePublication;
    private Integer likeReact;
    private Integer dislikeReact;
    private Integer signale;

    @ManyToOne
    private AnnonceMobilte annonce;
    @ManyToOne
    private User user;


}
