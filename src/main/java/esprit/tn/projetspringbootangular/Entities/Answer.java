package esprit.tn.projetspringbootangular.Entities;

import com.sun.istack.NotNull;
import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "answer")

@NoArgsConstructor
@AllArgsConstructor
public class Answer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    private String correctAnswer;

    @NotNull
    private String Answer2;

    @NotNull
    private String Answer3;


    private String Answer4;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    private Question question;
}
