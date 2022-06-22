package de.bankenit.smartbank24kreditantragstore.adapter.eventlistener;

import de.bankenit.smartbank24kreditantragstore.adapter.events.KreditantragEvent;
import de.bankenit.smartbank24kreditantragstore.adapter.events.ScoringEvent;
import de.bankenit.smartbank24kreditantragstore.domain.services.KreditantragServiceException;
import de.bankenit.smartbank24kreditantragstore.port.handler.KreditantragHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration

@Slf4j
public class ReceiverConfig {



    @Bean
    public Consumer<KreditantragEvent> kreditantragregistriert(final KreditantragHandler handler) {
        return event -> {
            try {
                handler.handleKreditantragRegistiert(event);
            } catch (KreditantragServiceException e) {
                log.error("Fehler beim Verarbeiten des Events", e);
            }
        };
    }
    @Bean
    public Consumer<ScoringEvent> scoringnegative (final KreditantragHandler handler){
        return event -> {
            try {
                handler.handleScoringNegative(event);
            } catch (KreditantragServiceException e) {
                log.error("Fehler beim Verarbeiten des Events", e);
            }
        };
    }
    @Bean
    public Consumer<ScoringEvent> scoringpositive (final KreditantragHandler handler){
        return event -> {
            try {
                handler.handleScoringPositive(event);
            } catch (KreditantragServiceException e) {
                log.error("Fehler beim Verarbeiten des Events", e);
            }
        };
    }
    @Bean
    public Consumer<ScoringEvent> cityscoringnegative (final KreditantragHandler handler){
        return event -> {
            try {
                handler.handleCityScoringNegative(event);

            } catch (KreditantragServiceException e) {
                log.error("Fehler beim Verarbeiten des Events", e);
            }
        };
    }
    @Bean
    public Consumer<ScoringEvent> cityscoringpositive (final KreditantragHandler handler){
        return event -> {
            try {
                handler.handleCityScoringPositive(event);
            } catch (KreditantragServiceException e) {
                log.error("Fehler beim Verarbeiten des Events", e);
            }
        };
    }

}
