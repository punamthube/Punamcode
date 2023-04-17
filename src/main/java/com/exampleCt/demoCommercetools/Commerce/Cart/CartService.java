package com.exampleCt.demoCommercetools.Commerce.Cart;

import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.models.cart.*;
import com.commercetools.api.models.cart_discount.*;
import com.commercetools.api.models.common.BaseAddress;
import com.commercetools.api.models.common.BaseAddressBuilder;
import com.commercetools.api.models.common.LocalizedString;
import com.commercetools.api.models.common.Money;
import com.commercetools.api.models.discount_code.DiscountCode;
import com.commercetools.api.models.discount_code.DiscountCodeDraft;


import com.exampleCt.demoCommercetools.Client;
import org.springframework.stereotype.Service;

import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class CartService {

    CartDataProvider cdpp = new CartDataProvider();
    ProjectApiRoot apiRoot = new Client().createApiClient();

    public Cart createCart(CartData cartData){
        CartDraft cartDraft = CartDraft
                .builder()
                .currency(cartData.getCurrency())
              .lineItems(cartData.getLineItems().stream().map(e->LineItemDraft.builder()
                      .sku(e.getSku())
                      .quantity(e.getQuantity())
                      .build()).collect(Collectors.toList()))
                .discountCodes(cartData.getDiscountCode())
                .taxMode(TaxMode.DISABLED)

                .build();
        return cdpp.createCart(cartDraft);
    }


    public Cart updateCart(String id, CartData cartData) {
        Cart cart = getCartById(id);
        CartUpdate cartUpdate = CartUpdate
                .builder()
                .version(cart.getVersion())

                .actions(CartChangeLineItemQuantityAction.builder()
                        .quantity(cartData.getQuantity())
                        .lineItemId(cartData.getLineItems().get(0).getId()).build())

                .build();
        return cdpp.updateCart(id,cartUpdate);
    }
    public Cart getCartById(String id)
    {
        Cart cart = apiRoot.carts().withId(id).get().executeBlocking().getBody();
        return cart;
    }

    public Cart addLineItem(CartData cartData,String id) {
        CartUpdate cartUpdate = CartUpdate.builder()
                .version(cartData.getVersion())
                .actions(CartAddLineItemAction.builder().sku(cartData.getLineItems().get(0).getSku()).build())
              //  .actions(CartAddItemShippingAddressAction.builder().address(cartData.getShippingAddress()).build())
                .plusActions(CartAddItemShippingAddressAction.builder().address(cartData.getShippingAddress1()).build())
                .plusActions(CartAddItemShippingAddressAction.builder().address(cartData.getShippingAddress2()).build())
               // .actions(CartAddItemShippingAddressAction.builder().address((Function<BaseAddressBuilder, BaseAddressBuilder>) BaseAddress.builder(cartData.getShippingAddress())).build())
                .build();
        return cdpp.addLineItem(cartUpdate,id);
    }
    public CartDiscount createCartDiscount(CartData cartData) {
        CartDiscountDraft cartDiscountDraft = CartDiscountDraft
                .builder()
                .name(LocalizedString.ofEnglish(cartData.getName()))
                .key(cartData.getKey())
                .description(LocalizedString.ofEnglish(cartData.getDescription()))
                .value(CartDiscountValueDraft.absoluteBuilder().money(Money.builder().currencyCode("USD").centAmount(500l).build()).build())
                .isActive(cartData.getIsActive())
                .cartPredicate(cartData.getCartPredicate())
                .sortOrder(cartData.getSortOrder())
                .target(CartDiscountTargetBuilder.of().lineItemsBuilder().predicate("1=1").build())
                .requiresDiscountCode(cartData.getRequiresDiscountCode())

                .build();
        return  cdpp.createCartDiscount(cartDiscountDraft);
    }

    public DiscountCode createCodeDiscount(CartData cartData) {
        DiscountCodeDraft discountCodeDraft = DiscountCodeDraft
                .builder()
                .code(cartData.getCode())
                .name(LocalizedString.ofEnglish(cartData.getName()))
                .cartDiscounts(CartDiscountResourceIdentifier.builder().id(cartData.getCartId()).build())
                .isActive(cartData.getIsActive())
                .cartPredicate(cartData.getCartPredicate())
                .build();

        return cdpp.createCodeDiscount(discountCodeDraft);
    }
}
