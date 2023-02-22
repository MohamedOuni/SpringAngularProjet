package esprit.tn.projetspringbootangular.Services;


import esprit.tn.projetspringbootangular.Entities.Message;
import esprit.tn.projetspringbootangular.Entities.User;
import esprit.tn.projetspringbootangular.Repository.ConversationRepository;
import esprit.tn.projetspringbootangular.Repository.MessageRepository;

import java.util.List;

public interface MessageService {

    public Message addMessage(Integer conversationId, Message message, User id_user);
    public List<Message> getMessagesByConversation(Integer conversationId);
}
