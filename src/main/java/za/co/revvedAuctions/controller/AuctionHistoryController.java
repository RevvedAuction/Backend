package za.co.revvedAuctions.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.revvedAuctions.domain.AuctionHistory;
import za.co.revvedAuctions.dto.AuctionHistoryDTO;
import za.co.revvedAuctions.service.AuctionHistoryService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/auctionhistory")
@CrossOrigin(origins = "http://localhost:8081")
public class AuctionHistoryController {

    private final AuctionHistoryService service;

    @Autowired
    public AuctionHistoryController(AuctionHistoryService service) {
        this.service = service;
    }

    // Map domain to DTO
    private AuctionHistoryDTO mapToDTO(AuctionHistory history) {
        AuctionHistoryDTO dto = new AuctionHistoryDTO();
        dto.setHistoryId(history.getHistoryId());
        dto.setAuctionSessionId(history.getAuctionSessionId());
        dto.setCarVIN(history.getCarVIN());
        dto.setUserId(history.getUserId());
        dto.setSellerId(history.getSellerId());
        dto.setBuyerId(history.getBuyerId());
        dto.setFinalPrice(history.getFinalPrice());
        dto.setAuctionDate(history.getAuctionDate());
        dto.setStatus(history.getStatus());
        return dto;
    }

    // Create auction history
    @PostMapping("/add")
    public ResponseEntity<AuctionHistoryDTO> create(@RequestBody AuctionHistory history) {
        AuctionHistory saved = service.create(history);
        return new ResponseEntity<>(mapToDTO(saved), HttpStatus.CREATED);
    }

    // Get auction history by ID
    @GetMapping("/{id}")
    public ResponseEntity<AuctionHistoryDTO> getById(@PathVariable("id") int id) {
        AuctionHistory history = service.read(id);
        if (history != null) {
            return ResponseEntity.ok(mapToDTO(history));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Get all auction history
    @GetMapping
    public ResponseEntity<List<AuctionHistoryDTO>> getAll() {
        List<AuctionHistoryDTO> dtos = service.getAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtos);
    }

    // Update auction history
    @PutMapping("/{id}")
    public ResponseEntity<AuctionHistoryDTO> update(@PathVariable("id") int id,
                                                    @RequestBody AuctionHistory updated) {
        AuctionHistory existing = service.read(id);
        if (existing == null) return ResponseEntity.notFound().build();

        AuctionHistory toUpdate = new AuctionHistory.Builder()
                .copy(existing)
                .setAuctionSessionId(updated.getAuctionSessionId())
                .setCarVIN(updated.getCarVIN())
                .setUserId(updated.getUserId())
                .setSellerId(updated.getSellerId())
                .setBuyerId(updated.getBuyerId())
                .setFinalPrice(updated.getFinalPrice())
                .setAuctionDate(updated.getAuctionDate())
                .setStatus(updated.getStatus())
                .build();

        AuctionHistory saved = service.update(toUpdate);
        return ResponseEntity.ok(mapToDTO(saved));
    }

    // Delete auction history
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        AuctionHistory existing = service.read(id);
        if (existing == null) return ResponseEntity.notFound().build();
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
