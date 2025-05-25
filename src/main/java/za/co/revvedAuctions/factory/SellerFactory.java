package za.co.revvedAuctions.factory;

import za.co.revvedAuctions.domain.Seller;
import za.co.revvedAuctions.util.Helper;

public class SellerFactory {

    public static Seller createSeller(
            String sellerId,
            String businessType
    ){

        if(Helper.isNullOrEmpty(sellerId) || Helper.isNullOrEmpty(businessType))
            return null;

        return new Seller.Builder()
                .setSellerId(sellerId)
                .setBusinessType(businessType)
                .build();
    }

}
