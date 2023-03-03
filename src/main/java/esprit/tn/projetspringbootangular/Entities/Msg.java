package esprit.tn.projetspringbootangular.Entities;


import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level=AccessLevel.PRIVATE)
public class Msg {
    String email; String subject; String message;
}
