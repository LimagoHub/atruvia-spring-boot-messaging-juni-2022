package de.bankenit.smartbank24kreditantragstore.port.repository.inner;

import de.bankenit.smartbank24kreditantragstore.domain.aggregates.Kreditantrag;
import de.bankenit.smartbank24kreditantragstore.port.repository.KreditantragRepository;
import de.bankenit.smartbank24kreditantragstore.port.repository.mapper.KreditantragMapper;
import de.bankenit.smartbank24kreditantragstore.port.repository.springdata.KreditantragRepositoryRaw;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class KreditanrtragRepositoryImpl implements KreditantragRepository {

    private final KreditantragRepositoryRaw repositoryRaw;
    private final KreditantragMapper mapper;
    @Override
    public void saveOrUpdate(Kreditantrag kreditantrag) {
        repositoryRaw.save(mapper.convert(kreditantrag));
    }

    @Override
    public Optional<Kreditantrag> findById(String id) {
        return repositoryRaw.findById(id).map(mapper::convert);
    }

    @Override
    public boolean existsById(String id) {
        return repositoryRaw.existsById(id);
    }
}
