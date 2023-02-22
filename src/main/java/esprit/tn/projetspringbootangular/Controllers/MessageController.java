package esprit.tn.projetspringbootangular.Controllers;

import esprit.tn.projetspringbootangular.Entities.Message;
import esprit.tn.projetspringbootangular.Entities.User;
import esprit.tn.projetspringbootangular.Services.MessageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conversations/{conversationId}/messages")
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("/{id_user}")
    public ResponseEntity<Message> addMessage(@PathVariable Integer conversationId, @RequestBody Message message,  @PathVariable("idUser")  User id_user) {
        Message savedMessage = messageService.addMessage(conversationId,message,id_user);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedMessage);
    }

    @GetMapping
    public ResponseEntity<List<Message>> getMessagesByConversation(@PathVariable Integer conversationId) {
        List<Message> messages = messageService.getMessagesByConversation(conversationId);
        return ResponseEntity.ok(messages);
    }
}
