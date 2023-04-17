package com.exampleCt.demoCommercetools.ShippingMethods;


import lombok.Data;

@Data
public class ShippingMethodData {

    public String key;
    public String name;
    public String zoneRates;
    public String taxCategory;
    public Boolean isDefault;
public String zoneId;
public String currencyCode;
public Long centAmount;

public String taxId;

}
