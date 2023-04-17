package com.exampleCt.demoCommercetools.ProductDiscount;

import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.models.product_discount.ProductDiscount;
import com.commercetools.api.models.product_discount.ProductDiscountDraft;
import com.exampleCt.demoCommercetools.Client;

public class ProductDiscountDataProvider {

    ProjectApiRoot projectApiRoot = new Client().createApiClient();

    public ProductDiscount createProductDiscount(ProductDiscountDraft productDiscountDraft)
    {
        return projectApiRoot.productDiscounts().post(productDiscountDraft).executeBlocking().getBody();
    }
}
