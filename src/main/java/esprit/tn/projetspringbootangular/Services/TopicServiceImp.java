package esprit.tn.projetspringbootangular.Services;

import esprit.tn.projetspringbootangular.Entities.Topic;
import esprit.tn.projetspringbootangular.Entities.User;
import esprit.tn.projetspringbootangular.Repository.TopicRepository;
import esprit.tn.projetspringbootangular.Repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service

public class TopicServiceImp implements TopicService {

    @Autowired
    TopicRepository topicRepository;
    @Autowired
    UserRepository userRepository;



    public Topic addTopic(Topic topic, Integer id) {
        User user=userRepository.findById(id).orElse(null);
        topic.setId(id);
        return topicRepository.save(topic);
    }


    public List<Topic> getAllTopic() {
        return topicRepository.findAll();
    }

    public Optional<Topic> getTopicById(Integer id) {
        return topicRepository.findById(id);
    }
}


