package com.exampleCt.demoCommercetools.ShoppingList;


import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.models.shopping_list.ShoppingList;
import com.commercetools.api.models.shopping_list.ShoppingListPagedQueryResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shoppingList")
@Slf4j
public class ShoppingListController {

    @Autowired
    ShoppingListService shoppingListService;

    @Autowired
    ProjectApiRoot apiRoot;


    @PostMapping
    public ShoppingList createShoppingList(@RequestBody ShoppingListData shoppingListData)
    {
        return shoppingListService.createShoppingList(shoppingListData);
    }
    @GetMapping
    public ShoppingListPagedQueryResponse getallShoppingList()
    {
        return apiRoot.shoppingLists().get().executeBlocking().getBody();
    }

    @GetMapping("/{id}")
    public ShoppingList getshoppingListById(@PathVariable String id)
    {
        return apiRoot.shoppingLists().withId(id).get().executeBlocking().getBody();
    }

    @DeleteMapping("/{id}")
    public String deleteShoppingList(@PathVariable String id)
    {
          apiRoot.shoppingLists().withId(id).delete().addVersion(1).executeBlocking();
          return "shoppingList Deleted";
    }
    @PostMapping("/update/{id}")
    public ShoppingList updateShoppingList(@PathVariable String id, @RequestBody ShoppingListData ShoppingListData)
    {
        return ShoppingListService.updateShoppingList(id ,ShoppingListData);
    }

    @PostMapping("/removeLineItem/{id}")
    public String DeleteProductInShoppingList(@PathVariable String id,@RequestBody ShoppingListData shoppingListData){
         ShoppingListService.DeleteProductInShoppingList(id,shoppingListData);
         return "Lineitem Deleted";
    }

}
