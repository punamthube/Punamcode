package com.exampleCt.demoCommercetools.ShippingMethods;

import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.models.shipping_method.ShippingMethod;
import com.commercetools.api.models.shipping_method.ShippingMethodDraft;
import com.exampleCt.demoCommercetools.Client;

public class ShippingMethodDataProvider {

    ProjectApiRoot apiRoot= new Client().createApiClient();

    public ShippingMethod createShippingMethods(ShippingMethodDraft shippingMethodDraft)
    {
        return apiRoot.shippingMethods().post(shippingMethodDraft).executeBlocking().getBody();
    }
}
