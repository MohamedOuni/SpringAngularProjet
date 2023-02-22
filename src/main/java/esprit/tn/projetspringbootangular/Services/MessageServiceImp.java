package esprit.tn.projetspringbootangular.Services;

import esprit.tn.projetspringbootangular.Entities.Conversation;
import esprit.tn.projetspringbootangular.Entities.Message;
import esprit.tn.projetspringbootangular.Entities.User;
import esprit.tn.projetspringbootangular.Exception.ResourceNotFoundException;
import esprit.tn.projetspringbootangular.Repository.ConversationRepository;
import esprit.tn.projetspringbootangular.Repository.MessageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service

public class MessageServiceImp implements MessageService{

        private final MessageRepository messageRepository;
        private final ConversationRepository conversationRepository;

        public MessageServiceImp(MessageRepository messageRepository, ConversationRepository conversationRepository) {
            this.messageRepository = messageRepository;
            this.conversationRepository = conversationRepository;
        }



    public Message addMessage(Integer conversationId, Message message, User id_user) {
            Optional<Conversation> conversationOptional = conversationRepository.findById(conversationId);
            if (!conversationOptional.isPresent()) {
                throw new ResourceNotFoundException("Conversation not found");
            }
            Conversation conversation = conversationOptional.get();
            message.setConversation(conversation);
            message.setSender(id_user);
            message.setTimestamp(LocalDateTime.now());
            return messageRepository.save(message);
        }

        public List<Message> getMessagesByConversation(Integer conversationId) {
            Optional<Conversation> conversationOptional = conversationRepository.findById(conversationId);
            if (!conversationOptional.isPresent()) {
                throw new ResourceNotFoundException("Conversation not found");
            }
            Conversation conversation = conversationOptional.get();
            return messageRepository.findByConversation(conversation);


        }
    }
