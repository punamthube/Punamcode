package com.exampleCt.demoCommercetools.ShippingMethods;


import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.models.shipping_method.ShippingMethod;
import com.commercetools.api.models.shipping_method.ShippingMethodPagedQueryResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Shipping-Method")
@Slf4j
public class Controller {

    @Autowired
    ShippingMethodService shippingMethodService;

    @Autowired
    ProjectApiRoot projectApiRoot;


    @PostMapping
    public ShippingMethod createShippingMethods(@RequestBody ShippingMethodData shippingMethodData)
    {
        return shippingMethodService.createShippingMethods(shippingMethodData);
    }

    @GetMapping
    public ShippingMethodPagedQueryResponse getAllShippingMethods()
    {
        return projectApiRoot.shippingMethods().get().executeBlocking().getBody();
    }
}
