package esprit.tn.projetspringbootangular.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer PostId;

    @ManyToOne
    private User user;

    @ManyToOne
    private Topic topic;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String body;

    private LocalDateTime dateCreated;

    @OneToMany(mappedBy = "post")
    private List<Comment> comments = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "post")
    private List<Vote> votes = new ArrayList<>();
    private Integer voteCount = 0;
}
