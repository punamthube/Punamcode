package com.exampleCt.demoCommercetools.Review;

import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.models.review.Review;
import com.commercetools.api.models.review.ReviewDraft;
import com.exampleCt.demoCommercetools.Client;

public class ReviewDataProvider {

    ProjectApiRoot apiRoot = new Client().createApiClient();


    public Review createReview(ReviewDraft reviewDraft)
    {
        return apiRoot.reviews().post(reviewDraft).executeBlocking().getBody();
    }
}
