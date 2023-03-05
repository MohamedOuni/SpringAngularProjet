package esprit.tn.projetspringbootangular.Configuration;

import edu.stanford.nlp.pipeline.StanfordCoreNLP;


import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;


import java.util.Properties;

@Service
public class Pipeline {
    static StanfordCoreNLP pipeline;
    private static Properties properties;
    private static StanfordCoreNLP stanfordCoreNLP;
    private Pipeline() {}static {
        properties = new Properties();
        properties.setProperty("annotators", "tokenize,ssplit,pos,lemma, parse, sentiment");
        properties.setProperty("tokenize.language", "en");
    }
    @Bean(name = "stanfordCoreNLP")
    public static StanfordCoreNLP getInstance() {
        if(stanfordCoreNLP == null) {
            stanfordCoreNLP = new StanfordCoreNLP(properties);
        }
        return stanfordCoreNLP;
    }
}
