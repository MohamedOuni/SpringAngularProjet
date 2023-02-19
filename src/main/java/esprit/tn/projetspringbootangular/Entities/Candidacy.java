package esprit.tn.projetspringbootangular.Entities;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "candidacy")
public class Candidacy implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "selection_criteria_id")
    private SelectionCriteria selectionCriteria;

    @OneToOne(mappedBy = "candidacy", cascade = CascadeType.ALL, orphanRemoval = true)
    private FollowUp followUp;

    @OneToOne(fetch = FetchType.LAZY)
    private PreselectionScore preselectionScore;

    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private String email;
    @NotNull
    private String classe ;
    @NotNull
    private String description;

    private String cv;

    private String motivationLetter;

    private String recommendationLetter;

    private String transcripts;

    @NotNull
    private LocalDateTime submissionDate;




}
