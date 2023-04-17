package com.exampleCt.demoCommercetools.TaxCategory;

import com.commercetools.api.models.tax_category.TaxCategory;
import com.commercetools.api.models.tax_category.TaxCategoryDraft;

import com.commercetools.api.models.tax_category.TaxCategoryUpdate;
import com.commercetools.api.models.tax_category.TaxCategoryUpdateAction;
import org.springframework.stereotype.Service;

@Service
public class TaxCategoryService {

    static TaxCategoryDataProvider TDP = new TaxCategoryDataProvider();

    public static TaxCategory createTaxCategory(TaxCategoryDTO taxCategoryDTO)
    {
        TaxCategoryDraft taxCategoryDraft = TaxCategoryDraft
                .builder()
                .key(taxCategoryDTO.getKey())
                .name(taxCategoryDTO.getName())
                .description(taxCategoryDTO.getDescription())
               // .rates(TaxRateDraft.builder().build())
                .build();
        return TDP.createTaxCategory(taxCategoryDraft);

    }

    public TaxCategory updateTaxCategory(String id, TaxCategoryDTO taxCategoryDTO)
    {
        TaxCategoryUpdate taxCategoryUpdate = TaxCategoryUpdate
                .builder()
                .version(taxCategoryDTO.getVersion())
                .actions(TaxCategoryUpdateAction.changeNameBuilder().name(taxCategoryDTO.getChangeName()).build())
                .build();

        return TDP.updateTaxCategory(taxCategoryUpdate,id);
    }
}
