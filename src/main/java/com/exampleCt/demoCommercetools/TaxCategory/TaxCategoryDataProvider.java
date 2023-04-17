package com.exampleCt.demoCommercetools.TaxCategory;

import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.models.tax_category.TaxCategory;
import com.commercetools.api.models.tax_category.TaxCategoryDraft;
import com.commercetools.api.models.tax_category.TaxCategoryUpdate;
import com.exampleCt.demoCommercetools.Client;

public class TaxCategoryDataProvider {

    ProjectApiRoot apiRoot = new Client().createApiClient();


    public TaxCategory createTaxCategory(TaxCategoryDraft taxCategoryDraft)
    {
        return apiRoot.taxCategories().post(taxCategoryDraft).executeBlocking().getBody();
    }

    public TaxCategory updateTaxCategory(TaxCategoryUpdate taxCategoryUpdate, String id)
    {

        return  apiRoot.taxCategories().withId(id).post(taxCategoryUpdate).executeBlocking().getBody();
    }
}
