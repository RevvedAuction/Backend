package Factory;
/*
Company.java
Author: Esihle Mlinjana
Student Number: 222441712
Date: 18 May 2025
 */

import Domain.Company;
import Util.Helper;

public class CompanyFactory {

    public static Company createCompany(int companyId, String companyName, int registrationNo, String taxNumber) {
      if (Helper.isNullOrEmpty(companyId) || Helper.isNullOrEmpty(companyName) || Helper.isNullOrEmpty(registrationNo) || Helper.isNullOrEmpty(taxNumber)) {
            return null;
        }
        return new Company.Builder()
                .setCompanyId(companyId)
                .setCompanyName(companyName)
                .setRegistrationNo(registrationNo)
                .setTaxNumber(taxNumber)
                .build();
    }

}
