package Factory;

import Domain.AuctionHistory;
import Util.Helper;

import java.time.LocalDate;

public class AuctionHistoryFactory
{
    public static AuctionHistory createAuctionHistory(
            short historyId,
            String auctionSessionId,
            String carVIN,
            String userId,
            double bidAmount,
            LocalDate bidDate,
            String status,
            int totalBids)
    {
        if (Helper.isNullOrEmpty(auctionSessionId) || Helper.isNullOrEmpty(carVIN) ||
                Helper.isNullOrEmpty(userId))
            return null;

        return new AuctionHistory.Builder()
                .setHistoryId(historyId)
                .setAuctionSessionId(auctionSessionId)
                .setCarVIN(carVIN)
                .setUserId(userId)
                .setBidAmount(bidAmount)
                .setBidDate(bidDate)
                .setStatus(status)
                .setTotalBids(totalBids)
                .build();
    }

}
