package esprit.tn.projetspringbootangular.Entities;


import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "quizzes")

@NoArgsConstructor
@AllArgsConstructor
public class Quiz  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    private User user ;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;



    @Column(name = "scoreQuiz")
    private Integer scoreQuiz;

    @Column(name = "time_limit")
    private Integer timeLimit;

    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Question> questions;

    @OneToOne(fetch = FetchType.LAZY)
    private SelectionCriteria selectionCriteria;
}
