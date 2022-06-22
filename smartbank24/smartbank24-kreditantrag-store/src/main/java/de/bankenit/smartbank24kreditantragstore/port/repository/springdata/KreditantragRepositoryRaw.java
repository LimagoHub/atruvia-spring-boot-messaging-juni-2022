package de.bankenit.smartbank24kreditantragstore.port.repository.springdata;

import de.bankenit.smartbank24kreditantragstore.port.repository.entities.KreditantragEntity;
import org.springframework.data.repository.CrudRepository;

public interface KreditantragRepositoryRaw extends CrudRepository<KreditantragEntity, String> {
}
