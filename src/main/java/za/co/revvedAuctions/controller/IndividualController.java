//package za.co.revvedAuctions.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import za.co.revvedAuctions.domain.Individual;
//
//import za.co.revvedAuctions.service.implementation.IndividualService;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/individual")
//@CrossOrigin(origins = "http://localhost:8081")
//public class IndividualController {
//
//    private final IndividualService individualService;
//
//    @Autowired
//    public IndividualController(IndividualService individualService) {
//        this.individualService = individualService;
//    }
//
//    // Create a new Individual
//    @PostMapping("/add")
//    public ResponseEntity<Individual> createIndividual(@RequestBody Individual individual) {
//        Individual saved = individualService.create(individual);
//        return new ResponseEntity<>(saved, HttpStatus.CREATED);
//    }
//
//    // Get a single Individual by ID
//    @GetMapping("/{id}")
//    public ResponseEntity<Individual> getIndividualById(@PathVariable int id) {
//        Individual individual = individualService.read(id);
//        return (individual != null) ? ResponseEntity.ok(individual) : ResponseEntity.notFound().build();
//    }
//
//    // Get all Individuals
//    @GetMapping
//    public ResponseEntity<List<Individual>> getAllIndividuals() {
//        List<Individual> individuals = individualService.getAll();
//        return ResponseEntity.ok(individuals);
//    }
//
//    // Update Individual
//    @PutMapping("/{id}")
//    public ResponseEntity<Individual> updateIndividual(@PathVariable int id, @RequestBody Individual updatedIndividual) {
//        Individual existing = individualService.read(id);
//        if (existing == null) {
//            return ResponseEntity.notFound().build();
//        }
//
//        Individual individualToUpdate = new Individual.Builder()
//                .copy(existing)
//                .setFirstName(updatedIndividual.getFirstName())
//                .setLastName(updatedIndividual.getLastName())
//                .setEmailAddress(updatedIndividual.getEmailAddress())
//                .setDateOfBirth(updatedIndividual.getDateOfBirth())
//                .setIdentityNumber(updatedIndividual.getIdentityNumber())
//                .setPhoneNumber(updatedIndividual.getPhoneNumber())
//                .setHomeAddress(updatedIndividual.getHomeAddress())
//                .build();
//
//        Individual saved = individualService.update(individualToUpdate);
//        return ResponseEntity.ok(saved);
//    }
//
//    // Delete Individual
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<Void> deleteIndividual(@PathVariable int id) {
//        Individual existing = individualService.read(id);
//        if (existing == null) {
//            return ResponseEntity.notFound().build();
//        }
//        individualService.delete(id);
//        return ResponseEntity.noContent().build();
//    }
//}
