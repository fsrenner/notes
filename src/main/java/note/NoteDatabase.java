package note;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class NoteDatabase {

    @Bean
    CommandLineRunner initDatabase(NoteRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Note("Take out trash")));
        };
    }
}
