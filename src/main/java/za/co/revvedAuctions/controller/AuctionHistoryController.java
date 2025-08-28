package za.co.revvedAuctions.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.revvedAuctions.domain.AuctionHistory;
import za.co.revvedAuctions.service.IAuctionHistoryService;

import java.util.List;

@RestController
@RequestMapping("/auctionHistory")
public class AuctionHistoryController {

    private final IAuctionHistoryService service;

    @Autowired
    public AuctionHistoryController(IAuctionHistoryService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<AuctionHistory> create(@RequestBody AuctionHistory auctionHistory) {
        AuctionHistory created = service.create(auctionHistory);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<AuctionHistory> read(@PathVariable Integer id) {
        AuctionHistory auctionHistory = service.read(id);
        if (auctionHistory == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(auctionHistory);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<AuctionHistory> update(@PathVariable Integer id, @RequestBody AuctionHistory auctionHistory) {
        AuctionHistory existing = service.read(id);
        if (existing == null) return ResponseEntity.notFound().build();

        AuctionHistory updated = service.update(auctionHistory);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        AuctionHistory existing = service.read(id);
        if (existing == null) return ResponseEntity.notFound().build();

        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<AuctionHistory>> getAll() {
        List<AuctionHistory> list = service.getAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/getBySession/{auctionSessionId}")
    public ResponseEntity<List<AuctionHistory>> getBySession(@PathVariable String auctionSessionId) {
        List<AuctionHistory> list = service.getByAuctionSessionId(auctionSessionId);
        return ResponseEntity.ok(list);
    }
}
