package de.bankenit.smartbank24kreditantragregistrierung.port.handler.inner;


import de.bankenit.smartbank24kreditantragregistrierung.adapter.dto.KreditantragDTO;
import de.bankenit.smartbank24kreditantragregistrierung.adapter.events.KreditantragRegistriertEvent;
import de.bankenit.smartbank24kreditantragregistrierung.domain.services.KreditantragService;
import de.bankenit.smartbank24kreditantragregistrierung.domain.services.KreditantragServiceException;
import de.bankenit.smartbank24kreditantragregistrierung.port.mapper.KreditantragDTOMapper;
import lombok.AllArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Component
@AllArgsConstructor
@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.READ_UNCOMMITTED, rollbackFor = KreditantragServiceException.class)
public class KreditantragHandlerImpl implements de.bankenit.smartbank24kreditantragregistrierung.port.handler.KreditantragHandler {

    private static final String DESTINATION ="kreditantrag-registriert-out-0";

    private final StreamBridge bride;

    private final KreditantragService service;
    private final KreditantragDTOMapper mapper;

    //public void handle(KreditantragErfasstEvent dto) throws KreditantragServiceException{

    @Override
    public void handleKreditantragErfassen(KreditantragDTO dto) throws KreditantragServiceException{

        try {
            service.neuAnlegen(mapper.convert(dto));
            bride.send(DESTINATION, KreditantragRegistriertEvent.builder().kreditantrag(dto).build());
        } catch (KreditantragServiceException e) {
            // Missevent feurn
            throw e;
        }
    }
}
