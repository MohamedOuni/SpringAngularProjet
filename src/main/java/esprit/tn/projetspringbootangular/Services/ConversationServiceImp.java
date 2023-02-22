package esprit.tn.projetspringbootangular.Services;

import esprit.tn.projetspringbootangular.Entities.Conversation;
import esprit.tn.projetspringbootangular.Entities.User;
import esprit.tn.projetspringbootangular.Exception.ResourceNotFoundException;
import esprit.tn.projetspringbootangular.Repository.ConversationRepository;
import esprit.tn.projetspringbootangular.Repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ConversationServiceImp implements ConversationService{
    @Autowired
    ConversationRepository conversationRepository;
    @Autowired
    UserRepository userRepository;

    @Override
    public Conversation createConversation(List<Integer> participantIds) {
        List<User> participants = userRepository.findAllById(participantIds);
        Conversation conversation = new Conversation();
        conversation.setUsers(participants);

        return  conversationRepository.save(conversation);
    }


    @Override
    public Conversation getConversationById(Integer conversationId) {
        Optional<Conversation> conversationOptional = conversationRepository.findById(conversationId);
        if (!conversationOptional.isPresent()) {
            throw new ResourceNotFoundException("Conversation not found");
        }
        return conversationOptional.get();
    }
    @Override
    public Conversation updateConversation(Integer id, Conversation updatedConversation) {
        Conversation conversation = getConversationById(id);

       /* conversation.setTitle(updatedConversation.getTitle());
        conversation.setParticipants(updatedConversation.getParticipants());*/
        return conversationRepository.save(conversation);
    }
    @Override
    public void deleteConversation(Integer id) {
        conversationRepository.deleteById(id);
    }
}
