package de.bankenit.smartbank24kreditantragregistrierung.domain.services.inner;

import de.bankenit.smartbank24kreditantragregistrierung.domain.aggregates.Kreditantrag;
import de.bankenit.smartbank24kreditantragregistrierung.domain.services.KreditantragServiceException;
import de.bankenit.smartbank24kreditantragregistrierung.port.repositories.KreditantragRepository;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class KreditantragServiceImpl implements de.bankenit.smartbank24kreditantragregistrierung.domain.services.KreditantragService {

    private final KreditantragRepository repo;

    @Override
    public void neuAnlegen(Kreditantrag kreditantrag) throws KreditantragServiceException {
        try {
            if(repo.existsById(kreditantrag.getCreditApplicationId()))
                throw new KreditantragServiceException("Antrag existiert bereits");
            repo.save(kreditantrag);
        } catch (RuntimeException e) {
            throw new KreditantragServiceException("Upps", e);
        }
    }

    @Override
    public Optional<Kreditantrag> ladeKreditantrag(String id) throws KreditantragServiceException{
        try {
            return repo.findById(id);
        } catch (RuntimeException e) {
            throw new KreditantragServiceException("Upps", e);
        }
    }

    @Override
    public Iterable<Kreditantrag> ladeAlleKreditantraege() throws KreditantragServiceException{
        try {
            return repo.findAll();
        } catch (RuntimeException e) {
            throw new KreditantragServiceException("Upps", e);
        }
    }
}
