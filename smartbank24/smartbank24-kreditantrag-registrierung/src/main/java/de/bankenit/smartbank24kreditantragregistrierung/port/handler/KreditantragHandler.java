package de.bankenit.smartbank24kreditantragregistrierung.port.handler;

import de.bankenit.smartbank24kreditantragregistrierung.adapter.dto.KreditantragDTO;
import de.bankenit.smartbank24kreditantragregistrierung.domain.services.KreditantragServiceException;

public interface KreditantragHandler {
    void handleKreditantragErfassen(KreditantragDTO dto) throws KreditantragServiceException;
}
