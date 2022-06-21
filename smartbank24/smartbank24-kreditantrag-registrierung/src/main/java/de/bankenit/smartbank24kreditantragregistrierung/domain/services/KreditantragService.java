package de.bankenit.smartbank24kreditantragregistrierung.domain.services;

import de.bankenit.smartbank24kreditantragregistrierung.domain.aggregates.Kreditantrag;

import java.util.Optional;

public interface KreditantragService {
    void neuAnlegen(Kreditantrag kreditantrag) throws KreditantragServiceException;

    Optional<Kreditantrag> ladeKreditantrag(String id) throws KreditantragServiceException;

    Iterable<Kreditantrag> ladeAlleKreditantraege() throws KreditantragServiceException;
}
