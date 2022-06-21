package de.bankenit.smartbank24kreditantragregistrierung.port;


import de.bankenit.smartbank24kreditantragregistrierung.domain.services.KreditantragService;
import de.bankenit.smartbank24kreditantragregistrierung.domain.services.inner.KreditantragServiceImpl;
import de.bankenit.smartbank24kreditantragregistrierung.port.repositories.KreditantragRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KreditantragServiceConfig {

    @Bean
    public KreditantragService createKreditantragService(KreditantragRepository repo) {
        return new KreditantragServiceImpl(repo);
    }
}
