package de.bankenit.smartbank24kreditantragstore.adapter.events;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class BaseEvent {
    @Builder.Default
    private String eventId= UUID.randomUUID().toString();
    @Builder.Default
    private LocalDateTime timestamp = LocalDateTime.now();
}
