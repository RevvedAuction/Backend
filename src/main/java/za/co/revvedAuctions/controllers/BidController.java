package za.co.revvedAuctions.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.revvedAuctions.domain.Bid;
import za.co.revvedAuctions.service.BidService;

import java.util.List;

@RestController
@RequestMapping("/bids")
public class BidController {

    private final BidService bidService;

    @Autowired
    public BidController(BidService bidService) {
        this.bidService = bidService;
    }

    @PostMapping("/create")
    public ResponseEntity<Bid> create(@RequestBody Bid bid) {
        return ResponseEntity.ok(bidService.create(bid));
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<Bid> read(@PathVariable Integer id) {
        Bid bid = bidService.read(id);
        return bid != null ? ResponseEntity.ok(bid) : ResponseEntity.notFound().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Bid> update(@PathVariable Integer id, @RequestBody Bid bid) {
        Bid updatedBid = bidService.update(bid);
        return ResponseEntity.ok(updatedBid);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        bidService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Bid>> getAll() {
        return ResponseEntity.ok(bidService.getAll());
    }
}
