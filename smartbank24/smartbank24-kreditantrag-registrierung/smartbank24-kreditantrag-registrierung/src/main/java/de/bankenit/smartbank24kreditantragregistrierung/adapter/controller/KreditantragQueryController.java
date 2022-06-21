package de.bankenit.smartbank24kreditantragregistrierung.adapter.controller;


import de.bankenit.smartbank24kreditantragregistrierung.adapter.dto.KreditantragDTO;
import de.bankenit.smartbank24kreditantragregistrierung.domain.services.KreditantragServiceException;
import de.bankenit.smartbank24kreditantragregistrierung.port.mapper.KreditantragDTOMapper;
import de.bankenit.smartbank24kreditantragregistrierung.port.repositories.KreditantragRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("kreditantraege")
@AllArgsConstructor
public class KreditantragQueryController {

    private final KreditantragRepository repo;
    private final KreditantragDTOMapper mapper;

    @GetMapping(path="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<KreditantragDTO> findById(@PathVariable String id) throws KreditantragServiceException {
        return ResponseEntity.of(repo.findById(id).map(mapper::convert));

    }
    @GetMapping(path="", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<KreditantragDTO>> findAll() throws KreditantragServiceException {
        return ResponseEntity.ok(mapper.convert(repo.findAll()));

    }
}
