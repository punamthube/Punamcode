package com.exampleCt.demoCommercetools.Inventory;


import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.models.inventory.InventoryEntry;
import com.commercetools.api.models.inventory.InventoryPagedQueryResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Inventory")
@Slf4j
public class InventoryController
{

    @Autowired
    InventoryService inventoryService;

    @Autowired
    ProjectApiRoot projectApiRoot;

    @PostMapping
   public InventoryEntry createInventory(@RequestBody InventoryData inventoryData){
        return inventoryService.createInventory(inventoryData);
    }


    @GetMapping
   public InventoryPagedQueryResponse getAllInventory()
    {
        return projectApiRoot.inventory().get().executeBlocking().getBody();
    }

    @GetMapping("/{id}")
   public InventoryEntry getInventoryById(@PathVariable String id)
    {
        return projectApiRoot.inventory().withId(id).get().executeBlocking().getBody();
    }

/*
    @PostMapping("/{update/id}")
    InventoryEntry updateInventoryById(@PathVariable String id,@RequestBody InventoryData inventoryData)
    {
        return inventoryService.updateInventoryById(id,inventoryData);
    }
*/



}
