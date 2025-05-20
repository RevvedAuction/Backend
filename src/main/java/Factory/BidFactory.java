package Factory;

import Domain.Bid;
import Util.Helper;

import java.time.LocalDate;

public class BidFactory {

    public static Bid createBid(
            String auctionSessionId,
            String carVIN,
            String userId,
            double bidAmount,
            LocalDate bidDate,
            String status) {

        if (Helper.isNullOrEmpty(auctionSessionId) || Helper.isNullOrEmpty(carVIN) ||
                Helper.isNullOrEmpty(userId))
            return null;

        return new Bid.Builder()
                .setAuctionSessionId(auctionSessionId)
                .setCarVIN(carVIN)
                .setUserId(userId)
                .setBidAmount(bidAmount)
                .setBidDate(bidDate)
                .setStatus(status)
                .build();
    }


}
