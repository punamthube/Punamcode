package com.exampleCt.demoCommercetools.ProductDiscount;


import com.commercetools.api.models.common.LocalizedString;
import com.commercetools.api.models.product_discount.ProductDiscount;
import com.commercetools.api.models.product_discount.ProductDiscountDraft;
import com.commercetools.api.models.product_discount.ProductDiscountValueDraft;
import org.springframework.stereotype.Service;

@Service
public class ProductDiscountService {

    ProductDiscountDataProvider PDDP = new ProductDiscountDataProvider();


    public ProductDiscount createProductDiscount(ProductDiscountData productDiscountData) {
        ProductDiscountDraft productDiscountDraft = ProductDiscountDraft
                .builder()
                .key(productDiscountData.getKey())
                .name(LocalizedString.ofEnglish(productDiscountData.getName()))
                .description(LocalizedString.ofEnglish(productDiscountData.getDescription()))
                .isActive(productDiscountData.getIsActive())
                .predicate(productDiscountData.getPredicate())
               // .value(ProductDiscountValueDraft)

                .build();

        return PDDP.createProductDiscount(productDiscountDraft);
    }
}
