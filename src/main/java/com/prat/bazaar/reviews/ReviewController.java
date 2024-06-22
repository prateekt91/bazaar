package com.prat.bazaar.reviews;

import com.prat.bazaar.model.Reviews;
import com.prat.bazaar.service.ReviewsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/review")
public class ReviewController {


    private static final Logger log = LoggerFactory.getLogger(ReviewController.class);

    @Autowired
    ReviewsService reviewsService;

    @PostMapping("/create")
    public Boolean createReview(@RequestBody List<Reviews> review) {
        log.info("Inside createReview method");
        return !reviewsService.createReviews(review).isEmpty();
    }

    @GetMapping("/{userId}")
    public List<Reviews> getReviewByUserId(@PathVariable String userId) {
        log.info("Inside getReviewByUserId method");
        return reviewsService.getReviewsByUserId(userId);
    }
}
