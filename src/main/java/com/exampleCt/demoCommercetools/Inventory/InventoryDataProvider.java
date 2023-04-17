package com.exampleCt.demoCommercetools.Inventory;

import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.models.inventory.InventoryEntry;
import com.commercetools.api.models.inventory.InventoryEntryDraft;
import com.exampleCt.demoCommercetools.Client;

public class InventoryDataProvider {


    ProjectApiRoot apiRoot = new Client().createApiClient();
    public InventoryEntry createInventory(InventoryEntryDraft inventoryEntryDraft)
    {
        return apiRoot.inventory().post(inventoryEntryDraft).executeBlocking().getBody();
    }

   /* public InventoryEntry updateInventoryById(String id, InventoryData inventoryData) {

    }*/
}
