package com.tw;

import com.tw.todo.Todo;
import com.tw.todo.TodoRepository;
import org.apache.juli.logging.Log;
import org.jboss.logging.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class Application {

    private static final Logger LOG = Logger.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @Bean
    public CommandLineRunner setup(TodoRepository toDoRepository) {
        return (args) -> {
            toDoRepository.save(new Todo("Remove unused imports", "active"));
            toDoRepository.save(new Todo("Clean the code", "completed"));
            toDoRepository.save(new Todo("Build the artifacts", "active"));
            toDoRepository.save(new Todo("Deploy the jar file", "active"));
            LOG.info("~~~~~~~~~~~~~~The sample data has been generated~~~~~~~~~~~~");
        };
    }
}
