package com.exampleCt.demoCommercetools.ProductDiscount;

import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.models.product_discount.ProductDiscount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ProductDiscount")
public class ProductDiscountController {


    @Autowired
    ProductDiscountService productDiscountService;

    @Autowired
    ProjectApiRoot projectApiRoot;


    @PostMapping
    public ProductDiscount createProductDiscount(@RequestBody ProductDiscountData productDiscountData)
    {
        return  productDiscountService.createProductDiscount(productDiscountData);
    }

}
