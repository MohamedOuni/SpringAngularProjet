package esprit.tn.projetspringbootangular.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {
    /**
     *
     */
    static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id_user;

    String nom;

    String prenom;

    @Column
    String username;

    @Temporal(TemporalType.DATE)
    Date dateNaissance;

    String email;

    String password;

    private String verificationCode;

    private boolean verified = false;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "id_user"),
            inverseJoinColumns = @JoinColumn(name = "id"))
    private Set<Role> roles = new HashSet<>();



    @OneToMany(mappedBy = "user")
    Set<University> universities;
    @OneToMany(mappedBy = "user")
    Set<Candidacy> candidacies;
    @ManyToMany(mappedBy = "users")
    private List<Conversation> conversations = new ArrayList<>();
    @OneToMany(mappedBy = "user")
    Set<FollowUp> followUps;
    @OneToOne(mappedBy = "user")
    private Quiz quiz;
    @OneToMany(mappedBy = "user")
    private List<Abonnement> abonnements;


    @OneToMany(mappedBy = "user")
    private List<FavorisMobile> favorisMobiles;
    @OneToMany(mappedBy = "user")
    private List<FavorisHebergement> favorisHebergements;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CommentAnnonce> comments = new ArrayList<>();


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AnnonceMobilte> annonceMobiltes = new ArrayList<>();
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AnnonceHeberge> annonceHeberges = new ArrayList<>();



    public User(String nom,String prenom,String username,String email,String password,Date dateNaissance){
        this.nom = nom;
        this.prenom =prenom ;
        this.username = username;
        this.email = email;
        this.password = password;
        this.dateNaissance = dateNaissance ;
    }

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }



}
