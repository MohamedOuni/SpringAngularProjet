package esprit.tn.projetspringbootangular.Controllers;

import esprit.tn.projetspringbootangular.Entities.Conversation;
import esprit.tn.projetspringbootangular.Services.ConversationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/conversations")
public class ConversationController {

    private final ConversationService conversationService;

    public ConversationController(ConversationService conversationService) {
        this.conversationService = conversationService;
    }

    @PostMapping
    public ResponseEntity<Conversation> createConversation(@RequestBody List<Integer> participantIds) {
        Conversation conversation = conversationService.createConversation(participantIds);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(conversation.getId())
                .toUri();
        return ResponseEntity.created(location).body(conversation);
    }

    @GetMapping("/{id}")
    public Conversation getConversationById(@PathVariable Integer id) {
        return conversationService.getConversationById(id);
    }
    @PutMapping("/{id}")
    public Conversation updateConversation(@PathVariable Integer id, @RequestBody Conversation conversation) {
        Conversation updatedConversation = conversationService.updateConversation(id, conversation);
        return updatedConversation;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteConversation(@PathVariable Integer id) {
        conversationService.deleteConversation(id);
        return ResponseEntity.noContent().build();
    }



}

