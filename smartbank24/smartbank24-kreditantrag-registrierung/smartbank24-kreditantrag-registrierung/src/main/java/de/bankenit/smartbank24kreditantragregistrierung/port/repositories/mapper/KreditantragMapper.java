package de.bankenit.smartbank24kreditantragregistrierung.port.repositories.mapper;

import de.bankenit.smartbank24kreditantragregistrierung.domain.aggregates.Kreditantrag;
import de.bankenit.smartbank24kreditantragregistrierung.port.repositories.springdata.entities.KreditantragEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface KreditantragMapper {

    Kreditantrag convert(KreditantragEntity entity);
    KreditantragEntity convert(Kreditantrag kreditantrag);
    Iterable<Kreditantrag> convert(Iterable<KreditantragEntity> entities);

}
