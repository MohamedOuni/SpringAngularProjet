package esprit.tn.projetspringbootangular.Controllers;

import esprit.tn.projetspringbootangular.Entities.Topic;
import esprit.tn.projetspringbootangular.Services.TopicService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

@RequestMapping("/topics")

public class TopicController {

    private final TopicService topicService;

    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }

    @PostMapping("/{userId}")
    public ResponseEntity<Topic> addTopic(@RequestBody Topic topic, @PathVariable Integer userId) {
        Topic savedTopic = topicService.addTopic(topic, userId);
        return ResponseEntity.ok(savedTopic);
    }

    @GetMapping
    public ResponseEntity<List<Topic>> getAllTopics() {
        List<Topic> topics = topicService.getAllTopic();
        return ResponseEntity.ok(topics);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Topic> getTopicById(@PathVariable Integer id) {
        Optional<Topic> topic = topicService.getTopicById(id);
        if (topic.isPresent()) {
            return ResponseEntity.ok(topic.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
