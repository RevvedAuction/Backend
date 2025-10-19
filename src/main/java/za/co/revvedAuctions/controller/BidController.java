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
