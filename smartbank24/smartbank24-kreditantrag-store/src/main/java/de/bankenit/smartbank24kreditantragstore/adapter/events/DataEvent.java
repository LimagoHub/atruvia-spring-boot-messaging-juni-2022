package de.bankenit.smartbank24kreditantragstore.adapter.events;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DataEvent <T>{

    private String eventId;
    private LocalDateTime timestamp;
    private T payload;
}
