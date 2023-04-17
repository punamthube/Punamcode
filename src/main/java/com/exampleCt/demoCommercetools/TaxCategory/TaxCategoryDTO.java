package com.exampleCt.demoCommercetools.TaxCategory;


import lombok.*;

@Data
public class TaxCategoryDTO {
//create Tax category
    public String key;

    public String name;

    public  String description;


    public String rateName;
    public String country;
    public  Boolean includedInPrice;

    //update tax category
    public  Long version;
    public String actions;

    public  String changeName;
}
