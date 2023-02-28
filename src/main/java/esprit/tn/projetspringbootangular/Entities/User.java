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
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    int id_user;
    @Column(nullable = false)
    String nom ;


    @Column(nullable = false)
    String prenom ;

    @Column(nullable = false,unique = true)
    String username;

    @Column(nullable = false,unique = true)
    String email ;

    @Column(nullable = false)
    int telephone ;

    @Column(nullable = false)
    String password ;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    Date dateNaissance ;

    String photo;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="user_roles",
            joinColumns = @JoinColumn(name="id_user"),
            inverseJoinColumns = @JoinColumn(name="id_role"))
    private Set<Role> roles = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "student" , cascade = CascadeType.PERSIST)
    Set<Appointment>  appointments;

    @OneToMany(mappedBy = "universityOfficer",cascade = CascadeType.PERSIST)
    Set<Appointment> appointmentsU;
    @OneToMany(mappedBy = "user",cascade = CascadeType.PERSIST)
    Set<Complaint> complaints;
    @OneToMany(mappedBy = "user")
    List<AnnonceHeberge> annonceHeberges;
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



}
