package com.exampleCt.demoCommercetools.ShoppingList;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ShoppingListData {

    public  String productId;
    public  String productId2;
    public  String name;
    public String key;
    public  String description;

    //update shopping list
    public Long version;

    public  Long quantity;

    public String lineItemId;
    public  String action;


}
