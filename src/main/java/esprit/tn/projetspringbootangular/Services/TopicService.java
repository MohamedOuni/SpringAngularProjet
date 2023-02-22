package esprit.tn.projetspringbootangular.Services;

import esprit.tn.projetspringbootangular.Entities.Topic;

import java.util.List;
import java.util.Optional;

public interface TopicService {
    public Topic addTopic(Topic topic, Integer id);
    public List<Topic> getAllTopic();
    public Optional<Topic> getTopicById(Integer id);

}