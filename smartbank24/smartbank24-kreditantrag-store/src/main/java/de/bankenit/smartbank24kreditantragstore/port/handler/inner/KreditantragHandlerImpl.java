package de.bankenit.smartbank24kreditantragstore.port.handler.inner;


import de.bankenit.smartbank24kreditantragstore.adapter.dto.KreditantragDTO;
import de.bankenit.smartbank24kreditantragstore.adapter.events.KreditantragEvent;
import de.bankenit.smartbank24kreditantragstore.adapter.events.ScoringEvent;
import de.bankenit.smartbank24kreditantragstore.adapter.events.eventstore.services.EventService;
import de.bankenit.smartbank24kreditantragstore.domain.aggregates.Kreditantrag;
import de.bankenit.smartbank24kreditantragstore.domain.aggregates.KreditantragStatus;
import de.bankenit.smartbank24kreditantragstore.domain.services.KreditantragService;
import de.bankenit.smartbank24kreditantragstore.domain.services.KreditantragServiceException;
import de.bankenit.smartbank24kreditantragstore.port.mapper.KreditantragDTOMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import static de.bankenit.smartbank24kreditantragstore.domain.aggregates.Kreditantrag.StatusWechsel.*;

@Component
@AllArgsConstructor
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = KreditantragServiceException.class)
public class KreditantragHandlerImpl implements de.bankenit.smartbank24kreditantragstore.port.handler.KreditantragHandler {

    private final KreditantragService service;
    private final KreditantragDTOMapper mapper;

    private final EventService eventService;
    @Override
    public void handleKreditantragRegistiert(KreditantragEvent event) throws KreditantragServiceException{
        try {

            eventService.storeKreditantragRegistiertEvent(event);

            Kreditantrag antrag = mapper.convert(event.getKreditantrag());
            service.speichereKreditantrag(antrag);

            eventService.storeAndFireKreditAntragPersistiertOutEvent(event);


        } catch (RuntimeException e) {
            throw new KreditantragServiceException("Upps",e);
        }
    }

    @Override
    public void handleScoringPositive(ScoringEvent event) throws KreditantragServiceException {
        try {
            String id = event.getCreditApplicationId();

            eventService.storeScoringPositiveEvent(event);

            if(service.verarbeitePositivesScoring(id) == ACCEPTED){
                KreditantragDTO toSend = mapper.convert(service.findeKreditantragMitId(id));
                eventService.storeAndFireKreditvertragEmpfohlenOutEvent(KreditantragEvent.builder().kreditantrag(toSend).build());
            }


        } catch (RuntimeException e) {
            throw new KreditantragServiceException("Upps",e);
        }
    }

    @Override
    public void handleScoringNegative(ScoringEvent event) throws KreditantragServiceException {
        try {
            String id = event.getCreditApplicationId();

            eventService.storeScoringNegativeEvent(event);

            if(service.verarbeiteNegativesScoring(id) == DENIED){
                KreditantragDTO toSend = mapper.convert(service.findeKreditantragMitId(id));
                eventService.storeAndFireKreditvertragAbgelehntOutEvent(KreditantragEvent.builder().kreditantrag(toSend).build());
            }



        } catch (RuntimeException e) {
            throw new KreditantragServiceException("Upps",e);
        }
    }

    @Override
    public void handleCityScoringPositive(ScoringEvent event) throws KreditantragServiceException {
        try {

            String id = event.getCreditApplicationId();

            eventService.storeCityScoringPositiveEvent(event);

            if(service.verarbeitePositivesCityScoring(id) == ACCEPTED){
                KreditantragDTO toSend = mapper.convert(service.findeKreditantragMitId(id));
                eventService.storeAndFireKreditvertragEmpfohlenOutEvent(KreditantragEvent.builder().kreditantrag(toSend).build());
            }


        } catch (RuntimeException e) {
            throw new KreditantragServiceException("Upps",e);
        }
    }

    @Override
    public void handleCityScoringNegative(ScoringEvent event) throws KreditantragServiceException {
        try {

            String id = event.getCreditApplicationId();

            eventService.storeCityScoringNegativeEvent(event);

            if(service.verarbeiteNegativesCityScoring(id) == DENIED){
                KreditantragDTO toSend = mapper.convert(service.findeKreditantragMitId(id));
                eventService.storeAndFireKreditvertragAbgelehntOutEvent(KreditantragEvent.builder().kreditantrag(toSend).build());
            }


        } catch (RuntimeException e) {
            throw new KreditantragServiceException("Upps",e);
        }
    }
}
