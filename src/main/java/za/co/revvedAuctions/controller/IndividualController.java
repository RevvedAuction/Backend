package za.co.revvedAuctions.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.revvedAuctions.domain.Individual;
import za.co.revvedAuctions.dto.IndividualDTO;
import za.co.revvedAuctions.service.IndividualService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/individual")
@CrossOrigin(origins = "http://localhost:8081")
public class IndividualController {

    private final IndividualService individualService;

    @Autowired
    public IndividualController(IndividualService individualService) {
        this.individualService = individualService;
    }

    // Convert domain Individual to DTO
    private IndividualDTO mapToDTO(Individual individual) {
        IndividualDTO dto = new IndividualDTO();
        dto.setIndividualId(individual.getIndividualId());
        dto.setFirstName(individual.getFirstName());
        dto.setLastName(individual.getLastName());
        dto.setEmailAddress(individual.getEmailAddress());
        dto.setDateOfBirth(individual.getDateOfBirth());
        dto.setIdentityNumber(individual.getIdentityNumber());
        dto.setPhoneNumber(individual.getPhoneNumber());
        dto.setHomeAddress(individual.getHomeAddress());
        return dto;
    }

    // Create a new Individual
    @PostMapping("/add")
    public ResponseEntity<IndividualDTO> createIndividual(@RequestBody Individual individual) {
        Individual saved = individualService.create(individual);
        return new ResponseEntity<>(mapToDTO(saved), HttpStatus.CREATED);
    }

    // Get a single individual by ID
    @GetMapping("/{id}")
    public ResponseEntity<IndividualDTO> getIndividualById(@PathVariable("id") int id) {
        Individual individual = individualService.read(id);
        if (individual != null) {
            return ResponseEntity.ok(mapToDTO(individual));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Get all individuals
    @GetMapping
    public ResponseEntity<List<IndividualDTO>> getAllIndividuals() {
        List<IndividualDTO> dtos = individualService.getAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    // Update individual
    @PutMapping("/{id}")
    public ResponseEntity<IndividualDTO> updateIndividual(@PathVariable("id") int id, @RequestBody Individual updatedIndividual) {
        Individual existing = individualService.read(id);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }

        Individual individualToUpdate = new Individual.Builder()
                .copy(existing)
                .setFirstName(updatedIndividual.getFirstName())
                .setLastName(updatedIndividual.getLastName())
                .setEmailAddress(updatedIndividual.getEmailAddress())
                .setDateOfBirth(updatedIndividual.getDateOfBirth())
                .setIdentityNumber(updatedIndividual.getIdentityNumber())
                .setPhoneNumber(updatedIndividual.getPhoneNumber())
                .setHomeAddress(updatedIndividual.getHomeAddress())
                .build();

        Individual saved = individualService.update(individualToUpdate);
        return ResponseEntity.ok(mapToDTO(saved));
    }

    // Delete individual
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteIndividual(@PathVariable("id") int id) {
        Individual existing = individualService.read(id);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }
        individualService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
