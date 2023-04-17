package com.exampleCt.demoCommercetools.ShoppingList;

import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.models.shopping_list.ShoppingList;
import com.commercetools.api.models.shopping_list.ShoppingListDraft;
import com.commercetools.api.models.shopping_list.ShoppingListUpdate;
import com.exampleCt.demoCommercetools.Client;

public class ShoppingListDataProvider {

    ProjectApiRoot apiRoot = new Client().createApiClient();
    public ShoppingList createShoppingList(ShoppingListDraft shoppingListDraft)
    {
         return apiRoot.shoppingLists().post(shoppingListDraft).executeBlocking().getBody();
    }


    public ShoppingList updateShoppingList(ShoppingListUpdate shoppingListUpdate, String id) {
        return  apiRoot.shoppingLists().withId(id).post(shoppingListUpdate).executeBlocking().getBody();
    }


    public ShoppingList DeleteProductInShoppingList(ShoppingListUpdate shoppingListUpdate, String id) {
        return  apiRoot.shoppingLists().withId(id).post(shoppingListUpdate).executeBlocking().getBody();

    }
}
