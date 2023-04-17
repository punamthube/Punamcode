package com.exampleCt.demoCommercetools.Review;

import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.models.review.Review;
import com.commercetools.api.models.review.ReviewPagedQueryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Review")
public class ReviewController {
    @Autowired
    ReviewService reviewService;

    @Autowired
    ProjectApiRoot projectApiRoot;

    @PostMapping
    public Review createReview(@RequestBody ReviewData reviewData)
    {
        return reviewService.createReview(reviewData);
    }
    @GetMapping
    public ReviewPagedQueryResponse getAllReview()
    {
        return projectApiRoot.reviews().get().executeBlocking().getBody();
    }

    @PostMapping("/{id}")
    public Review getReviewById(@PathVariable String id){
        return projectApiRoot.reviews().withId(id).get().executeBlocking().getBody();
    }

    @DeleteMapping("/{id}")
    public String deleteReviewById(@PathVariable String id){
        Long vesion =getReviewById(id).getVersion();
         projectApiRoot.reviews().withId(id).delete().addVersion(vesion).executeBlocking();
         return "Review is Deleted";
    }




}
