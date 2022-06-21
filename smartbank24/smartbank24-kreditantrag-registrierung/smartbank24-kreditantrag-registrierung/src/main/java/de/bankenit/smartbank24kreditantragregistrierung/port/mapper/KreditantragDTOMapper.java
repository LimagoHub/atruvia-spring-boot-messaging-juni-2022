package de.bankenit.smartbank24kreditantragregistrierung.port.mapper;

import de.bankenit.smartbank24kreditantragregistrierung.adapter.dto.KreditantragDTO;
import de.bankenit.smartbank24kreditantragregistrierung.domain.aggregates.Kreditantrag;
import de.bankenit.smartbank24kreditantragregistrierung.port.repositories.springdata.entities.KreditantragEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface KreditantragDTOMapper {
    Kreditantrag convert(KreditantragDTO dto);
    KreditantragDTO convert(Kreditantrag kreditantrag);
    Iterable<KreditantragDTO> convert(Iterable<Kreditantrag> kreditantrags);
}
