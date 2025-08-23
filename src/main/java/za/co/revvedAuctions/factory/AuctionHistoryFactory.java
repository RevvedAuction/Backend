package za.co.revvedAuctions.factory;

import za.co.revvedAuctions.domain.AuctionHistory;
import za.co.revvedAuctions.util.Helper;

import java.time.LocalDate;

public class AuctionHistoryFactory
{
    public static AuctionHistory createAuctionHistory(
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
