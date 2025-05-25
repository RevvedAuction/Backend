/*
Company.java
Author: Esihle Mlinjana
Student Number: 222441712
Date: 11 May 2025
 */

package za.co.revvedAuctions.domain;

public class Company {

    private int companyId;
    private String companyName;
    private int registrationNo;
    private String taxNumber;

    private Company() {
    }

    public Company(Builder builder) {
        this.companyId = builder.companyId;
        this.companyName = builder.companyName;
        this.registrationNo = builder.registrationNo;
        this.taxNumber = builder.taxNumber;
    }

    private int getCompanyId() {
        return companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public int getRegistrationNo() {
        return registrationNo;
    }

    public String getTaxNumber() {
        return taxNumber;
    }

    @Override
    public String toString() {
        return "Company{" +
                "companyId=" + companyId +
                ", companyName='" + companyName + '\'' +
                ", registrationNo=" + registrationNo +
                ", taxNumber='" + taxNumber + '\'' +
                '}';
    }

   public static class Builder{
       private int companyId;
       private String companyName;
       private int registrationNo;
       private String taxNumber;

       public Builder setCompanyId(int companyId) {
           this.companyId = companyId;
           return this;
       }

       public Builder setCompanyName(String companyName) {
           this.companyName = companyName;
           return this;
       }

       public Builder setRegistrationNo(int registrationNo) {
           this.registrationNo = registrationNo;
           return this;
       }

       public Builder setTaxNumber(String taxNumber) {
           this.taxNumber = taxNumber;
           return this;
       }

       public Builder copy(Company company){
           this.companyId = company.companyId;
           this.companyName = company.companyName;
           this.registrationNo = company.registrationNo;
           this.taxNumber = company.taxNumber;
           return this;
       }

       public Company build(){
           return new Company(this);
       }
   }
}
