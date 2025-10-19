package za.co.revvedAuctions.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.revvedAuctions.domain.Bid;
import za.co.revvedAuctions.service.implementation.BidService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/bids")
@CrossOrigin(origins = "http://localhost:8081") // Add this for CORS
public class BidController {

    private final BidService bidService;

    @Autowired
    public BidController(BidService bidService) {
        this.bidService = bidService;
    }

    @PostMapping("/create")
    public ResponseEntity<Bid> create(@RequestBody Bid bid) {
        // Auto-fill missing details
        Bid newBid = new Bid.Builder()
                .setCarVIN(bid.getCarVIN())
                .setUserId(bid.getUserId())
                .setBidAmount(bid.getBidAmount())
                .setBidDate(LocalDate.now())
                .setStatus("Pending Confirmation")
                .setTotalBids(bid.getTotalBids() + 1)
                .build();

        return ResponseEntity.ok(bidService.create(newBid));
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

    @GetMapping("/getAll")
    public ResponseEntity<List<Bid>> getAll() {
        return ResponseEntity.ok(bidService.getAll());
    }
}
