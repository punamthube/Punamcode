package com.exampleCt.demoCommercetools.TaxCategory;

import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.models.tax_category.TaxCategory;
import com.commercetools.api.models.tax_category.TaxCategoryPagedQueryResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/TaxCategory")
public class TaxCategoryController {

    @Autowired
    TaxCategoryService taxCategoryService;

    @Autowired
    ProjectApiRoot projectApiRoot;

    @PostMapping
    public TaxCategory createTaxCategory(@RequestBody TaxCategoryDTO taxCategoryDTO)
    {
        return taxCategoryService.createTaxCategory(taxCategoryDTO);
    }
    @GetMapping
    public TaxCategoryPagedQueryResponse getAllTaxCategory()
    {
        return projectApiRoot.taxCategories().get().executeBlocking().getBody();
    }
    @GetMapping("/{id}")
    public TaxCategory getTaxCategoryById(@PathVariable String id)
    {
        return projectApiRoot.taxCategories().withId(id).get().executeBlocking().getBody();

    }
    @DeleteMapping("/{id}")
    public String deleteCategoryById(@PathVariable String id)
    {
         projectApiRoot.taxCategories().withId(id).delete().addVersion(1).executeBlocking();

         return "Deleted TaxCategory";
    }

    @PostMapping("/update/{id}")
    public  TaxCategory updateTaxCategory(@PathVariable String id,@RequestBody TaxCategoryDTO taxCategoryDTO)
    {
        return taxCategoryService.updateTaxCategory(id,taxCategoryDTO);
    }



}
