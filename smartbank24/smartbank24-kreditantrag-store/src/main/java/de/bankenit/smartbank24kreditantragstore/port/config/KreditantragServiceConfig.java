package de.bankenit.smartbank24kreditantragstore.port.config;


import de.bankenit.smartbank24kreditantragstore.domain.services.KreditantragService;
import de.bankenit.smartbank24kreditantragstore.domain.services.inner.KreditantragServiceImpl;
import de.bankenit.smartbank24kreditantragstore.port.repository.KreditantragRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KreditantragServiceConfig {

    @Bean
    public KreditantragService createKreditantragService(KreditantragRepository repo) {
        return new KreditantragServiceImpl(repo);
    }
}
