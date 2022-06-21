package de.bankenit.smartbank24kreditantragregistrierung.port.repositories;

import de.bankenit.smartbank24kreditantragregistrierung.domain.aggregates.Kreditantrag;

import java.util.Optional;

public interface KreditantragRepository {
    void save(Kreditantrag kreditantrag);

    Optional<Kreditantrag> findById(String s);

    boolean existsById(String s);

    Iterable<Kreditantrag> findAll();
}
