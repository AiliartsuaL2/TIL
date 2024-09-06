package section2.item05.springioc;

import section2.item05.Dictionary;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public SpellChecker spellChecker(Dictionary dictionary){
        return new SpellChecker(dictionary);
    }
    @Bean
    public Dictionary dictionary(){
        return new SpringDictionary();
    }
}
