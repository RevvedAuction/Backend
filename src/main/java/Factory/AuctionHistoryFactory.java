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
            String sellerId,
            String buyerId,
            double finalPrice,
            LocalDate auctionDate,
            String status)
    {
        if (Helper.isNullOrEmpty(auctionSessionId) || Helper.isNullOrEmpty(carVIN) ||
                Helper.isNullOrEmpty(userId))
            return null;

        return new AuctionHistory.Builder()
                .setHistoryId(historyId)
                .setAuctionSessionId(auctionSessionId)
                .setCarVIN(carVIN)
                .setUserId(userId)
                .setSellerId(sellerId)
                .setBuyerId(buyerId)
                .setFinalPrice(finalPrice)
                .setAuctionDate(auctionDate)
                .setStatus(status)
                .build();
    }

}
