package esprit.tn.projetspringbootangular.Entities;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Conversation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToMany
    @JoinTable(
            name = "conversation_user",
            joinColumns = @JoinColumn(name = "conversation_id"),
            inverseJoinColumns = @JoinColumn(name = "id_user")
    )
    private List<User> users = new ArrayList<>();

    @OneToMany(mappedBy = "conversation")
    private List<Message> messages = new ArrayList<>();
}
