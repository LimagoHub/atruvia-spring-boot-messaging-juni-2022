package de.limagi.empfaengerprojekt;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.SQLOutput;
import java.util.function.Consumer;

@Configuration
public class ReceiverConfig {

    @Bean
    public Consumer<Event> receive() {
        return e->System.out.println(e);
    }
}
