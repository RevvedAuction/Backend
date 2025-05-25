package za.co.revvedAuctions.factory;

import za.co.revvedAuctions.domain.AuctionSession;
import za.co.revvedAuctions.util.Helper;

import java.time.LocalDate;
import java.time.LocalTime;

public class AuctionSessionFactory {

    public static AuctionSession createAuctionSession(
            String sessionID,
            LocalTime startTime,
            LocalTime endTime,
            LocalDate date,
            boolean sessionStatus,
            String carVIN){

        if(Helper.isNullOrEmpty(sessionID) || Helper.isNullOrEmpty(carVIN))
            return null;

        return new AuctionSession.Builder()
                .setSessionID(sessionID)
                .setStartTime(startTime)
                .setEndTime(endTime)
                .setDate(date)
                .setSessionStatus(sessionStatus)
                .setCarVIN(carVIN)
                .build();
    }
}
