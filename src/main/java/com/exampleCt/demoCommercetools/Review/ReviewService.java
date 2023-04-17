package com.exampleCt.demoCommercetools.Review;

import com.commercetools.api.models.common.ResourceIdentifier;

import com.commercetools.api.models.review.Review;
import com.commercetools.api.models.review.ReviewDraft;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {


    ReviewDataProvider RDP = new ReviewDataProvider();


    public Review createReview(ReviewData reviewData) {

        ReviewDraft reviewDraft = ReviewDraft
                .builder()
                .key(reviewData.getKey())
                .authorName(reviewData.getAuthorName())
                .title(reviewData.getTitle())
                .text(reviewData.getText())
                .rating(reviewData.getRating())
               // .target((ResourceIdentifier) ResourceIdentifier.productBuilder().id(reviewData.getTypeId()))
                .target(ResourceIdentifier.productBuilder()
                      //  .id(reviewData.getTypeId())
                        .id(reviewData.getProductId()).build())
                .build();
        return RDP.createReview(reviewDraft);
    }
}
