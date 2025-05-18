package Factory;

import Domain.Seller;
import Util.Helper;

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
