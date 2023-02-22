package esprit.tn.projetspringbootangular.Repository;

import esprit.tn.projetspringbootangular.Entities.Conversation;
import esprit.tn.projetspringbootangular.Entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConversationRepository extends JpaRepository<Conversation, Integer> {

}
