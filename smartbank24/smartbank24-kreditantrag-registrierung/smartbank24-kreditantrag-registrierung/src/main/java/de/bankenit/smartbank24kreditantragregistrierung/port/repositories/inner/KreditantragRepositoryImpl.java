package de.bankenit.smartbank24kreditantragregistrierung.port.repositories.inner;


import de.bankenit.smartbank24kreditantragregistrierung.domain.aggregates.Kreditantrag;
import de.bankenit.smartbank24kreditantragregistrierung.port.repositories.mapper.KreditantragMapper;
import de.bankenit.smartbank24kreditantragregistrierung.port.repositories.springdata.entities.KreditantragEntity;
import de.bankenit.smartbank24kreditantragregistrierung.port.repositories.springdata.springrepo.KreditantragRepoRaw;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class KreditantragRepositoryImpl implements de.bankenit.smartbank24kreditantragregistrierung.port.repositories.KreditantragRepository {

    private final KreditantragRepoRaw repoRaw;
    private final KreditantragMapper mapper;



    @Override
    public void save(Kreditantrag kreditantrag) {
        repoRaw.save(mapper.convert(kreditantrag));
    }

    @Override
    public Optional<Kreditantrag> findById(String s) {
        return repoRaw.findById(s).map(mapper::convert);
    }

    @Override
    public boolean existsById(String s) {
        return repoRaw.existsById(s);
    }

    @Override
    public Iterable<Kreditantrag> findAll() {
        return mapper.convert(repoRaw.findAll());
    }
}
