package de.bankenit.smartbank24kreditantragstore.port.repository.mapper;


import de.bankenit.smartbank24kreditantragstore.domain.aggregates.Kreditantrag;
import de.bankenit.smartbank24kreditantragstore.domain.aggregates.KreditantragStatus;
import de.bankenit.smartbank24kreditantragstore.port.repository.entities.KreditantragEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface KreditantragMapper {

    KreditantragEntity convert(Kreditantrag kreditantrag);


    Kreditantrag convert(KreditantragEntity kreditantragEntity);


    Iterable<Kreditantrag> convert(Iterable<KreditantragEntity> kreditantragEntity);

    default String toString(KreditantragStatus status){
        return status.name();
    }
    default KreditantragStatus toEnum(String code){
        for (KreditantragStatus possibleResult : KreditantragStatus.values()) {
            if(possibleResult.name().equals(code)){
                return possibleResult;
            }
        }
        return null;
    }
}
