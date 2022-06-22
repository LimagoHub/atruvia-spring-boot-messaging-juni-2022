package de.bankenit.smartbank24kreditantragstore.port.handler;

import de.bankenit.smartbank24kreditantragstore.adapter.events.KreditantragEvent;
import de.bankenit.smartbank24kreditantragstore.adapter.events.ScoringEvent;
import de.bankenit.smartbank24kreditantragstore.domain.services.KreditantragServiceException;

public interface KreditantragHandler {
    void handleKreditantragRegistiert(KreditantragEvent event) throws KreditantragServiceException;

    void handleScoringPositive(ScoringEvent event) throws KreditantragServiceException;

    void handleScoringNegative(ScoringEvent event) throws KreditantragServiceException;

    void handleCityScoringPositive(ScoringEvent event) throws KreditantragServiceException;

    void handleCityScoringNegative(ScoringEvent event) throws KreditantragServiceException;
}
