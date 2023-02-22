package esprit.tn.projetspringbootangular.Services;

import esprit.tn.projetspringbootangular.Entities.Conversation;

import java.util.List;


    public interface ConversationService {
        public Conversation createConversation(List<Integer> participantIds);
        public Conversation getConversationById(Integer convers);
        public Conversation updateConversation(Integer id, Conversation updatedConversation);
        public void deleteConversation(Integer id);

    }

