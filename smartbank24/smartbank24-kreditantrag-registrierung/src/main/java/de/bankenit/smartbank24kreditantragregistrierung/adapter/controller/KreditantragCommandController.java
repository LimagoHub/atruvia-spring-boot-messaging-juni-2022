package de.bankenit.smartbank24kreditantragregistrierung.adapter.controller;


import de.bankenit.smartbank24kreditantragregistrierung.adapter.dto.KreditantragDTO;
import de.bankenit.smartbank24kreditantragregistrierung.domain.services.KreditantragServiceException;

import de.bankenit.smartbank24kreditantragregistrierung.port.handler.KreditantragHandler;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("kreditantraege")
@AllArgsConstructor
public class KreditantragCommandController {

    private final KreditantragHandler handler;


    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> save(@Valid @RequestBody KreditantragDTO dto) throws KreditantragServiceException {
        handler.handleKreditantragErfassen(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
