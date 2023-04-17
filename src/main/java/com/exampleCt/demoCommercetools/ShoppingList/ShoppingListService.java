package com.exampleCt.demoCommercetools.ShoppingList;

import com.commercetools.api.models.common.LocalizedString;
import com.commercetools.api.models.common.UpdateAction;
import com.commercetools.api.models.shopping_list.*;
import io.vrap.rmf.base.client.Builder;
import org.springframework.stereotype.Service;

@Service
public class ShoppingListService {

    static ShoppingListDataProvider sldp = new ShoppingListDataProvider();

    //update Shopping list
    public static ShoppingList updateShoppingList(String id, ShoppingListData shoppingListData) {
        ShoppingListUpdate shoppingListUpdate = ShoppingListUpdate
                .builder()
                .version(shoppingListData.getVersion())
                .actions(ShoppingListUpdateAction.addLineItemBuilder()
                        .productId(shoppingListData.getProductId())
                        .quantity(shoppingListData.getQuantity()).build())

                .plusActions(ShoppingListUpdateAction.addLineItemBuilder()
                        .productId(shoppingListData.getProductId2()).build())
                .build();
        return sldp.updateShoppingList(shoppingListUpdate,id);
    }

    //delete LineItem in shopping List
    public static ShoppingList DeleteProductInShoppingList(String id, ShoppingListData shoppingListData) {

        ShoppingListUpdate shoppingListUpdate = ShoppingListUpdate
                .builder()
                .version(shoppingListData.getVersion())
                .actions(ShoppingListUpdateAction.removeLineItemBuilder().lineItemId(shoppingListData.getLineItemId()).build())
                .build();
        return sldp.DeleteProductInShoppingList(shoppingListUpdate,id);
    }

    //create Shopping List
    public ShoppingList createShoppingList(ShoppingListData shoppingListData) {

        ShoppingListDraft shoppingListDraft = ShoppingListDraft
                .builder()
                .key(shoppingListData.getKey())
                .name(LocalizedString.ofEnglish(shoppingListData.getName()))
                .description(LocalizedString.ofEnglish(shoppingListData.getDescription()))
                .lineItems(ShoppingListLineItemDraft.builder().productId(shoppingListData.getProductId()).build())
                .build();
        return sldp.createShoppingList(shoppingListDraft);

    }

}
