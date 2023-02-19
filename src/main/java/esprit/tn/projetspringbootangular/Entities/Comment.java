package esprit.tn.projetspringbootangular.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private User user;

    @JsonIgnore
    @ManyToOne
    private Post post;

    @Column(nullable = false)
    private String body;

    private LocalDateTime dateCreated;
    @JsonIgnore

    @OneToMany(mappedBy = "comment")
    private List<Vote> votes = new ArrayList<>();
    private int score;
}
