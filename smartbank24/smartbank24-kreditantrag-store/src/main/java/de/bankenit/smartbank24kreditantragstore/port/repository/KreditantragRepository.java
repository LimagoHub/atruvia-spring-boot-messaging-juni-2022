package de.bankenit.smartbank24kreditantragstore.port.repository;

import de.bankenit.smartbank24kreditantragstore.domain.aggregates.Kreditantrag;

import java.util.Optional;

public interface KreditantragRepository {

    void saveOrUpdate(Kreditantrag kreditantrag);
    Optional<Kreditantrag> findById(String id);
    boolean existsById(String id);
}
