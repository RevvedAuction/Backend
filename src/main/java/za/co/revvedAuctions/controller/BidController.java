
package za.co.revvedAuctions.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.co.revvedAuctions.domain.Bid;
import za.co.revvedAuctions.service.IBidService;

import java.util.List;

@RestController
@RequestMapping("/api/bids")
@CrossOrigin(origins = "http://localhost:8081")
public class BidController {

    private final IBidService bidService;

    @Autowired
    public BidController(IBidService bidService) {
        this.bidService = bidService;
    }

    // ✅ Get all bids
    @GetMapping("/getall")
    public List<Bid> getAll() {
        return bidService.getAll();
    }

    // ✅ Create new bid
    @PostMapping("/create")
    public Bid create(@RequestBody Bid bid) {
        return bidService.create(bid);
    }

    // ✅ Optional: Get bids by auctionSessionId
    @GetMapping("/session/{auctionSessionId}")
    public List<Bid> getByAuctionSessionId(@PathVariable String auctionSessionId) {
        return bidService.getByAuctionSessionId(auctionSessionId);
    }
}

//package za.co.revvedAuctions.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import za.co.revvedAuctions.domain.Bid;
//import za.co.revvedAuctions.service.implementation.BidService;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/bids")
//public class BidController {
//
//    private final BidService bidService;
//
//    @Autowired
//    public BidController(BidService bidService) {
//        this.bidService = bidService;
//    }
//
//    @PostMapping("/create")
//    public ResponseEntity<Bid> create(@RequestBody Bid bid) {
//        return ResponseEntity.ok(bidService.create(bid));
//    }
//
//    @GetMapping("/read/{id}")
//    public ResponseEntity<Bid> read(@PathVariable Integer id) {
//        Bid bid = bidService.read(id);
//        return bid != null ? ResponseEntity.ok(bid) : ResponseEntity.notFound().build();
//    }
//
//    @PutMapping("/update/{id}")
//    public ResponseEntity<Bid> update(@PathVariable Integer id, @RequestBody Bid bid) {
//        Bid updatedBid = bidService.update(bid);
//        return ResponseEntity.ok(updatedBid);
//    }
//
//    @GetMapping("/getAll")
//    public ResponseEntity<List<Bid>> getAll() {
//        return ResponseEntity.ok(bidService.getAll());
//    }
//}

