package de.bankenit.smartbank24kreditantragregistrierung.adapter.events;

import de.bankenit.smartbank24kreditantragregistrierung.adapter.dto.KreditantragDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class KreditantragRegistriertEvent extends BaseEvent{

    private KreditantragDTO kreditantrag;
}
