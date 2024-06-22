package com.prat.bazaar.service;

import com.prat.bazaar.model.Reviews;
import com.prat.bazaar.repositories.ReviewsRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewsServiceImpl implements ReviewsService {

    private static final Logger log = LoggerFactory.getLogger(ReviewsServiceImpl.class);

    @Autowired
    ReviewsRepo reviewsRepo;

    @Override
    public List<Reviews> createReviews(List<Reviews> reviews) {

       return reviewsRepo.saveAll(reviews);

    }

    @Override
    public List<Reviews> getReviewsByUserId(String userId) {
        return reviewsRepo.findByUserId(userId);
    }
}
