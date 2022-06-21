package de.bankenit.smartbank24kreditantragregistrierung.port.repositories.springdata.springrepo;

import de.bankenit.smartbank24kreditantragregistrierung.port.repositories.springdata.entities.KreditantragEntity;
import org.springframework.data.repository.CrudRepository;

public interface KreditantragRepoRaw extends CrudRepository<KreditantragEntity, String> {
}
