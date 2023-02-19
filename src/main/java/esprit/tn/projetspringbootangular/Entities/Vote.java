package esprit.tn.projetspringbootangular.Entities;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;
@Data
@Entity
public class Vote {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer voteId;
    private TypeVote voteType;
    @NotNull
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "postId", referencedColumnName = "postId")
    private Post post;
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "id_user", referencedColumnName = "id_user")
    private User user;

    // @JoinColumn(name = "post_id")

    @ManyToOne
    @JoinColumn(name = "comment_id")
    private Comment comment;

}
