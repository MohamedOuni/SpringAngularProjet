package esprit.tn.projetspringbootangular.Entities;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "selection_criteria")
public class SelectionCriteria implements Serializable  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "selectionCriteria", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Candidacy> candidacies;

    @OneToOne(fetch = FetchType.LAZY)
    private Quiz quiz;

    @OneToOne(fetch = FetchType.LAZY)
    private PreselectionScore preselectionScore;

    @Column(name = "deadline")
    private Date deadline;

    @NotNull

    private Integer maxStudentsNumber;
    @NotNull
    private String department;

    @NotNull
    private String Niveau;

    @NotNull
    private Boolean requiresCV;

    @NotNull
    private Boolean requiresMotivationLetter;

    @NotNull
    private Boolean requiresRecommendationLetter;

    @NotNull
    private Boolean requiresTranscripts;

    @NotNull
    private Boolean requiresQuiz;

    @NotNull
    private String title;

    @NotNull
    private String description;

    @NotNull
    private Integer passingScore;


    private Integer quizpassingScore;

}
