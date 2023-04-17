package com.exampleCt.demoCommercetools.ShippingMethods;


import com.commercetools.api.models.shipping_method.ShippingMethod;
import com.commercetools.api.models.shipping_method.ShippingMethodDraft;
import com.commercetools.api.models.shipping_method.ShippingRateDraft;
import com.commercetools.api.models.shipping_method.ZoneRateDraft;
import com.commercetools.api.models.tax_category.TaxCategoryResourceIdentifier;
import com.commercetools.api.models.zone.ZoneResourceIdentifier;
import org.springframework.stereotype.Service;

@Service
public class ShippingMethodService {

    ShippingMethodDataProvider SMDP = new ShippingMethodDataProvider();


    public ShippingMethod createShippingMethods(ShippingMethodData shippingMethodData)
    {

        ShippingMethodDraft shippingMethodDraft = ShippingMethodDraft
                .builder()
                .name(shippingMethodData.getName())
                .key(shippingMethodData.getKey())
                .isDefault(shippingMethodData.getIsDefault())
                .zoneRates(ZoneRateDraft.builder()
                        .zone(ZoneResourceIdentifier.builder().id(shippingMethodData.getZoneId()).build())
                        .shippingRates(ShippingRateDraft.builder()
                                .price(moneyBuilder -> moneyBuilder.centAmount(shippingMethodData.getCentAmount())
                                        .currencyCode(shippingMethodData.getCurrencyCode())).build())

                        .build())
                .taxCategory(TaxCategoryResourceIdentifier.builder().id(shippingMethodData.getTaxId()).build())
                .build();
        return SMDP.createShippingMethods(shippingMethodDraft);
    }
}
