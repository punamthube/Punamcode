package com.exampleCt.demoCommercetools.Inventory;


import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;

@Setter
@Getter
public class InventoryData
{

    public String sku;

    public Long quantityOnStock;

    public Long restockableInDays;

    public  String key;

    public ZonedDateTime expectedDelivery;

    public String supplyChannel;

    //Update Inventory

    public  String actions;

    public  String version;
}
