package com.exampleCt.demoCommercetools.Inventory;

import com.commercetools.api.models.inventory.InventoryEntry;
import com.commercetools.api.models.inventory.InventoryEntryDraft;
import com.commercetools.api.models.inventory.InventoryEntryUpdate;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {


    InventoryDataProvider Idp = new InventoryDataProvider();

    public InventoryEntry createInventory(InventoryData inventoryData)
    {

        InventoryEntryDraft inventoryEntryDraft = InventoryEntryDraft
                .builder()
                .sku(inventoryData.getSku())
                .quantityOnStock(inventoryData.getQuantityOnStock())
                .key(inventoryData.getKey())
                .restockableInDays(inventoryData.getRestockableInDays())
              //  .expectedDelivery(inventoryData.getExpectedDelivery())
               // .supplyChannel(inventoryData.getExpectedDelivery())
                .build();
        return Idp.createInventory(inventoryEntryDraft);
    }


    /*public InventoryEntry updateInventoryById(String id, InventoryData inventoryData) {

        InventoryEntryUpdate inventoryEntryUpdate = InventoryEntryUpdate
                .builder()

                .build();
        return Idp.updateInventoryById(id,inventoryData);
    }*/
}
