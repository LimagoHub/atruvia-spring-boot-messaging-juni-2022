package de.bankenit.smartbank24kreditantragstore.port.mapper;


import de.bankenit.smartbank24kreditantragstore.adapter.dto.KreditantragDTO;
import de.bankenit.smartbank24kreditantragstore.domain.aggregates.Kreditantrag;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface KreditantragDTOMapper {
    KreditantragDTO convert(Kreditantrag kreditantrag);
    Kreditantrag convert(KreditantragDTO kreditantrag);

    Iterable<KreditantragDTO> convert(Iterable<Kreditantrag> antraege);
}
